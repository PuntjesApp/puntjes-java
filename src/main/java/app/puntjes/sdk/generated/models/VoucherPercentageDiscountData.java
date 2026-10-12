package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class VoucherPercentageDiscountData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * Deprecated: read `type`, which carries the same value. Always `percentage` for this shape.
     * @deprecated
     * 
     */
    @Deprecated
    private VoucherPercentageDiscountDataKind kind;
    /**
     * How many percent to take off, 1 to 100.
     */
    private Integer percentage;
    /**
     * The item number of the one product the discount is for; null for the whole purchase.
     */
    private String productReference;
    /**
     * Which shape this is.
     */
    private VoucherPercentageDiscountDataType type;
    /**
     * Instantiates a new {@link VoucherPercentageDiscountData} and sets the default values.
     */
    public VoucherPercentageDiscountData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link VoucherPercentageDiscountData}
     */
    @jakarta.annotation.Nonnull
    public static VoucherPercentageDiscountData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new VoucherPercentageDiscountData();
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
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(4);
        deserializerMap.put("kind", (n) -> { this.setKind(n.getEnumValue(VoucherPercentageDiscountDataKind::forValue)); });
        deserializerMap.put("percentage", (n) -> { this.setPercentage(n.getIntegerValue()); });
        deserializerMap.put("product_reference", (n) -> { this.setProductReference(n.getStringValue()); });
        deserializerMap.put("type", (n) -> { this.setType(n.getEnumValue(VoucherPercentageDiscountDataType::forValue)); });
        return deserializerMap;
    }
    /**
     * Gets the kind property value. Deprecated: read `type`, which carries the same value. Always `percentage` for this shape.
     * @return a {@link VoucherPercentageDiscountDataKind}
     * @deprecated
     * 
     */
    @jakarta.annotation.Nullable
    @Deprecated
    public VoucherPercentageDiscountDataKind getKind() {
        return this.kind;
    }
    /**
     * Gets the percentage property value. How many percent to take off, 1 to 100.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getPercentage() {
        return this.percentage;
    }
    /**
     * Gets the product_reference property value. The item number of the one product the discount is for; null for the whole purchase.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getProductReference() {
        return this.productReference;
    }
    /**
     * Gets the type property value. Which shape this is.
     * @return a {@link VoucherPercentageDiscountDataType}
     */
    @jakarta.annotation.Nullable
    public VoucherPercentageDiscountDataType getType() {
        return this.type;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeEnumValue("kind", this.getKind());
        writer.writeIntegerValue("percentage", this.getPercentage());
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
     * Sets the kind property value. Deprecated: read `type`, which carries the same value. Always `percentage` for this shape.
     * @param value Value to set for the kind property.
     * @deprecated
     * 
     */
    @Deprecated
    public void setKind(@jakarta.annotation.Nullable final VoucherPercentageDiscountDataKind value) {
        this.kind = value;
    }
    /**
     * Sets the percentage property value. How many percent to take off, 1 to 100.
     * @param value Value to set for the percentage property.
     */
    public void setPercentage(@jakarta.annotation.Nullable final Integer value) {
        this.percentage = value;
    }
    /**
     * Sets the product_reference property value. The item number of the one product the discount is for; null for the whole purchase.
     * @param value Value to set for the product_reference property.
     */
    public void setProductReference(@jakarta.annotation.Nullable final String value) {
        this.productReference = value;
    }
    /**
     * Sets the type property value. Which shape this is.
     * @param value Value to set for the type property.
     */
    public void setType(@jakarta.annotation.Nullable final VoucherPercentageDiscountDataType value) {
        this.type = value;
    }
}
