package app.puntjes.tools;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/** Command line entry: {@code codegen <spec> <outDir>} or {@code dispatch-plan <tag> <level> <url> <source> <open>}. */
public final class Main {

    private Main() {}

    public static void main(String[] args) throws IOException {
        if (args.length == 3 && args[0].equals("codegen")) {
            codegen(Path.of(args[1]), Path.of(args[2]));
        } else if (args.length >= 1 && args[0].equals("dispatch-plan")) {
            System.exit(DispatchPlan.run(Arrays.copyOfRange(args, 1, args.length), System.out, System.err));
        } else {
            System.err.println("Usage: codegen <spec> <outDir> | dispatch-plan <tag> <level> <url> <source> <open>");
            System.exit(2);
        }
    }

    private static void codegen(Path spec, Path outDir) throws IOException {
        JsonNode document = new ObjectMapper().readTree(spec.toFile());
        write(outDir.resolve("errors/ErrorCode.java"),
                SpecCodegen.renderErrorCode(SpecCodegen.errorCodes(document)));
        write(outDir.resolve("security/PublicOperations.java"),
                SpecCodegen.renderPublicOperations(SpecCodegen.publicOperations(document)));
        OptionalBodies.apply(document, outDir);
    }

    private static void write(Path file, String content) throws IOException {
        Files.createDirectories(file.getParent());
        Files.writeString(file, content);
    }
}
