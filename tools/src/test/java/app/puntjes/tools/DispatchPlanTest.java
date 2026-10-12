package app.puntjes.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class DispatchPlanTest {

    private static final String URL = "https://raw.githubusercontent.com/PuntjesApp/puntjes-openapi/v1.1.0/api.json";

    private record Result(int exit, Map<String, String> plan, String error) {}

    private static Result run(String... args) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        int exit = DispatchPlan.run(args,
                new PrintStream(out, true, StandardCharsets.UTF_8), new PrintStream(err, true, StandardCharsets.UTF_8));
        Map<String, String> plan = new LinkedHashMap<>();
        for (String line : out.toString(StandardCharsets.UTF_8).split("\n")) {
            if (!line.isEmpty()) {
                String[] pair = line.split("=", 2);
                plan.put(pair[0], pair.length > 1 ? pair[1] : "");
            }
        }
        return new Result(exit, plan, err.toString(StandardCharsets.UTF_8));
    }

    private static Map<String, String> plan(String... args) {
        return run(args).plan();
    }

    @Test
    void aMinorIsAFeatThatMergesItself() {
        Result result = run("v1.1.0", "minor", URL, "main@abc1234");

        assertEquals(0, result.exit());
        assertEquals(Map.of("skip", "false", "commit_type", "feat", "auto_merge", "true",
                "branch", "regenerate/v1.1.0", "close", ""), result.plan());
        assertEquals(List.of("skip", "commit_type", "auto_merge", "branch", "close"),
                List.copyOf(result.plan().keySet()));
    }

    @Test
    void aMajorIsBreakingAndWaitsForAPerson() {
        Map<String, String> plan = plan("v1.1.0", "major", URL, "main@abc1234");

        assertEquals("feat!", plan.get("commit_type"));
        assertEquals("false", plan.get("auto_merge"));
    }

    @Test
    void aPatchIsAFix() {
        assertEquals("fix", plan("v1.1.0", "patch", URL, "main@abc1234").get("commit_type"));
    }

    @Test
    void theTagAlreadyInSourceIsSkipped() {
        assertEquals("true", plan("v1.1.0", "minor", URL, "v1.1.0").get("skip"));
    }

    @Test
    void aUrlOutsidePuntjesOpenapiIsRefused() {
        Result foreign = run("v1.1.0", "minor", "https://example.com/api.json", "x");
        Result otherTag = run("v1.1.0", "minor",
                "https://raw.githubusercontent.com/PuntjesApp/puntjes-openapi/v9.9.9/api.json", "x");

        assertEquals(1, foreign.exit());
        assertEquals("The url is not api.json of puntjes-openapi at v1.1.0.\n", foreign.error());
        assertEquals(1, otherTag.exit());
    }

    @Test
    void anUnknownLevelOrTagIsRefused() {
        Result level = run("v1.1.0", "huge", URL, "x");
        Result tag = run("v1.1.0;rm", "minor", URL, "x");

        assertEquals(1, level.exit());
        assertEquals("The level huge is not major, minor or patch.\n", level.error());
        assertEquals(1, tag.exit());
        assertEquals("The tag v1.1.0;rm is not vX.Y.Z.\n", tag.error());
        assertEquals(Map.of(), tag.plan());
    }

    @Test
    void aSourceTagNewerThanTheTagIsSkipped() {
        assertEquals("true", plan("v1.1.0", "minor", URL, "v1.2.0").get("skip"));
    }

    @Test
    void versionsCompareByNumberNotByText() {
        String url = "https://raw.githubusercontent.com/PuntjesApp/puntjes-openapi/v1.10.0/api.json";

        assertEquals("false", plan("v1.10.0", "minor", url, "v1.9.0").get("skip"));
        assertEquals("true", plan("v1.9.0", "minor", url.replace("v1.10.0", "v1.9.0"), "v1.10.0").get("skip"));
    }

    @Test
    void anOpenRegeneratePrForANewerTagSkipsTheOlderTag() {
        Map<String, String> plan = plan("v1.1.0", "minor", URL, "main@abc1234", "regenerate/v1.0.0\nregenerate/v1.2.0");

        assertEquals("true", plan.get("skip"));
        assertEquals("", plan.get("close"));
    }

    @Test
    void theOpenRegeneratePrsForOlderTagsAreClosed() {
        Map<String, String> plan = plan("v1.1.0", "minor", URL, "v1.0.0",
                "regenerate/v1.0.1\nregenerate/v1.1.0\nfeature/x\nregenerate/v0.9.0\nregenerate/v1.0.2;rm");

        assertEquals("false", plan.get("skip"));
        assertEquals("regenerate/v1.0.1 regenerate/v0.9.0", plan.get("close"));
    }

    @Test
    void closingAnOpenMajorForAnOlderTagMakesTheNewPrAMajor() {
        Map<String, String> plan = plan("v1.1.0", "patch", URL, "v1.0.0",
                "regenerate/v1.0.5 feat!: regenerate from puntjes-openapi v1.0.5");

        assertEquals("regenerate/v1.0.5", plan.get("close"));
        assertEquals("feat!", plan.get("commit_type"));
        assertEquals("false", plan.get("auto_merge"));
    }

    @Test
    void closingAnOpenMinorForAnOlderTagKeepsTheNewLevel() {
        Map<String, String> plan = plan("v1.1.0", "patch", URL, "v1.0.0",
                "regenerate/v1.0.5 feat: regenerate from puntjes-openapi v1.0.5");

        assertEquals("regenerate/v1.0.5", plan.get("close"));
        assertEquals("fix", plan.get("commit_type"));
        assertEquals("true", plan.get("auto_merge"));
    }

    @Test
    void aSourceTagWithALowerMajorMakesTheNewPrAMajor() {
        Map<String, String> plan = plan("v2.0.1", "patch",
                "https://raw.githubusercontent.com/PuntjesApp/puntjes-openapi/v2.0.1/api.json", "v1.9.0");

        assertEquals("feat!", plan.get("commit_type"));
        assertEquals("false", plan.get("auto_merge"));
    }

    @Test
    void aSourceThatIsNotATagKeepsTheNewLevel() {
        Map<String, String> plan = plan("v1.1.0", "patch", URL, "main@abc1234");

        assertEquals("fix", plan.get("commit_type"));
        assertEquals("true", plan.get("auto_merge"));
    }

    @Test
    void decideReturnsTheClosedBranchesAsAList() {
        DispatchPlan.Decision decision = DispatchPlan.decide("v1.1.0", "minor", URL, "v1.0.0", "regenerate/v1.0.1");

        assertEquals(new DispatchPlan.Decision(false, "feat", true, "regenerate/v1.1.0", List.of("regenerate/v1.0.1")),
                decision);
    }
}
