package app.puntjes.tools;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/** Writes the Java the thin layer reads from spec/api.json: the error codes and the operations sent without a token. */
public final class SpecCodegen {

    private static final Set<String> METHODS = Set.of("get", "put", "post", "delete", "patch", "head", "options");

    private SpecCodegen() {}

    /** One documented error code and the HTTP status it comes with. */
    public record ErrorCodeEntry(String code, int status) {}

    /** The distinct error codes of the spec, sorted by code; a code with two statuses is refused. */
    public static List<ErrorCodeEntry> errorCodes(JsonNode spec) {
        Map<String, Integer> codes = new TreeMap<>();
        collect(spec, codes);

        return codes.entrySet().stream()
                .map(entry -> new ErrorCodeEntry(entry.getKey(), entry.getValue()))
                .toList();
    }

    /** The operations that declare an empty security list, as {@code METHOD /path}. */
    public static List<String> publicOperations(JsonNode spec) {
        List<String> operations = new ArrayList<>();
        spec.path("paths").properties().forEach(path -> path.getValue().properties().stream()
                .filter(operation -> METHODS.contains(operation.getKey()))
                .filter(operation -> hasEmptySecurity(operation.getValue()))
                .forEach(operation -> operations.add(operation.getKey().toUpperCase() + " " + path.getKey())));
        operations.sort(null);

        return operations;
    }

    /** The source of the {@code ErrorCode} enum. */
    public static String renderErrorCode(List<ErrorCodeEntry> codes) {
        String constants = codes.stream()
                .map(entry -> "    %s(\"%s\", %d)".formatted(entry.code(), entry.code(), entry.status()))
                .collect(Collectors.joining(",\n"));

        return """
                package app.puntjes.sdk.generated.errors;

                import java.util.Arrays;
                import java.util.Map;
                import java.util.Optional;
                import java.util.function.Function;
                import java.util.stream.Collectors;

                /** Every error code the API documents, generated from the x-error-codes of spec/api.json. Do not edit. */
                public enum ErrorCode {
                %s;

                    private static final Map<String, ErrorCode> BY_WIRE =
                            Arrays.stream(values()).collect(Collectors.toMap(ErrorCode::wire, Function.identity()));

                    private final String wire;
                    private final int status;

                    ErrorCode(String wire, int status) {
                        this.wire = wire;
                        this.status = status;
                    }

                    public String wire() {
                        return wire;
                    }

                    public int status() {
                        return status;
                    }

                    public static Optional<ErrorCode> fromWire(String wire) {
                        return Optional.ofNullable(BY_WIRE.get(wire));
                    }
                }
                """.formatted(constants);
    }

    /** The source of the {@code PublicOperations} matcher. */
    public static String renderPublicOperations(List<String> operations) {
        String list = operations.stream()
                .map(operation -> "            \"" + operation + "\"")
                .collect(Collectors.joining(",\n"));

        return """
                package app.puntjes.sdk.generated.security;

                import java.util.List;

                /** The operations whose security in spec/api.json is empty, so they are sent without a token. Do not edit. */
                public final class PublicOperations {

                    private static final List<String> OPERATIONS = List.of(
                %s);

                    private PublicOperations() {}

                    public static boolean matches(String method, String path) {
                        String[] segments = path.split("/", -1);
                        for (String operation : OPERATIONS) {
                            String[] parts = operation.split(" ", 2);
                            if (parts[0].equalsIgnoreCase(method) && fits(parts[1].split("/", -1), segments)) {
                                return true;
                            }
                        }
                        return false;
                    }

                    private static boolean fits(String[] template, String[] path) {
                        if (template.length != path.length) {
                            return false;
                        }
                        for (int i = 0; i < template.length; i++) {
                            boolean isParameter = template[i].startsWith("{") && template[i].endsWith("}");
                            if (isParameter ? path[i].isEmpty() : !path[i].equals(template[i])) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                """.formatted(list);
    }

    private static boolean hasEmptySecurity(JsonNode operation) {
        JsonNode security = operation.get("security");

        return security != null && security.isArray() && security.isEmpty();
    }

    private static void collect(JsonNode node, Map<String, Integer> codes) {
        if (node.isObject() && node.has("x-error-codes")) {
            for (JsonNode entry : node.get("x-error-codes")) {
                record(entry.get("code").asText(), entry.get("status").asInt(), codes);
            }
        }
        node.forEach(child -> collect(child, codes));
    }

    private static void record(String code, int status, Map<String, Integer> codes) {
        Integer known = codes.putIfAbsent(code, status);
        if (known != null && known != status) {
            throw new IllegalStateException(code + " has two statuses, " + known + " and " + status + ".");
        }
    }
}
