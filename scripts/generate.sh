#!/bin/sh
# Regenerates src/main/java/app/puntjes/sdk/generated from spec/api.json with the pinned images. Never edit that folder by hand.
set -eu
root=$(cd "$(dirname "$0")/.." && pwd)
kiota="mcr.microsoft.com/openapi/kiota@sha256:ec6d326a8f98a067106729903928535906044aa1a42dbd1825c384080da76b13"
maven="maven@sha256:1a352420f7aba21f5ad08df31bab55f74c013fb491f1ae8ab1dd7ff9ed698584"
out=src/main/java/app/puntjes/sdk/generated
rm -rf "${root:?}/$out"
docker run --rm -u "$(id -u):$(id -g)" -v "$root:/w" "$kiota" generate \
  -l Java -d /w/spec/api.json -o "/w/$out" -n app.puntjes.sdk.generated -c PuntjesClient \
  --serializer com.microsoft.kiota.serialization.JsonSerializationWriterFactory \
  --serializer com.microsoft.kiota.serialization.TextSerializationWriterFactory \
  --deserializer com.microsoft.kiota.serialization.JsonParseNodeFactory \
  --deserializer com.microsoft.kiota.serialization.TextParseNodeFactory \
  --exclude-backward-compatible --clean-output --log-level Warning
mkdir -p "$HOME/.m2"
docker run --rm -u "$(id -u):$(id -g)" -e MAVEN_CONFIG=/tmp/m2 -v "$HOME/.m2:/tmp/m2" -v "$root:/w" -w /w "$maven" \
  mvn -B -q -Duser.home=/tmp -f tools/pom.xml compile exec:java -Dexec.args="codegen spec/api.json $out"
