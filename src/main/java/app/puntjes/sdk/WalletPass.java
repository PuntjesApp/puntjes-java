package app.puntjes.sdk;

import app.puntjes.sdk.exceptions.TransportException;
import app.puntjes.sdk.generated.PuntjesClient;
import app.puntjes.sdk.generated.customers.item.walletpass.GetPlatformQueryParameterType;
import com.microsoft.kiota.RequestInformation;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.HashMap;

/** Downloads a customer's wallet pass file. The generated client reads only the JSON answer of this call. */
public final class WalletPass {
    private static final String PKPASS = "application/vnd.apple.pkpass";

    private WalletPass() {
    }

    /**
     * The Apple Wallet pass of a customer.
     *
     * @param client a client made by {@link PuntjesClientFactory}
     * @throws IllegalArgumentException when the client was not made by {@link PuntjesClientFactory}
     * @throws app.puntjes.sdk.exceptions.NotFoundException when the customer does not exist
     * @throws app.puntjes.sdk.exceptions.TransportException when the answer has no body
     */
    public static byte[] apple(PuntjesClient client, String customerId) {
        if (!(client instanceof FactoryClient factoryClient)) {
            throw new IllegalArgumentException("The client must come from PuntjesClientFactory");
        }
        RequestInformation request = client.customers().byCustomer(customerId).walletPass()
                .toGetRequestInformation(c -> {
                    c.queryParameters.platform = GetPlatformQueryParameterType.Apple;
                    c.headers.add("Accept", PKPASS);
                });

        InputStream body = factoryClient.adapter().sendPrimitive(request, new HashMap<>(), InputStream.class);
        if (body == null) {
            throw new TransportException("The wallet pass answer has no body", null);
        }
        try (body) {
            return body.readAllBytes();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
