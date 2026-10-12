package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class FixedDiscountData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * How much to take off, in cents.
     */
    private Integer amountCents;
    /**
     * Deprecated: read `type`, which carries the same value. Always `fixed` for this shape.
     * @deprecated
     * 
     */
    @Deprecated
    private FixedDiscountDataKind kind;
    /**
     * The one product the discount is for; leave it out for the whole purchase.
     */
    private Integer productId;
    /**
     * Which shape this is.
     */
    private FixedDiscountDataType type;
    /**
     * Instantiates a new {@link FixedDiscountData} and sets the default values.
     */
    public FixedDiscountData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link FixedDiscountData}
     */
    @jakarta.annotation.Nonnull
    public static FixedDiscountData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new FixedDiscountData();
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
     * Gets the amount_cents property value. How much to take off, in cents.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getAmountCents() {
        return this.amountCents;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(4);
        deserializerMap.put("amount_cents", (n) -> { this.setAmountCents(n.getIntegerValue()); });
        deserializerMap.put("kind", (n) -> { this.setKind(n.getEnumValue(FixedDiscountDataKind::forValue)); });
        deserializerMap.put("product_id", (n) -> { this.setProductId(n.getIntegerValue()); });
        deserializerMap.put("type", (n) -> { this.setType(n.getEnumValue(FixedDiscountDataType::forValue)); });
        return deserializerMap;
    }
    /**
     * Gets the kind property value. Deprecated: read `type`, which carries the same value. Always `fixed` for this shape.
     * @return a {@link FixedDiscountDataKind}
     * @deprecated
     * 
     */
    @jakarta.annotation.Nullable
    @Deprecated
    public FixedDiscountDataKind getKind() {
        return this.kind;
    }
    /**
     * Gets the product_id property value. The one product the discount is for; leave it out for the whole purchase.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getProductId() {
        return this.productId;
    }
    /**
     * Gets the type property value. Which shape this is.
     * @return a {@link FixedDiscountDataType}
     */
    @jakarta.annotation.Nullable
    public FixedDiscountDataType getType() {
        return this.type;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeIntegerValue("amount_cents", this.getAmountCents());
        writer.writeEnumValue("kind", this.getKind());
        writer.writeIntegerValue("product_id", this.getProductId());
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
     * Sets the amount_cents property value. How much to take off, in cents.
     * @param value Value to set for the amount_cents property.
     */
    public void setAmountCents(@jakarta.annotation.Nullable final Integer value) {
        this.amountCents = value;
    }
    /**
     * Sets the kind property value. Deprecated: read `type`, which carries the same value. Always `fixed` for this shape.
     * @param value Value to set for the kind property.
     * @deprecated
     * 
     */
    @Deprecated
    public void setKind(@jakarta.annotation.Nullable final FixedDiscountDataKind value) {
        this.kind = value;
    }
    /**
     * Sets the product_id property value. The one product the discount is for; leave it out for the whole purchase.
     * @param value Value to set for the product_id property.
     */
    public void setProductId(@jakarta.annotation.Nullable final Integer value) {
        this.productId = value;
    }
    /**
     * Sets the type property value. Which shape this is.
     * @param value Value to set for the type property.
     */
    public void setType(@jakarta.annotation.Nullable final FixedDiscountDataType value) {
        this.type = value;
    }
}
