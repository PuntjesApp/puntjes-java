package app.puntjes.sdk.generated.customers;

import app.puntjes.sdk.generated.customers.byexternalid.ByExternalIdRequestBuilder;
import app.puntjes.sdk.generated.customers.item.WithCustomerItemRequestBuilder;
import app.puntjes.sdk.generated.customers.linkexternalid.LinkExternalIdRequestBuilder;
import app.puntjes.sdk.generated.customers.lookup.LookupRequestBuilder;
import app.puntjes.sdk.generated.models.CreateCustomerData;
import app.puntjes.sdk.generated.models.ErrorResponse;
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
 * Builds and executes requests for operations under /customers
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class CustomersRequestBuilder extends BaseRequestBuilder {
    /**
     * The byExternalId property
     * @return a {@link ByExternalIdRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public ByExternalIdRequestBuilder byExternalId() {
        return new ByExternalIdRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The linkExternalId property
     * @return a {@link LinkExternalIdRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public LinkExternalIdRequestBuilder linkExternalId() {
        return new LinkExternalIdRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The lookup property
     * @return a {@link LookupRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public LookupRequestBuilder lookup() {
        return new LookupRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * Gets an item from the app.puntjes.sdk.generated.customers.item collection
     * @param customer Unique identifier of the item
     * @return a {@link WithCustomerItemRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public WithCustomerItemRequestBuilder byCustomer(@jakarta.annotation.Nonnull final String customer) {
        Objects.requireNonNull(customer);
        final HashMap<String, Object> urlTplParams = new HashMap<String, Object>(this.pathParameters);
        urlTplParams.put("customer", customer);
        return new WithCustomerItemRequestBuilder(urlTplParams, requestAdapter);
    }
    /**
     * Instantiates a new {@link CustomersRequestBuilder} and sets the default values.
     * @param pathParameters Path parameters for the request
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public CustomersRequestBuilder(@jakarta.annotation.Nonnull final HashMap<String, Object> pathParameters, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/customers", pathParameters);
    }
    /**
     * Instantiates a new {@link CustomersRequestBuilder} and sets the default values.
     * @param rawUrl The raw URL to use for the request builder.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public CustomersRequestBuilder(@jakarta.annotation.Nonnull final String rawUrl, @jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}/customers", rawUrl);
    }
    /**
     * @param body The request body
     * @return a {@link CustomersPostResponse}
     * @throws ErrorResponse When receiving a 400 status code
     * @throws ErrorResponse When receiving a 401 status code
     * @throws ErrorResponse When receiving a 403 status code
     * @throws ErrorResponse When receiving a 409 status code
     * @throws ErrorResponse When receiving a 415 status code
     * @throws ErrorResponse When receiving a 422 status code
     * @throws ErrorResponse When receiving a 429 status code
     * @throws ErrorResponse When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public CustomersPostResponse post(@jakarta.annotation.Nonnull final CreateCustomerData body) {
        return post(body, null);
    }
    /**
     * @param body The request body
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link CustomersPostResponse}
     * @throws ErrorResponse When receiving a 400 status code
     * @throws ErrorResponse When receiving a 401 status code
     * @throws ErrorResponse When receiving a 403 status code
     * @throws ErrorResponse When receiving a 409 status code
     * @throws ErrorResponse When receiving a 415 status code
     * @throws ErrorResponse When receiving a 422 status code
     * @throws ErrorResponse When receiving a 429 status code
     * @throws ErrorResponse When receiving a 500 status code
     */
    @jakarta.annotation.Nullable
    public CustomersPostResponse post(@jakarta.annotation.Nonnull final CreateCustomerData body, @jakarta.annotation.Nullable final java.util.function.Consumer<PostRequestConfiguration> requestConfiguration) {
        Objects.requireNonNull(body);
        final RequestInformation requestInfo = toPostRequestInformation(body, requestConfiguration);
        final HashMap<String, ParsableFactory<? extends Parsable>> errorMapping = new HashMap<String, ParsableFactory<? extends Parsable>>();
        errorMapping.put("400", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("401", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("403", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("409", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("415", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("422", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("429", ErrorResponse::createFromDiscriminatorValue);
        errorMapping.put("500", ErrorResponse::createFromDiscriminatorValue);
        return this.requestAdapter.send(requestInfo, errorMapping, CustomersPostResponse::createFromDiscriminatorValue);
    }
    /**
     * @param body The request body
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPostRequestInformation(@jakarta.annotation.Nonnull final CreateCustomerData body) {
        return toPostRequestInformation(body, null);
    }
    /**
     * @param body The request body
     * @param requestConfiguration Configuration for the request such as headers, query parameters, and middleware options.
     * @return a {@link RequestInformation}
     */
    @jakarta.annotation.Nonnull
    public RequestInformation toPostRequestInformation(@jakarta.annotation.Nonnull final CreateCustomerData body, @jakarta.annotation.Nullable final java.util.function.Consumer<PostRequestConfiguration> requestConfiguration) {
        Objects.requireNonNull(body);
        final RequestInformation requestInfo = new RequestInformation(HttpMethod.POST, urlTemplate, pathParameters);
        requestInfo.configure(requestConfiguration, PostRequestConfiguration::new);
        requestInfo.headers.tryAdd("Accept", "application/json");
        requestInfo.setContentFromParsable(requestAdapter, "application/json", body);
        return requestInfo;
    }
    /**
     * Returns a request builder with the provided arbitrary URL. Using this method means any other path or query parameters are ignored.
     * @param rawUrl The raw URL to use for the request builder.
     * @return a {@link CustomersRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public CustomersRequestBuilder withUrl(@jakarta.annotation.Nonnull final String rawUrl) {
        Objects.requireNonNull(rawUrl);
        return new CustomersRequestBuilder(rawUrl, requestAdapter);
    }
    /**
     * Configuration for the request such as headers, query parameters, and middleware options.
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public class PostRequestConfiguration extends BaseRequestConfiguration {
    }
}
