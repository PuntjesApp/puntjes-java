package app.puntjes.sdk.generated.products.item;

import app.puntjes.sdk.generated.models.ErrorResponse;
import app.puntjes.sdk.generated.models.UpdateProductData;
import app.puntjes.sdk.generated.models.UpsertProductData;
import app.puntjes.sdk.generated.products.item.reward.RewardRequestBuilder;
import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.BaseRequestConfiguration;
import com.microsoft.kiota.HttpMethod;
import com.microsoft.kiota.RequestAdapter;
import com.microsoft.kiota.RequestInformation;
import com.microsoft.kiota.RequestOption;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParsableFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/**
 * Builds and executes requests for operations under /products/{externalId}
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class WithExternalItemRequestBuilder extends BaseRequestBuilder {
    /**
     * The reward property
     * @return a {@link RewardRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public RewardRequestBuilder reward() {
        return new RewardRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * Instantiates a new {@link WithExternalItemRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public WithExternalItemRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/products/{externalId}", pathParameters);
    }
    /**
     * Instantiates a new {@link WithExternalItemRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public WithExternalItemRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/products/{externalId}", rawUrl);
    }
    /**
     * @throws ErrorResponse When receiving a 401 status code
     * @throws ErrorResponse When receiving a 403 status code
     * @throws ErrorResponse When receiving a 404 status code
     * @throws ErrorResponse When receiving a 415 status code
     * @throws ErrorResponse When receiving a 429 status code
     * @throws ErrorResponse When receiving a 500 status code
     */
    public void delete() {
        delete(null);
    }
    /**
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @throws ErrorResponse When receiving a 401 status code
     * @throws ErrorResponse When receiving a 403 status code
     * @throws ErrorResponse When receiving a 404 status code
     * @throws ErrorResponse When receiving a 415 status code
     * @throws ErrorResponse When receiving a 429 status code
     * @throws ErrorResponse When receiving a 500 status code
     */
    public void delete(@jakarta.annotation.Nullable final java.util.function.Consumer<DeleteRequestConfiguration> requestConfiguration) {
        final RequestInformation requestInfo = toDeleteRequestInformation(requestConfiguration);
        final HashMap<String, ParsableFactory<? extends Parsable>> errorMapping = new HashMap<String, ParsableFactory<? extends Parsable>>();
        errorMapping.put("401", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("403", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("404", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("415", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("429", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("500", ErrorResponse::createFromDiscriminatorValue);
        this.requestAdapter.sendPrimitive(requestInfo, errorMapping, Void.class);
    }
    /**
     * @return a {@link WithExternalGetResponse}
     * @throws ErrorResponse When receiving a 401 status code
     * @throws ErrorResponse When receiving a 403 status code
     * @throws ErrorResponse When receiving a 404 status code
     * @throws ErrorResponse When receiving a 429 status code
     * @throws ErrorResponse When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public WithExternalGetResponse get() {
        return get(null);
    }
    /**
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link WithExternalGetResponse}
     * @throws ErrorResponse When receiving a 401 status code
     * @throws ErrorResponse When receiving a 403 status code
     * @throws ErrorResponse When receiving a 404 status code
     * @throws ErrorResponse When receiving a 429 status code
     * @throws ErrorResponse When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public WithExternalGetResponse get(@jakarta.annotation.Nullable final java.util.function.Consumer<GetRequestConfiguration> requestConfiguration) {
        final RequestInformation requestInfo = toGetRequestInformation(requestConfiguration);
        final HashMap<String, ParsableFactory<? extends Parsable>> errorMapping = new HashMap<String, ParsableFactory<? extends Parsable>>();
        errorMapping.put("401", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("403", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("404", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("429", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("500", ErrorResponse::createFromDiscriminatorValue);
        return this.requestAdapter.send(requestInfo, errorMapping, WithExternalGetResponse::createFromDiscriminatorValue);
    }
    /**
     * @param body The request body
     * @return a {@link WithExternalPatchResponse}
     * @throws ErrorResponse When receiving a 400 status code
     * @throws ErrorResponse When receiving a 401 status code
     * @throws ErrorResponse When receiving a 403 status code
     * @throws ErrorResponse When receiving a 404 status code
     * @throws ErrorResponse When receiving a 415 status code
     * @throws ErrorResponse When receiving a 422 status code
     * @throws ErrorResponse When receiving a 429 status code
     * @throws ErrorResponse When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public WithExternalPatchResponse patch(@jakarta.annotation.Nullable final UpdateProductData body) {
        return patch(body, null);
    }
    /**
     * @param body The request body
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link WithExternalPatchResponse}
     * @throws ErrorResponse When receiving a 400 status code
     * @throws ErrorResponse When receiving a 401 status code
     * @throws ErrorResponse When receiving a 403 status code
     * @throws ErrorResponse When receiving a 404 status code
     * @throws ErrorResponse When receiving a 415 status code
     * @throws ErrorResponse When receiving a 422 status code
     * @throws ErrorResponse When receiving a 429 status code
     * @throws ErrorResponse When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public WithExternalPatchResponse patch(@jakarta.annotation.Nullable final UpdateProductData body, @jakarta.annotation.Nullable final java.util.function.Consumer<PatchRequestConfiguration> requestConfiguration) {
        final RequestInformation requestInfo = toPatchRequestInformation(body, requestConfiguration);
        final HashMap<String, ParsableFactory<? extends Parsable>> errorMapping = new HashMap<String, ParsableFactory<? extends Parsable>>();
        errorMapping.put("400", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("401", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("403", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("404", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("415", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("422", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("429", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("500", ErrorResponse::createFromDiscriminatorValue);
        return this.requestAdapter.send(requestInfo, errorMapping, WithExternalPatchResponse::createFromDiscriminatorValue);
    }
    /**
     * Without a body: the spec makes the patch body optional.
     * @return a {@link WithExternalPatchResponse}
     */
    @jakarta.annotation.Nullable
    public WithExternalPatchResponse patch() {
        return patch(null, null);
    }
    /**
     * Without a body: the spec makes the patch body optional.
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link WithExternalPatchResponse}
     */
    @jakarta.annotation.Nullable
    public WithExternalPatchResponse patch(@jakarta.annotation.Nullable final java.util.function.Consumer<PatchRequestConfiguration> requestConfiguration) {
        return patch(null, requestConfiguration);
    }
    /**
     * @param body The request body
     * @return a {@link WithExternalPutResponse}
     * @throws ErrorResponse When receiving a 400 status code
     * @throws ErrorResponse When receiving a 401 status code
     * @throws ErrorResponse When receiving a 403 status code
     * @throws ErrorResponse When receiving a 415 status code
     * @throws ErrorResponse When receiving a 422 status code
     * @throws ErrorResponse When receiving a 429 status code
     * @throws ErrorResponse When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public WithExternalPutResponse put(@jakarta.annotation.Nonnull final UpsertProductData body) {
        return put(body, null);
    }
    /**
     * @param body The request body
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link WithExternalPutResponse}
     * @throws ErrorResponse When receiving a 400 status code
     * @throws ErrorResponse When receiving a 401 status code
     * @throws ErrorResponse When receiving a 403 status code
     * @throws ErrorResponse When receiving a 415 status code
     * @throws ErrorResponse When receiving a 422 status code
     * @throws ErrorResponse When receiving a 429 status code
     * @throws ErrorResponse When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public WithExternalPutResponse put(@jakarta.annotation.Nonnull final UpsertProductData body, @jakarta.annotation.Nullable final java.util.function.Consumer<PutRequestConfiguration> requestConfiguration) {
        Objects.requireNonNull(body);
        final RequestInformation requestInfo = toPutRequestInformation(body, requestConfiguration);
        final HashMap<String, ParsableFactory<? extends Parsable>> errorMapping = new HashMap<String, ParsableFactory<? extends Parsable>>();
        errorMapping.put("400", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("401", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("403", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("415", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("422", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("429", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("500", ErrorResponse::createFromDiscriminatorValue);
        return this.requestAdapter.send(requestInfo, errorMapping, WithExternalPutResponse::createFromDiscriminatorValue);
    }
    /**
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toDeleteRequestInformation() {
        return toDeleteRequestInformation(null);
    }
    /**
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toDeleteRequestInformation(@jakarta.annotation.Nullable final java.util.function.Consumer<DeleteRequestConfiguration> requestConfiguration) {
        final RequestInformation requestInfo = new RequestInformation(HttpMethod.DELETE, urlTemplate, pathParameters);
        requestInfo.configure(requestConfiguration, DeleteRequestConfiguration::new);
        requestInfo.headers.tryAdd("Accept", "application/json");
        return requestInfo;
    }
    /**
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toGetRequestInformation() {
        return toGetRequestInformation(null);
    }
    /**
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toGetRequestInformation(@jakarta.annotation.Nullable final java.util.function.Consumer<GetRequestConfiguration> requestConfiguration) {
        final RequestInformation requestInfo = new RequestInformation(HttpMethod.GET, urlTemplate, pathParameters);
        requestInfo.configure(requestConfiguration, GetRequestConfiguration::new);
        requestInfo.headers.tryAdd("Accept", "application/json");
        return requestInfo;
    }
    /**
     * @param body The request body
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPatchRequestInformation(@jakarta.annotation.Nullable final UpdateProductData body) {
        return toPatchRequestInformation(body, null);
    }
    /**
     * @param body The request body
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPatchRequestInformation(@jakarta.annotation.Nullable final UpdateProductData body, @jakarta.annotation.Nullable final java.util.function.Consumer<PatchRequestConfiguration> requestConfiguration) {
        final RequestInformation requestInfo = new RequestInformation(HttpMethod.PATCH, urlTemplate, pathParameters);
        requestInfo.configure(requestConfiguration, PatchRequestConfiguration::new);
        requestInfo.headers.tryAdd("Accept", "application/json");
        if (body != null) {
            requestInfo.setContentFromParsable(requestAdapter, "application/json", body);
        }
        return requestInfo;
    }
    /**
     * Without a body: the spec makes the patch body optional.
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPatchRequestInformation() {
        return toPatchRequestInformation(null, null);
    }
    /**
     * Without a body: the spec makes the patch body optional.
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPatchRequestInformation(@jakarta.annotation.Nullable final java.util.function.Consumer<PatchRequestConfiguration> requestConfiguration) {
        return toPatchRequestInformation(null, requestConfiguration);
    }
    /**
     * @param body The request body
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPutRequestInformation(@jakarta.annotation.Nonnull final UpsertProductData body) {
        return toPutRequestInformation(body, null);
    }
    /**
     * @param body The request body
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPutRequestInformation(@jakarta.annotation.Nonnull final UpsertProductData body, @jakarta.annotation.Nullable final java.util.function.Consumer<PutRequestConfiguration> requestConfiguration) {
        Objects.requireNonNull(body);
        final RequestInformation requestInfo = new RequestInformation(HttpMethod.PUT, urlTemplate, pathParameters);
        requestInfo.configure(requestConfiguration, PutRequestConfiguration::new);
        requestInfo.headers.tryAdd("Accept", "application/json");
        requestInfo.setContentFromParsable(requestAdapter, "application/json", body);
        return requestInfo;
    }
    /**
     * Returns a request builder with the provided arbitrary URL. Using this method means any other path or query parameters are ignored.
     * @param rawUrl The raw URL to use for the request builder.
     * @return a {@link WithExternalItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public WithExternalItemRequestBuilder withUrl(@jakarta.annotation.Nonnull final String rawUrl) {
        Objects.requireNonNull(rawUrl);
        return new WithExternalItemRequestBuilder(rawUrl, requestAdapter);
    }
    /**
     * Configuration for the request such as headers, query parameters, and middleware options.
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public class DeleteRequestConfiguration extends BaseRequestConfiguration {
    }
    /**
     * Configuration for the request such as headers, query parameters, and middleware options.
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public class GetRequestConfiguration extends BaseRequestConfiguration {
    }
    /**
     * Configuration for the request such as headers, query parameters, and middleware options.
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public class PatchRequestConfiguration extends BaseRequestConfiguration {
    }
    /**
     * Configuration for the request such as headers, query parameters, and middleware options.
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public class PutRequestConfiguration extends BaseRequestConfiguration {
    }
}
