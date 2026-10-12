package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class DiscountRedemptionData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * Which of the two `discount_value` is.
     */
    private DiscountRedemptionDataDiscountType discountType;
    /**
     * How much comes off: a percentage, or an amount in cents.
     */
    private Integer discountValue;
    /**
     * The item number of the one product the discount is for; null when it counts on the whole purchase.
     */
    private String productReference;
    /**
     * Which shape this is.
     */
    private DiscountRedemptionDataType type;
    /**
     * Instantiates a new {@link DiscountRedemptionData} and sets the default values.
     */
    public DiscountRedemptionData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link DiscountRedemptionData}
     */
    @jakarta.annotation.Nonnull
    public static DiscountRedemptionData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new DiscountRedemptionData();
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
     * Gets the discount_type property value. Which of the two `discount_value` is.
     * @return a {@link DiscountRedemptionDataDiscountType}
     */
    @jakarta.annotation.Nullable
    public DiscountRedemptionDataDiscountType getDiscountType() {
        return this.discountType;
    }
    /**
     * Gets the discount_value property value. How much comes off: a percentage, or an amount in cents.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getDiscountValue() {
        return this.discountValue;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(4);
        deserializerMap.put("discount_type", (n) -> { this.setDiscountType(n.getEnumValue(DiscountRedemptionDataDiscountType::forValue)); });
        deserializerMap.put("discount_value", (n) -> { this.setDiscountValue(n.getIntegerValue()); });
        deserializerMap.put("product_reference", (n) -> { this.setProductReference(n.getStringValue()); });
        deserializerMap.put("type", (n) -> { this.setType(n.getEnumValue(DiscountRedemptionDataType::forValue)); });
        return deserializerMap;
    }
    /**
     * Gets the product_reference property value. The item number of the one product the discount is for; null when it counts on the whole purchase.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getProductReference() {
        return this.productReference;
    }
    /**
     * Gets the type property value. Which shape this is.
     * @return a {@link DiscountRedemptionDataType}
     */
    @jakarta.annotation.Nullable
    public DiscountRedemptionDataType getType() {
        return this.type;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeEnumValue("discount_type", this.getDiscountType());
        writer.writeIntegerValue("discount_value", this.getDiscountValue());
        writer.writeStringValue("product_reference", this.getProductReference());
        writer.writeEnumValue("type", this.getType());
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
     * Sets the discount_type property value. Which of the two `discount_value` is.
     * @param value Value to set for the discount_type property.
     */
    public void setDiscountType(@jakarta.annotation.Nullable final DiscountRedemptionDataDiscountType value) {
        this.discountType = value;
    }
    /**
     * Sets the discount_value property value. How much comes off: a percentage, or an amount in cents.
     * @param value Value to set for the discount_value property.
     */
    public void setDiscountValue(@jakarta.annotation.Nullable final Integer value) {
        this.discountValue = value;
    }
    /**
     * Sets the product_reference property value. The item number of the one product the discount is for; null when it counts on the whole purchase.
     * @param value Value to set for the product_reference property.
     */
    public void setProductReference(@jakarta.annotation.Nullable final String value) {
        this.productReference = value;
    }
    /**
     * Sets the type property value. Which shape this is.
     * @param value Value to set for the type property.
     */
    public void setType(@jakarta.annotation.Nullable final DiscountRedemptionDataType value) {
        this.type = value;
    }
}
