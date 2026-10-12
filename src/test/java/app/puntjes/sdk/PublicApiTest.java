package app.puntjes.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class PublicApiTest {
    private static final Set<String> PUBLIC_API = Set.of(
            "app.puntjes.sdk.IdempotencyKey",
            "app.puntjes.sdk.Paginator",
            "app.puntjes.sdk.Paginator$Page",
            "app.puntjes.sdk.PuntjesClientFactory",
            "app.puntjes.sdk.PuntjesOptions",
            "app.puntjes.sdk.PuntjesOptions$Builder",
            "app.puntjes.sdk.PuntjesOptions$Sleeper",
            "app.puntjes.sdk.WalletPass",
            "app.puntjes.sdk.auth.AccessToken",
            "app.puntjes.sdk.auth.InMemoryTokenStore",
            "app.puntjes.sdk.auth.TokenStore",
            "app.puntjes.sdk.exceptions.ApiError",
            "app.puntjes.sdk.exceptions.AuthenticationException",
            "app.puntjes.sdk.exceptions.ConflictException",
            "app.puntjes.sdk.exceptions.ForbiddenException",
            "app.puntjes.sdk.exceptions.NotFoundException",
            "app.puntjes.sdk.exceptions.PlanLimitExceededException",
            "app.puntjes.sdk.exceptions.PuntjesException",
            "app.puntjes.sdk.exceptions.RateLimitException",
            "app.puntjes.sdk.exceptions.ServerException",
            "app.puntjes.sdk.exceptions.TransportException",
            "app.puntjes.sdk.exceptions.ValidationException");

    @Test
    void onlyTheDocumentedTypesArePublicOutsideTheGeneratedCode() throws IOException, URISyntaxException {
        Path classes = Path.of(PuntjesClientFactory.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        Set<String> found = new TreeSet<>();
        try (Stream<Path> files = Files.walk(classes)) {
            for (Path file : files.filter(f -> f.toString().endsWith(".class")).toList()) {
                String name = classes.relativize(file).toString().replace(file.getFileSystem().getSeparator(), ".")
                        .replaceAll("\\.class$", "");
                if (!name.startsWith("app.puntjes.sdk.generated.") && isPublic(name)) {
                    found.add(name);
                }
            }
        }

        assertEquals(new TreeSet<>(PUBLIC_API), found);
    }

    private static boolean isPublic(String name) {
        try {
            for (Class<?> type = Class.forName(name, false, PublicApiTest.class.getClassLoader()); type != null;
                    type = type.getDeclaringClass()) {
                if (!Modifier.isPublic(type.getModifiers())) {
                    return false;
                }
            }
            return true;
        } catch (ClassNotFoundException unreadable) {
            throw new IllegalStateException(name, unreadable);
        }
    }
}
