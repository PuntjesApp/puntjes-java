package app.puntjes.tools;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Kiota makes every request body a required argument and ignores {@code requestBody.required}. This step makes a
 * body that the spec does not require optional again: nullable, sent only when given, and with overloads that omit
 * it. An unexpected generated shape fails the generation.
 */
public final class OptionalBodies {

    private static final Set<String> METHODS = Set.of("post", "put", "patch");
    private static final Pattern TEMPLATE = Pattern.compile("\"\\{\\+baseurl}([^\"{?]*(?:\\{[^?}][^}]*}[^\"{?]*)*)");
    private static final String NONNULL = "@jakarta.annotation.Nonnull final ";
    private static final String NULLABLE = "@jakarta.annotation.Nullable final ";
    private static final String REQUIRE = "        Objects.requireNonNull(body);\n";
    private static final String CONTENT = "        requestInfo.setContentFromParsable(requestAdapter, \"application/json\", body);\n";

    private OptionalBodies() {}

    /** Rewrites, under {@code outDir}, the builder of each operation whose body is not {@code required: true}. */
    public static void apply(JsonNode spec, Path outDir) throws IOException {
        Map<String, Path> builders = builders(outDir);
        for (Map.Entry<String, JsonNode> path : spec.path("paths").properties()) {
            for (Map.Entry<String, JsonNode> operation : path.getValue().properties()) {
                JsonNode body = operation.getValue().get("requestBody");
                if (METHODS.contains(operation.getKey()) && body != null && !body.path("required").asBoolean(false)) {
                    Path file = builders.get(path.getKey());
                    if (file == null) {
                        throw new IllegalStateException("No generated builder has the path " + path.getKey() + ".");
                    }
                    String name = outDir.relativize(file).toString();
                    Files.writeString(file, rewrite(Files.readString(file), operation.getKey(), name));
                }
            }
        }
    }

    /** The builder source with an optional body for {@code method}; {@code name} names the file in an error. */
    public static String rewrite(String source, String method, String name) {
        String type = method.substring(0, 1).toUpperCase() + method.substring(1);
        String config = "java.util.function.Consumer<" + type + "RequestConfiguration> requestConfiguration";
        Matcher sendOne = only(source, "public (\\S+) " + method + "\\(" + Pattern.quote(NONNULL) + "(\\w+) body\\) \\{\n",
                name, method);
        String result = sendOne.group(1);
        String body = sendOne.group(2);
        String sendTwo = "public " + result + " " + method + "(" + NONNULL + body + " body, " + NULLABLE + config + ") {\n" + REQUIRE;
        String buildOne = "public RequestInformation to" + type + "RequestInformation(" + NONNULL + body + " body) {\n";
        String buildTwo = "public RequestInformation to" + type + "RequestInformation(" + NONNULL + body + " body, "
                + NULLABLE + config + ") {\n" + REQUIRE;
        for (String part : List.of(sendTwo, buildOne, buildTwo)) {
            once(source, part, name, method);
        }

        String out = source
                .replace(sendOne.group(), sendOne.group().replace(NONNULL, NULLABLE))
                .replace(buildOne, buildOne.replace(NONNULL, NULLABLE));
        out = after(out, sendTwo, sendTwo.replace(NONNULL + body, NULLABLE + body).replace(REQUIRE, ""),
                overloads(result, method, method, config, "@jakarta.annotation.Nullable"), name, method, false);
        out = after(out, buildTwo, buildTwo.replace(NONNULL + body, NULLABLE + body).replace(REQUIRE, ""),
                overloads("RequestInformation", "to" + type + "RequestInformation", method, config, "@jakarta.annotation.Nonnull"),
                name, method, true);

        return out;
    }

    private static String after(String source, String header, String newHeader, String overloads, String name,
            String method, boolean guardContent) {
        int start = source.indexOf(header);
        int end = source.indexOf("\n    }\n", start) + "\n    }\n".length();
        String block = source.substring(start, end).replace(header, newHeader);
        if (guardContent) {
            once(block, CONTENT, name, method);
            block = block.replace(CONTENT, "        if (body != null) {\n    " + CONTENT + "        }\n");
        }

        return source.substring(0, start) + block + overloads + source.substring(end);
    }

    private static String overloads(String result, String called, String method, String config, String annotation) {
        String call = ("void".equals(result) ? "" : "return ") + called;
        String returns = "void".equals(result) ? "" : "     * @return a {@link " + result + "}\n";

        return """
                    /**
                     * Without a body: the spec makes the %s body optional.
                %s     */
                    %s
                    public %s %s() {
                        %s(null, null);
                    }
                    /**
                     * Without a body: the spec makes the %s body optional.
                     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
                %s     */
                    %s
                    public %s %s(%s%s) {
                        %s(null, requestConfiguration);
                    }
                """.formatted(method, returns, annotation, result, called, call,
                method, returns, annotation, result, called, NULLABLE, config, call);
    }

    private static Matcher only(String source, String regex, String name, String method) {
        List<Matcher> found = Pattern.compile(regex).matcher(source).results().map(r -> {
            Matcher matcher = Pattern.compile(regex).matcher(r.group());
            matcher.matches();
            return matcher;
        }).toList();
        if (found.size() != 1) {
            throw shape(name, method, regex);
        }

        return found.get(0);
    }

    private static void once(String source, String part, String name, String method) {
        int first = source.indexOf(part);
        if (first < 0 || source.indexOf(part, first + 1) >= 0) {
            throw shape(name, method, part);
        }
    }

    private static IllegalStateException shape(String name, String method, String expected) {
        return new IllegalStateException(name + ": the " + method + " body has an unknown generated shape. Expected once: "
                + expected.strip());
    }

    private static Map<String, Path> builders(Path outDir) throws IOException {
        Map<String, Path> builders = new HashMap<>();
        try (Stream<Path> files = Files.walk(outDir)) {
            for (Path file : files.filter(f -> f.toString().endsWith("RequestBuilder.java")).toList()) {
                Matcher matcher = TEMPLATE.matcher(Files.readString(file));
                while (matcher.find()) {
                    Path known = builders.putIfAbsent(matcher.group(1), file);
                    if (known != null && !known.equals(file)) {
                        throw new IllegalStateException("Two builders have the path " + matcher.group(1) + ".");
                    }
                }
            }
        }

        return builders;
    }
}
