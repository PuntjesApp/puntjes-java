package app.puntjes.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class SpecCodegenTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static JsonNode fixture() throws IOException {
        try (InputStream stream = SpecCodegenTest.class.getResourceAsStream("/codegen-spec.json")) {
            return MAPPER.readTree(stream);
        }
    }

    @Test
    void errorCodesAreDistinctSortedAndCarryTheirStatus() throws IOException {
        assertEquals(
                List.of(
                        new SpecCodegen.ErrorCodeEntry("CUSTOMER_NOT_FOUND", 404),
                        new SpecCodegen.ErrorCodeEntry("PLAN_LIMIT_EXCEEDED", 429),
                        new SpecCodegen.ErrorCodeEntry("RATE_LIMITED", 429)),
                SpecCodegen.errorCodes(fixture()));
    }

    @Test
    void aCodeWithTwoStatusesIsRefused() throws IOException {
        JsonNode spec = MAPPER.readTree(
                "{\"a\":{\"x-error-codes\":[{\"code\":\"X\",\"status\":404}]},"
                        + "\"b\":{\"x-error-codes\":[{\"code\":\"X\",\"status\":409}]}}");

        IllegalStateException error = assertThrows(IllegalStateException.class, () -> SpecCodegen.errorCodes(spec));
        assertTrue(error.getMessage().contains("X has two statuses"));
    }

    @Test
    void publicOperationsAreThoseWithAnEmptySecurity() throws IOException {
        assertEquals(List.of("GET /health", "POST /customers/{id}"), SpecCodegen.publicOperations(fixture()));
    }

    @Test
    void theEnumMapsEachConstantToItsWireCodeAndStatus() throws IOException {
        String source = SpecCodegen.renderErrorCode(SpecCodegen.errorCodes(fixture()));

        assertTrue(source.contains("PLAN_LIMIT_EXCEEDED(\"PLAN_LIMIT_EXCEEDED\", 429)"));
        assertTrue(source.contains("package app.puntjes.sdk.generated.errors;"));
    }

    @Test
    void theListRendersEachPublicOperation() throws IOException {
        String source = SpecCodegen.renderPublicOperations(SpecCodegen.publicOperations(fixture()));

        assertTrue(source.contains("\"POST /customers/{id}\""));
        assertTrue(source.contains("package app.puntjes.sdk.generated.security;"));
    }

    @Test
    void theMatcherAcceptsAConcretePathOfATemplatedPublicOperation(@TempDir Path dir) throws Exception {
        Class<?> matcher = compile(dir, "app.puntjes.sdk.generated.security.PublicOperations",
                SpecCodegen.renderPublicOperations(SpecCodegen.publicOperations(fixture())));

        assertTrue(matches(matcher, "POST", "/customers/42"));
        assertTrue(matches(matcher, "post", "/customers/42"));
        assertTrue(matches(matcher, "GET", "/health"));
        assertFalse(matches(matcher, "POST", "/customers/"));
        assertFalse(matches(matcher, "POST", "/customers/42/x"));
        assertFalse(matches(matcher, "DELETE", "/customers/42"));
        assertFalse(matches(matcher, "GET", "/secured"));
    }

    @Test
    void theEnumFindsAKnownWireCodeAndNothingElse(@TempDir Path dir) throws Exception {
        Class<?> enumClass = compile(dir, "app.puntjes.sdk.generated.errors.ErrorCode",
                SpecCodegen.renderErrorCode(SpecCodegen.errorCodes(fixture())));
        Method fromWire = enumClass.getMethod("fromWire", String.class);

        Optional<?> known = (Optional<?>) fromWire.invoke(null, "RATE_LIMITED");
        assertEquals("RATE_LIMITED", known.orElseThrow().toString());
        assertEquals(Optional.empty(), fromWire.invoke(null, "SOMETHING_NEW"));
        assertEquals(Optional.empty(), fromWire.invoke(null, (Object) null));
    }

    private static boolean matches(Class<?> matcher, String method, String path)
            throws ReflectiveOperationException {
        return (boolean) matcher.getMethod("matches", String.class, String.class).invoke(null, method, path);
    }

    private static Class<?> compile(Path dir, String className, String source) throws Exception {
        Path file = dir.resolve("src").resolve(className.replace('.', '/') + ".java");
        Files.createDirectories(file.getParent());
        Files.writeString(file, source);
        Path classes = Files.createDirectories(dir.resolve("classes"));
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        assertEquals(0, compiler.run(null, null, null, "-d", classes.toString(), file.toString()));
        try (URLClassLoader loader = new URLClassLoader(new URL[] {classes.toUri().toURL()})) {
            return loader.loadClass(className);
        }
    }
}
