package app.puntjes.sdk;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import app.puntjes.sdk.exceptions.NotFoundException;
import app.puntjes.sdk.exceptions.ServerException;
import app.puntjes.sdk.exceptions.TransportException;
import app.puntjes.sdk.generated.PuntjesClient;
import app.puntjes.sdk.support.ApiServer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okio.Buffer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HelpersTest {
    private ApiServer server;

    @BeforeEach
    void startServer() {
        server = new ApiServer();
    }

    @AfterEach
    void stopServer() throws IOException {
        server.close();
    }

    @Test
    void theIdempotencyKeyIsAVersionFourUuidThatDiffersPerCall() {
        String first = IdempotencyKey.newKey();
        String second = IdempotencyKey.newKey();

        assertEquals(4, UUID.fromString(first).version());
        assertEquals(first, UUID.fromString(first).toString());
        assertNotEquals(first, second);
    }

    @Test
    void thePaginatorYieldsEveryItemInOrderAndAsksPagesOneToThree() {
        server.enqueueJson(200, productPage(1, 3, "a", "b"));
        server.enqueueJson(200, productPage(2, 3, "c"));
        server.enqueueJson(200, productPage(3, 3, "d", "e"));

        List<String> names = productNames();

        assertEquals(List.of("a", "b", "c", "d", "e"), names);
        assertEquals(List.of("1", "2", "3"), requestedPages());
    }

    @Test
    void aServerThatIgnoresThePageParameterStopsAfterPageOne() {
        server.enqueueJson(200, productPage(1, 3, "a", "b"));
        server.enqueueJson(200, productPage(1, 3, "a", "b"));
        server.enqueueJson(200, productPage(1, 3, "a", "b"));

        List<String> names = productNames();

        assertEquals(List.of("a", "b"), names);
        assertEquals(List.of("1", "2"), requestedPages());
    }

    @Test
    void thePaginatorAlsoOffersAnIterableThatFetchesLazily() {
        server.enqueueJson(200, productPage(1, 2, "a", "b"));
        server.enqueueJson(200, productPage(2, 2, "c"));
        PuntjesClient client = client();

        Iterable<String> names = Paginator.iterable(page -> productPage(client, page));
        List<String> seen = new ArrayList<>();
        for (String name : names) {
            seen.add(name);
            if (seen.size() == 2) {
                assertEquals(List.of("1"), requestedPages());
            }
        }

        assertEquals(List.of("a", "b", "c"), seen);
        assertEquals(List.of("2"), requestedPages());
    }

    @Test
    void theIterableStopsWhenTheServerIgnoresThePageParameter() {
        server.enqueueJson(200, productPage(1, 3, "a"));
        server.enqueueJson(200, productPage(1, 3, "a"));
        PuntjesClient client = client();

        List<String> seen = new ArrayList<>();
        Paginator.iterable(page -> productPage(client, page)).forEach(seen::add);

        assertEquals(List.of("a"), seen);
    }

    @Test
    void anEmptyFirstPageYieldsNothing() {
        server.enqueueJson(200, productPage(1, 1));

        assertEquals(List.of(), productNames());
        assertEquals(List.of("1"), requestedPages());
    }

    @Test
    void theWalletPassAsksForAPkpassAndReturnsItsBytes() {
        byte[] pass = {0x50, 0x4b, 0x03, 0x04, (byte) 0xff, (byte) 0xfe, 0x00, (byte) 0x80};
        server.enqueue(new MockResponse().setResponseCode(200).setHeader("Content-Type", "application/vnd.apple.pkpass")
                .setBody(new Buffer().write(pass)));

        byte[] bytes = WalletPass.apple(client(), "cus_42");

        assertArrayEquals(pass, bytes);
        RecordedRequest request = apiRequests().get(0);
        assertEquals("application/vnd.apple.pkpass", request.getHeader("Accept"));
        assertEquals("/api/v1/customers/cus_42/wallet-pass?platform=apple", request.getPath());
    }

    @Test
    void aWalletPassAnswerWithNoBodyIsATransportFailure() {
        server.enqueue(new MockResponse().setResponseCode(204));

        assertThrowsExactly(TransportException.class, () -> WalletPass.apple(client(), "cus_42"));
    }

    @Test
    void aServerErrorOnTheWalletPassThrowsServerException() {
        server.enqueueError(500, "INTERNAL_ERROR");

        assertThrowsExactly(ServerException.class, () -> WalletPass.apple(client(), "cus_42"));
    }

    @Test
    void aMissingCustomerThrowsNotFound() {
        server.enqueueError(404, "CUSTOMER_NOT_FOUND");

        assertThrowsExactly(NotFoundException.class, () -> WalletPass.apple(client(), "cus_missing"));
    }

    private List<String> productNames() {
        PuntjesClient client = client();
        return Paginator.all(page -> productPage(client, page)).collect(Collectors.toList());
    }

    private static Paginator.Page<String> productPage(PuntjesClient client, int page) {
        var response = client.products().get(c -> c.queryParameters.page = page);
        var meta = response.getData().getMeta();
        var names = response.getData().getData().stream().map(product -> product.getName()).toList();
        return new Paginator.Page<>(names, meta.getCurrentPage(), meta.getLastPage());
    }

    private List<String> requestedPages() {
        return apiRequests().stream().map(r -> r.getRequestUrl().queryParameter("page")).collect(Collectors.toList());
    }

    private List<RecordedRequest> apiRequests() {
        return server.takeRequests().stream().filter(r -> !ApiServer.TOKEN_PATH.equals(r.getPath())).toList();
    }

    private static String productPage(int current, int last, String... names) {
        String items = Arrays.stream(names).map(n -> "{\"id\":1,\"name\":\"" + n + "\"}")
                .collect(Collectors.joining(","));
        return "{\"data\":{\"data\":[%s],\"meta\":{\"current_page\":%d,\"last_page\":%d}}}".formatted(items, current, last);
    }

    private PuntjesClient client() {
        PuntjesOptions options = PuntjesOptions.builder().baseUrl(server.baseUrl()).sleeper(duration -> { }).build();
        return PuntjesClientFactory.create("client-id", "client-secret", options);
    }
}
