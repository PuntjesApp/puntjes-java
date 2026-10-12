package app.puntjes.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

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
}
