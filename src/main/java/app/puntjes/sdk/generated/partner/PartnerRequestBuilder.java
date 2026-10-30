package app.puntjes.sdk.generated.partner;

import app.puntjes.sdk.generated.partner.clients.ClientsRequestBuilder;
import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
/**
 * Builds and executes requests for operations under /partner
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class PartnerRequestBuilder extends BaseRequestBuilder {
    /**
     * The clients property
     * @return a {@link ClientsRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public ClientsRequestBuilder clients() {
        return new ClientsRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * Instantiates a new {@link PartnerRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public PartnerRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/partner", pathParameters);
    }
    /**
     * Instantiates a new {@link PartnerRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public PartnerRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/partner", rawUrl);
    }
}
