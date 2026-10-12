package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class VolumeBucketData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The label property
     */
    private String label;
    /**
     * The orders property
     */
    private Integer orders;
    /**
     * The revenue property
     */
    private Integer revenue;
    /**
     * Instantiates a new {@link VolumeBucketData} and sets the default values.
     */
    public VolumeBucketData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link VolumeBucketData}
     */
    @jakarta.annotation.Nonnull
    public static VolumeBucketData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new VolumeBucketData();
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
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(3);
        deserializerMap.put("label", (n) -> { this.setLabel(n.getStringValue()); });
        deserializerMap.put("orders", (n) -> { this.setOrders(n.getIntegerValue()); });
        deserializerMap.put("revenue", (n) -> { this.setRevenue(n.getIntegerValue()); });
        return deserializerMap;
    }
    /**
     * Gets the label property value. The label property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getLabel() {
        return this.label;
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
     * Gets the revenue property value. The revenue property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getRevenue() {
        return this.revenue;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("label", this.getLabel());
        writer.writeIntegerValue("orders", this.getOrders());
        writer.writeIntegerValue("revenue", this.getRevenue());
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
     * Sets the label property value. The label property
     * @param value Value to set for the label property.
     */
    public void setLabel(@jakarta.annotation.Nullable final String value) {
        this.label = value;
    }
    /**
     * Sets the orders property value. The orders property
     * @param value Value to set for the orders property.
     */
    public void setOrders(@jakarta.annotation.Nullable final Integer value) {
        this.orders = value;
    }
    /**
     * Sets the revenue property value. The revenue property
     * @param value Value to set for the revenue property.
     */
    public void setRevenue(@jakarta.annotation.Nullable final Integer value) {
        this.revenue = value;
    }
}
