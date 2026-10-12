package app.puntjes.sdk.generated.customers.byexternalid;

import app.puntjes.sdk.generated.customers.byexternalid.item.WithExternalItemRequestBuilder;
import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
/**
 * Builds and executes requests for operations under /customers/by-external-id
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class ByExternalIdRequestBuilder extends BaseRequestBuilder {
    /**
     * Gets an item from the app.puntjes.sdk.generated.customers.byExternalId.item collection
     * @param externalId Unique identifier of the item
     * @return a {@link WithExternalItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public WithExternalItemRequestBuilder byExternalId(@jakarta.annotation.Nonnull final String externalId) {
        Objects.requireNonNull(externalId);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("externalId", externalId);
        return new WithExternalItemRequestBuilder(urlTplParams, requestAdapter);
    }
    /**
     * Instantiates a new {@link ByExternalIdRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public ByExternalIdRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/customers/by-external-id", pathParameters);
    }
    /**
     * Instantiates a new {@link ByExternalIdRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public ByExternalIdRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/customers/by-external-id", rawUrl);
    }
}
