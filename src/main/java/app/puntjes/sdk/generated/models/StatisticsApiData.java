package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class StatisticsApiData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The commerce property
     */
    private CommerceStatisticsData commerce;
    /**
     * The loyalty property
     */
    private LoyaltyStatisticsData loyalty;
    /**
     * The period property
     */
    private StatisticsPeriodData period;
    /**
     * Instantiates a new {@link StatisticsApiData} and sets the default values.
     */
    public StatisticsApiData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link StatisticsApiData}
     */
    @jakarta.annotation.Nonnull
    public static StatisticsApiData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new StatisticsApiData();
    }
    /**
     * Gets the AdditionalData property value. Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     * @return a {@link Map<String, Object>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, Object> getAdditionalData() {
        return this.additionalData;
    }
    /**
     * Gets the commerce property value. The commerce property
     * @return a {@link CommerceStatisticsData}
     */
    @jakarta.annotation.Nullable
    public CommerceStatisticsData getCommerce() {
        return this.commerce;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(3);
        deserializerMap.put("commerce", (n) -> { this.setCommerce(n.getObjectValue(CommerceStatisticsData::createFromDiscriminatorValue)); });
        deserializerMap.put("loyalty", (n) -> { this.setLoyalty(n.getObjectValue(LoyaltyStatisticsData::createFromDiscriminatorValue)); });
        deserializerMap.put("period", (n) -> { this.setPeriod(n.getObjectValue(StatisticsPeriodData::createFromDiscriminatorValue)); });
        return deserializerMap;
    }
    /**
     * Gets the loyalty property value. The loyalty property
     * @return a {@link LoyaltyStatisticsData}
     */
    @jakarta.annotation.Nullable
    public LoyaltyStatisticsData getLoyalty() {
        return this.loyalty;
    }
    /**
     * Gets the period property value. The period property
     * @return a {@link StatisticsPeriodData}
     */
    @jakarta.annotation.Nullable
    public StatisticsPeriodData getPeriod() {
        return this.period;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeObjectValue("commerce", this.getCommerce());
        writer.writeObjectValue("loyalty", this.getLoyalty());
        writer.writeObjectValue("period", this.getPeriod());
        writer.writeAdditionalData(this.getAdditionalData());
    }
    /**
     * Sets the AdditionalData property value. Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     * @param value Value to set for the AdditionalData property.
     */
    public void setAdditionalData(@jakarta.annotation.Nullable final Map<String, Object> value) {
        this.additionalData = value;
    }
    /**
     * Sets the commerce property value. The commerce property
     * @param value Value to set for the commerce property.
     */
    public void setCommerce(@jakarta.annotation.Nullable final CommerceStatisticsData value) {
        this.commerce = value;
    }
    /**
     * Sets the loyalty property value. The loyalty property
     * @param value Value to set for the loyalty property.
     */
    public void setLoyalty(@jakarta.annotation.Nullable final LoyaltyStatisticsData value) {
        this.loyalty = value;
    }
    /**
     * Sets the period property value. The period property
     * @param value Value to set for the period property.
     */
    public void setPeriod(@jakarta.annotation.Nullable final StatisticsPeriodData value) {
        this.period = value;
    }
}
