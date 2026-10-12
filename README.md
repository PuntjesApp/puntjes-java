# puntjes-java

The official Java client for the [Puntjes](https://puntjes.app) loyalty API. It needs Java 17 or newer and is tested on
Java 17, 21 and 25. JitPack serves it.

## Install

Maven:

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
  <groupId>com.github.PuntjesApp</groupId>
  <artifactId>puntjes-java</artifactId>
  <version>1.0.0</version>
</dependency>
```

Gradle:

```groovy
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.PuntjesApp:puntjes-java:1.0.0'
}
```

## Quick start

Create your API credentials in the Puntjes admin portal. The secret is shown once.

```java
import app.puntjes.sdk.IdempotencyKey;
import app.puntjes.sdk.PuntjesClientFactory;
import app.puntjes.sdk.generated.models.CreateTransactionData;

var puntjes = PuntjesClientFactory.create(
        System.getenv("PUNTJES_CLIENT_ID"), System.getenv("PUNTJES_CLIENT_SECRET"));

// A customer scans their card at the till.
var customer = puntjes.customers().lookup().get(c -> c.queryParameters.identifier = scannedCard).getData();
System.out.println(customer.getWalletBalance());

// Record the purchase. Amounts are in cents.
var purchase = new CreateTransactionData();
purchase.setIdentifier(scannedCard);
purchase.setTotalAmount(4200);
purchase.setIdempotencyKey(IdempotencyKey.newKey());
var transaction = puntjes.transactions().post(purchase).getData();
System.out.println(transaction.getPointsEarned());
```

`PuntjesClientFactory.create` returns a client that [Kiota](https://github.com/microsoft/kiota) generated from the
Puntjes OpenAPI document, so it has every call the API has. A call follows the URL:
`puntjes.customers().byCustomer("42").wallet().get()` is `GET /customers/42/wallet`. Read the `getData()` part of the
answer.

`examples/quickstart` is a complete program. It records a real purchase, so run it against a test shop. It reads `PUNTJES_CLIENT_ID`, `PUNTJES_CLIENT_SECRET` and, if set,
`PUNTJES_BASE_URL` from the environment:

```bash
cd examples/quickstart
../../mvnw -B compile exec:java -Dexec.args="<card or email>"
```

## Options

```java
var puntjes = PuntjesClientFactory.create(id, secret, PuntjesOptions.builder()
        .baseUrl("https://puntjes.app/api/v1")
        .maxRetries(2)                       // 0 turns retries off
        .retryBaseDelay(Duration.ofMillis(500))
        .timeout(Duration.ofSeconds(30))     // per attempt
        .tokenStore(myDistributedStore)      // a TokenStore; memory by default
        .build());
```

`httpClient(OkHttpClient)` builds the client on yours, so your proxy and pool settings stay.

## What the SDK does for you

- **Authentication.** It asks for a `client_credentials` token on the first call, keeps it until 30 seconds before it
  expires, and asks once more when the API rejects it. Parallel calls share one request for a token. A `TokenStore`
  keeps each token under a key made from the host and the credentials, so one shared store can serve the clients of many
  shops without mixing their tokens.
- **Retries.** A GET, PUT, PATCH or DELETE, and a POST whose JSON body carries an `idempotency_key`, is sent again after
  a network failure, a 5xx answer or `RATE_LIMITED`. It waits 0.5 s, then 1 s, or what `Retry-After` says. A POST without
  a key is never sent twice, so a purchase is never recorded twice. `PLAN_LIMIT_EXCEEDED` is never retried. A failed
  token request is retried the same way.
- **Idempotency keys.** `IdempotencyKey.newKey()` makes one. Send the same key again to repeat a call safely.

## Errors

Every error is an unchecked `PuntjesException`, with a subclass per kind:

| Exception | When |
|---|---|
| `AuthenticationException` | 401: wrong credentials or a rejected token |
| `ForbiddenException` | 403 |
| `NotFoundException` | 404 |
| `ConflictException` | 409 |
| `ValidationException` | 422 `VALIDATION_ERROR`; `details()` and `errorsFor("field")` give the messages |
| `RateLimitException` | 429 `RATE_LIMITED`; `retryAfter()` says how long to wait |
| `PlanLimitExceededException` | 429 `PLAN_LIMIT_EXCEEDED`: the shop's plan is used up |
| `ServerException` | 5xx |
| `TransportException` | No answer from the API |

A 422 for a business rule, such as `INSUFFICIENT_BALANCE`, is a plain `PuntjesException`.

```java
try {
    puntjes.redemptions().post(body);
} catch (PuntjesException e) {
    if (e.errorCode().filter(code -> code == ErrorCode.INSUFFICIENT_BALANCE).isPresent()) {
        System.out.println("Not enough points. Request " + e.requestId().orElse("unknown"));
    } else {
        throw e;
    }
}
```

`errorCode()` is empty for a code that is newer than your SDK; `rawCode()` holds the code as the API sent it, when it sent one.

## Pages

```java
Paginator.all(page -> {
    var answer = puntjes.products().get(c -> c.queryParameters.page = page).getData();
    return new Paginator.Page<>(answer.getData(), answer.getMeta().getCurrentPage(), answer.getMeta().getLastPage());
}).forEach(product -> System.out.println(product.getName()));
```

`Paginator.all` returns a lazy `Stream`. It fetches the next page only when the stream needs it.

## Apple wallet pass

```java
byte[] pkpass = WalletPass.apple(puntjes, customerId);
```

## Kiota gap

kiota-abstractions 1.9.3 keeps the request adapter of a generated client protected, and the generated method for the
pass call reads only its JSON answer, not the pass file. `WalletPass` therefore reaches the adapter through the client that
`PuntjesClientFactory` returns, and it needs a client made by that factory.

## How this package is made

The code under `src/main/java/app/puntjes/sdk/generated` is generated by Kiota from `spec/api.json`. Never edit it by
hand: CI regenerates it and fails on any difference.

- `scripts/generate.sh` regenerates it with Docker. Kiota and Maven are pinned by image digest.
- When Puntjes publishes a new API spec, `.github/workflows/regenerate.yml` opens a PR with the new code. A minor or
  patch spec merges itself when CI is green; a major one waits for a person.
- `.github/workflows/release.yml` runs release-please. Its release PR merges itself when CI is green. The tag makes
  JitPack build the version, and the workflow waits until the pom is available there.

### Build from source

```bash
./mvnw -B verify
```

The Maven Wrapper downloads Maven 3.9.16. JitPack runs `./mvnw -B install -DskipTests -Drevision=<tag>`: the version
comes from `-Drevision`, so no file that the build reads holds it.

## License

MIT
