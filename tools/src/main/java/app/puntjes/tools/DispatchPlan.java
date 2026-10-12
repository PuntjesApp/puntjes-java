package app.puntjes.tools;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Decides what the regenerate workflow does with one spec-published dispatch. */
public final class DispatchPlan {

    private static final Pattern TAG = Pattern.compile("^v(\\d+)\\.(\\d+)\\.(\\d+)$");
    private static final String BRANCH_PREFIX = "regenerate/";

    /** The outcome: skip, or regenerate with a commit type, an auto-merge choice and older PR branches to close. */
    public record Decision(boolean skip, String commitType, boolean autoMerge, String branch, List<String> close) {}

    private record Version(long major, long minor, long patch) implements Comparable<Version> {
        @Override
        public int compareTo(Version other) {
            if (major != other.major) {
                return Long.compare(major, other.major);
            }
            return minor != other.minor ? Long.compare(minor, other.minor) : Long.compare(patch, other.patch);
        }
    }

    private record OpenPr(String branch, Version version, boolean major) {}

    private DispatchPlan() {}

    /** Prints the decision as {@code key=value} lines and returns 0; prints the reason and returns 1 on bad input. */
    public static int run(String[] args, PrintStream out, PrintStream err) {
        Decision decision;
        try {
            decision = decide(arg(args, 0), arg(args, 1), arg(args, 2), arg(args, 3), arg(args, 4));
        } catch (IllegalArgumentException e) {
            err.println(e.getMessage());
            return 1;
        }
        out.println("skip=" + decision.skip());
        out.println("commit_type=" + decision.commitType());
        out.println("auto_merge=" + decision.autoMerge());
        out.println("branch=" + decision.branch());
        out.println("close=" + String.join(" ", decision.close()));
        return 0;
    }

    /**
     * Applies the dispatch rules.
     *
     * @param open one open regenerate PR per line: its branch, then optionally its title
     * @throws IllegalArgumentException when the tag, the url or the level is not acceptable
     */
    public static Decision decide(String tag, String level, String url, String source, String open) {
        Version current = version(tag);
        if (current == null) {
            throw new IllegalArgumentException("The tag " + tag + " is not vX.Y.Z.");
        }
        if (!url.equals("https://raw.githubusercontent.com/PuntjesApp/puntjes-openapi/" + tag + "/api.json")) {
            throw new IllegalArgumentException("The url is not api.json of puntjes-openapi at " + tag + ".");
        }
        if (!List.of("major", "minor", "patch").contains(level)) {
            throw new IllegalArgumentException("The level " + level + " is not major, minor or patch.");
        }

        Version sourced = version(source.strip());
        List<OpenPr> openPrs = openPrs(open);
        boolean skip = (sourced != null && sourced.compareTo(current) >= 0)
                || openPrs.stream().anyMatch(pr -> pr.version().compareTo(current) > 0);
        List<OpenPr> close = skip
                ? List.of()
                : openPrs.stream().filter(pr -> pr.version().compareTo(current) < 0).toList();
        boolean major = level.equals("major")
                || close.stream().anyMatch(OpenPr::major)
                || (sourced != null && sourced.major() < current.major());

        String commitType = major ? "feat!" : level.equals("minor") ? "feat" : "fix";
        return new Decision(skip, commitType, !major, BRANCH_PREFIX + tag, close.stream().map(OpenPr::branch).toList());
    }

    private static List<OpenPr> openPrs(String open) {
        List<OpenPr> result = new ArrayList<>();
        for (String line : open.split("\n")) {
            String[] parts = line.strip().split("\\s+", 2);
            String branch = parts[0];
            if (!branch.startsWith(BRANCH_PREFIX)) {
                continue;
            }
            Version version = version(branch.substring(BRANCH_PREFIX.length()));
            if (version != null) {
                result.add(new OpenPr(branch, version, parts.length > 1 && parts[1].startsWith("feat!:")));
            }
        }
        return result;
    }

    private static String arg(String[] args, int index) {
        return index < args.length ? args[index] : "";
    }

    private static Version version(String reference) {
        Matcher match = TAG.matcher(reference);
        if (!match.matches()) {
            return null;
        }
        try {
            return new Version(Long.parseLong(match.group(1)), Long.parseLong(match.group(2)),
                    Long.parseLong(match.group(3)));
        } catch (NumberFormatException tooLarge) {
            return null;
        }
    }
}
