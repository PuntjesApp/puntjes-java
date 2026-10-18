#!/bin/sh
# Compares the public API with the latest release tag. A removed or changed public signature fails, unless the
# PR is breaking on purpose: a `type!:` title, or a `BREAKING CHANGE:` footer in the body. Needs the git tags.
# BC_BASE names another tag to compare with.
set -eu
root=$(cd "$(dirname "$0")/.." && pwd)
cd "$root"

base=${BC_BASE:-$(git tag --list '[0-9]*' --sort=-v:refname | head -n 1)}
if [ -z "$base" ]; then
  echo "::notice::No release tag exists yet, so there is nothing to compare with."
  exit 0
fi

work=$(mktemp -d)
cleanup() {
  git worktree remove --force "$work/old" > /dev/null 2>&1 || true
  rm -rf "$work"
}
trap cleanup EXIT

skip="-DskipTests -Dmaven.javadoc.skip=true -Dmaven.source.skip=true"
git worktree add --detach "$work/old" "$base" > /dev/null
(cd "$work/old" && ./mvnw -B -q $skip -Drevision="$base" package)

log="$work/japicmp.log"
if ./mvnw -B $skip -Drevision=0.0.0-bc -Pbc -Dbc.oldJar="$work/old/target/puntjes-java-$base.jar" verify > "$log" 2>&1; then
  echo "The public API is compatible with $base."
  exit 0
fi

grep -E 'WARNING|ERROR' "$log" | grep -E 'app\.puntjes|incompatib' || tail -n 40 "$log"

title=${PR_TITLE:-}
body=${PR_BODY:-}
if printf '%s\n' "$title" | grep -Eq '^[a-z]+(\([^)]*\))?!:' || printf '%s\n' "$body" | grep -Eq '^BREAKING[ -]CHANGE:'; then
  echo "::notice::The public API broke against $base, and the PR says so."
  exit 0
fi

echo "::error::The public API broke against $base. Retitle this PR with a '!' ('feat!: ...'), or add a 'BREAKING CHANGE:' footer to its body, so the release is a major version."
exit 1
