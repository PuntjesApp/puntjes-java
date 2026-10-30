package app.puntjes.sdk.generated;

import app.puntjes.sdk.generated.branches.BranchesRequestBuilder;
import app.puntjes.sdk.generated.campaigns.CampaignsRequestBuilder;
import app.puntjes.sdk.generated.client.ClientRequestBuilder;
import app.puntjes.sdk.generated.customers.CustomersRequestBuilder;
import app.puntjes.sdk.generated.health.HealthRequestBuilder;
import app.puntjes.sdk.generated.me.MeRequestBuilder;
import app.puntjes.sdk.generated.partner.PartnerRequestBuilder;
import app.puntjes.sdk.generated.products.ProductsRequestBuilder;
import app.puntjes.sdk.generated.redemptions.RedemptionsRequestBuilder;
import app.puntjes.sdk.generated.rewards.RewardsRequestBuilder;
import app.puntjes.sdk.generated.statistics.StatisticsRequestBuilder;
import app.puntjes.sdk.generated.transactions.TransactionsRequestBuilder;
import app.puntjes.sdk.generated.vouchers.VouchersRequestBuilder;
import com.microsoft.kiota.ApiClientBuilder;
import com.microsoft.kiota.BaseRequestBuilder;
import com.microsoft.kiota.RequestAdapter;
import com.microsoft.kiota.serialization.JsonParseNodeFactory;
import com.microsoft.kiota.serialization.JsonSerializationWriterFactory;
import com.microsoft.kiota.serialization.ParseNodeFactoryRegistry;
import com.microsoft.kiota.serialization.SerializationWriterFactoryRegistry;
import com.microsoft.kiota.serialization.TextParseNodeFactory;
import com.microsoft.kiota.serialization.TextSerializationWriterFactory;
import java.util.HashMap;
import java.util.Objects;
/**
 * The main entry point of the SDK, exposes the configuration and the fluent API.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public class PuntjesClient extends BaseRequestBuilder {
    /**
     * The branches property
     * @return a {@link BranchesRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public BranchesRequestBuilder branches() {
        return new BranchesRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The campaigns property
     * @return a {@link CampaignsRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public CampaignsRequestBuilder campaigns() {
        return new CampaignsRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The client property
     * @return a {@link ClientRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public ClientRequestBuilder client() {
        return new ClientRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The customers property
     * @return a {@link CustomersRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public CustomersRequestBuilder customers() {
        return new CustomersRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The health property
     * @return a {@link HealthRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public HealthRequestBuilder health() {
        return new HealthRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The me property
     * @return a {@link MeRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public MeRequestBuilder me() {
        return new MeRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The partner property
     * @return a {@link PartnerRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public PartnerRequestBuilder partner() {
        return new PartnerRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The products property
     * @return a {@link ProductsRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public ProductsRequestBuilder products() {
        return new ProductsRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The redemptions property
     * @return a {@link RedemptionsRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public RedemptionsRequestBuilder redemptions() {
        return new RedemptionsRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The rewards property
     * @return a {@link RewardsRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public RewardsRequestBuilder rewards() {
        return new RewardsRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The statistics property
     * @return a {@link StatisticsRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public StatisticsRequestBuilder statistics() {
        return new StatisticsRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The transactions property
     * @return a {@link TransactionsRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public TransactionsRequestBuilder transactions() {
        return new TransactionsRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * The vouchers property
     * @return a {@link VouchersRequestBuilder}
     */
    @jakarta.annotation.Nonnull
    public VouchersRequestBuilder vouchers() {
        return new VouchersRequestBuilder(pathParameters, requestAdapter);
    }
    /**
     * Instantiates a new {@link PuntjesClient} and sets the default values.
     * @param requestAdapter The request adapter to use to execute the requests.
     */
    public PuntjesClient(@jakarta.annotation.Nonnull final RequestAdapter requestAdapter) {
        super(requestAdapter, "{+baseurl}");
        this.pathParameters = new HashMap<>();
        ApiClientBuilder.registerDefaultSerializer(() -> new JsonSerializationWriterFactory());
        ApiClientBuilder.registerDefaultSerializer(() -> new TextSerializationWriterFactory());
        ApiClientBuilder.registerDefaultDeserializer(() -> new JsonParseNodeFactory());
        ApiClientBuilder.registerDefaultDeserializer(() -> new TextParseNodeFactory());
        if (requestAdapter.getBaseUrl() == null || requestAdapter.getBaseUrl().isEmpty()) {
            requestAdapter.setBaseUrl("https://puntjes.app/api/v1");
        }
        pathParameters.put("baseurl", requestAdapter.getBaseUrl());
    }
}
