package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class CommerceStatisticsData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The average_order_value_cents property
     */
    private Integer averageOrderValueCents;
    /**
     * The itemized property
     */
    private ItemizedStatisticsData itemized;
    /**
     * The orders property
     */
    private Integer orders;
    /**
     * The revenue_cents property
     */
    private Integer revenueCents;
    /**
     * The volume_trend property
     */
    private java.util.List<VolumeBucketData> volumeTrend;
    /**
     * Instantiates a new {@link CommerceStatisticsData} and sets the default values.
     */
    public CommerceStatisticsData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link CommerceStatisticsData}
     */
    @jakarta.annotation.Nonnull
    public static CommerceStatisticsData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new CommerceStatisticsData();
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
     * Gets the average_order_value_cents property value. The average_order_value_cents property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getAverageOrderValueCents() {
        return this.averageOrderValueCents;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(5);
        deserializerMap.put("average_order_value_cents", (n) -> { this.setAverageOrderValueCents(n.getIntegerValue()); });
        deserializerMap.put("itemized", (n) -> { this.setItemized(n.getObjectValue(ItemizedStatisticsData::createFromDiscriminatorValue)); });
        deserializerMap.put("orders", (n) -> { this.setOrders(n.getIntegerValue()); });
        deserializerMap.put("revenue_cents", (n) -> { this.setRevenueCents(n.getIntegerValue()); });
        deserializerMap.put("volume_trend", (n) -> { this.setVolumeTrend(n.getCollectionOfObjectValues(VolumeBucketData::createFromDiscriminatorValue)); });
        return deserializerMap;
    }
    /**
     * Gets the itemized property value. The itemized property
     * @return a {@link ItemizedStatisticsData}
     */
    @jakarta.annotation.Nullable
    public ItemizedStatisticsData getItemized() {
        return this.itemized;
    }
    /**
     * Gets the orders property value. The orders property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getOrders() {
        return this.orders;
    }
    /**
     * Gets the revenue_cents property value. The revenue_cents property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getRevenueCents() {
        return this.revenueCents;
    }
    /**
     * Gets the volume_trend property value. The volume_trend property
     * @return a {@link java.util.List<VolumeBucketData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<VolumeBucketData> getVolumeTrend() {
        return this.volumeTrend;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeIntegerValue("average_order_value_cents", this.getAverageOrderValueCents());
        writer.writeObjectValue("itemized", this.getItemized());
        writer.writeIntegerValue("orders", this.getOrders());
        writer.writeIntegerValue("revenue_cents", this.getRevenueCents());
        writer.writeCollectionOfObjectValues("volume_trend", this.getVolumeTrend());
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
     * Sets the average_order_value_cents property value. The average_order_value_cents property
     * @param value Value to set for the average_order_value_cents property.
     */
    public void setAverageOrderValueCents(@jakarta.annotation.Nullable final Integer value) {
        this.averageOrderValueCents = value;
    }
    /**
     * Sets the itemized property value. The itemized property
     * @param value Value to set for the itemized property.
     */
    public void setItemized(@jakarta.annotation.Nullable final ItemizedStatisticsData value) {
        this.itemized = value;
    }
    /**
     * Sets the orders property value. The orders property
     * @param value Value to set for the orders property.
     */
    public void setOrders(@jakarta.annotation.Nullable final Integer value) {
        this.orders = value;
    }
    /**
     * Sets the revenue_cents property value. The revenue_cents property
     * @param value Value to set for the revenue_cents property.
     */
    public void setRevenueCents(@jakarta.annotation.Nullable final Integer value) {
        this.revenueCents = value;
    }
    /**
     * Sets the volume_trend property value. The volume_trend property
     * @param value Value to set for the volume_trend property.
     */
    public void setVolumeTrend(@jakarta.annotation.Nullable final java.util.List<VolumeBucketData> value) {
        this.volumeTrend = value;
    }
}
