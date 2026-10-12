package app.puntjes.sdk.generated.vouchers;

import app.puntjes.sdk.generated.vouchers.item.WithCodeItemRequestBuilder;
import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import java.util.HashMap;
import java.util.Objects;
/**
 * Builds and executes requests for operations under /vouchers
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class VouchersRequestBuilder extends BaseRequestBuilder {
    /**
     * Gets an item from the app.puntjes.sdk.generated.vouchers.item collection
     * @param code Unique identifier of the item
     * @return a {@link WithCodeItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public WithCodeItemRequestBuilder byCode(@jakarta.annotation.Nonnull final String code) {
        Objects.requireNonNull(code);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("code", code);
        return new WithCodeItemRequestBuilder(urlTplParams, requestAdapter);
    }
    /**
     * Instantiates a new {@link VouchersRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public VouchersRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/vouchers", pathParameters);
    }
    /**
     * Instantiates a new {@link VouchersRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public VouchersRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/vouchers", rawUrl);
    }
}
