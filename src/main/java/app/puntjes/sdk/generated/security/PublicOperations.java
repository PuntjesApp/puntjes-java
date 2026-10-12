package app.puntjes.sdk.generated.security;

import java.util.List;

/** The operations whose security in spec/api.json is empty, so they are sent without a token. Do not edit. */
public final class PublicOperations {

    private static final List<String> OPERATIONS = List.of(
            "GET /health");

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
