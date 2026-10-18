package app.puntjes.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class OptionalBodiesTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String BUILDER = "products/item/WithExternalItemRequestBuilder.java";

    private static String builder() throws IOException {
        try (InputStream stream = OptionalBodiesTest.class.getResourceAsStream(
                "/optional-bodies/WithExternalItemRequestBuilder.java.txt")) {
            return new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    private static JsonNode spec(String patchBody) throws IOException {
        return MAPPER.readTree("""
                {"paths":{"/products/{externalId}":{
                  "get":{},
                  "patch":{"requestBody":%s},
                  "put":{"requestBody":{"required":true,"content":{}}}}}}""".formatted(patchBody));
    }

    private static Path generated(Path dir) throws IOException {
        Path file = dir.resolve(BUILDER);
        Files.createDirectories(file.getParent());
        Files.writeString(file, builder());
        return file;
    }

    @Test
    void anOptionalBodyGetsOverloadsWithoutABody() throws IOException {
        String source = OptionalBodies.rewrite(builder(), "patch", BUILDER);

        assertTrue(source.contains("public WithExternalPatchResponse patch() {\n        return patch(null, null);\n    }"));
        assertTrue(source.contains("public WithExternalPatchResponse patch(@jakarta.annotation.Nullable final "
                + "java.util.function.Consumer<PatchRequestConfiguration> requestConfiguration) {\n"
                + "        return patch(null, requestConfiguration);\n    }"));
        assertTrue(source.contains("public RequestInformation toPatchRequestInformation() {\n"
                + "        return toPatchRequestInformation(null, null);\n    }"));
        assertTrue(source.contains("public RequestInformation toPatchRequestInformation(@jakarta.annotation.Nullable "
                + "final java.util.function.Consumer<PatchRequestConfiguration> requestConfiguration) {\n"
                + "        return toPatchRequestInformation(null, requestConfiguration);\n    }"));
    }

    @Test
    void anOptionalBodyIsNullableAndOnlySentWhenGiven() throws IOException {
        String source = OptionalBodies.rewrite(builder(), "patch", BUILDER);

        assertFalse(source.contains("@jakarta.annotation.Nonnull final UpdateProductData body"));
        assertEquals(4, count(source, "@jakarta.annotation.Nullable final UpdateProductData body"));
        assertTrue(source.contains("        if (body != null) {\n"
                + "            requestInfo.setContentFromParsable(requestAdapter, \"application/json\", body);\n"
                + "        }\n"));
        assertEquals(2, count(source, "Objects.requireNonNull(body);"));
    }

    @Test
    void aRequiredBodyKeepsItsShape() throws IOException {
        String source = OptionalBodies.rewrite(builder(), "patch", BUILDER);

        assertEquals(4, count(source, "@jakarta.annotation.Nonnull final UpsertProductData body"));
        assertFalse(source.contains("public WithExternalPutResponse put() {"));
    }

    @Test
    void applyRewritesOnlyTheOperationsWhoseBodyIsNotRequired(@TempDir Path dir) throws IOException {
        Path file = generated(dir);

        OptionalBodies.apply(spec("{\"content\":{}}"), dir);

        String source = Files.readString(file);
        assertTrue(source.contains("public WithExternalPatchResponse patch() {"));
        assertFalse(source.contains("public WithExternalPutResponse put() {"));
    }

    @Test
    void applyTreatsAnExplicitFalseAsOptional(@TempDir Path dir) throws IOException {
        Path file = generated(dir);

        OptionalBodies.apply(spec("{\"required\":false,\"content\":{}}"), dir);

        assertTrue(Files.readString(file).contains("public WithExternalPatchResponse patch() {"));
    }

    @Test
    void applyFailsWhenNoBuilderHasTheOperationPath(@TempDir Path dir) throws IOException {
        generated(dir);
        JsonNode spec = MAPPER.readTree("{\"paths\":{\"/missing\":{\"post\":{\"requestBody\":{}}}}}");

        IllegalStateException error = assertThrows(IllegalStateException.class, () -> OptionalBodies.apply(spec, dir));
        assertTrue(error.getMessage().contains("/missing"));
    }

    @Test
    void rewriteFailsWhenTheGeneratedShapeIsUnknown() throws IOException {
        String changed = builder().replace("Objects.requireNonNull(body);", "");

        IllegalStateException error = assertThrows(IllegalStateException.class,
                () -> OptionalBodies.rewrite(changed, "patch", BUILDER));
        assertTrue(error.getMessage().contains(BUILDER));
    }

    @Test
    void rewriteFailsWhenTheMethodHasNoBody() throws IOException {
        assertThrows(IllegalStateException.class, () -> OptionalBodies.rewrite(builder(), "get", BUILDER));
    }

    private static int count(String source, String part) {
        return source.split(java.util.regex.Pattern.quote(part), -1).length - 1;
    }
}
