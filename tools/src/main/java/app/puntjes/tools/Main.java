package app.puntjes.tools;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/** Command line entry of the tools: {@code codegen <spec> <outDir>}. */
public final class Main {

    private Main() {}

    public static void main(String[] args) throws IOException {
        if (args.length != 3 || !args[0].equals("codegen")) {
            System.err.println("Usage: codegen <spec> <outDir>");
            System.exit(2);
        }
        codegen(Path.of(args[1]), Path.of(args[2]));
    }

    private static void codegen(Path spec, Path outDir) throws IOException {
        JsonNode document = new ObjectMapper().readTree(spec.toFile());
        write(outDir.resolve("errors/ErrorCode.java"),
                SpecCodegen.renderErrorCode(SpecCodegen.errorCodes(document)));
        write(outDir.resolve("security/PublicOperations.java"),
                SpecCodegen.renderPublicOperations(SpecCodegen.publicOperations(document)));
    }

    private static void write(Path file, String content) throws IOException {
        Files.createDirectories(file.getParent());
        Files.writeString(file, content);
    }
}
