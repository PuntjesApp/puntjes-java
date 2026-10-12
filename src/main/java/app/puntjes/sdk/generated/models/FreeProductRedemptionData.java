package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class FreeProductRedemptionData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * What the till collects on top of the points, in cents; `0` when the points cover it.
     */
    private Integer paymentAmount;
    /**
     * Your own identifier for the product to hand over.
     */
    private String productReference;
    /**
     * Which shape this is.
     */
    private FreeProductRedemptionDataType type;
    /**
     * Instantiates a new {@link FreeProductRedemptionData} and sets the default values.
     */
    public FreeProductRedemptionData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link FreeProductRedemptionData}
     */
    @jakarta.annotation.Nonnull
    public static FreeProductRedemptionData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new FreeProductRedemptionData();
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
        deserializerMap.put("payment_amount", (n) -> { this.setPaymentAmount(n.getIntegerValue()); });
        deserializerMap.put("product_reference", (n) -> { this.setProductReference(n.getStringValue()); });
        deserializerMap.put("type", (n) -> { this.setType(n.getEnumValue(FreeProductRedemptionDataType::forValue)); });
        return deserializerMap;
    }
    /**
     * Gets the payment_amount property value. What the till collects on top of the points, in cents; `0` when the points cover it.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getPaymentAmount() {
        return this.paymentAmount;
    }
    /**
     * Gets the product_reference property value. Your own identifier for the product to hand over.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getProductReference() {
        return this.productReference;
    }
    /**
     * Gets the type property value. Which shape this is.
     * @return a {@link FreeProductRedemptionDataType}
     */
    @jakarta.annotation.Nullable
    public FreeProductRedemptionDataType getType() {
        return this.type;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeIntegerValue("payment_amount", this.getPaymentAmount());
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
     * Sets the payment_amount property value. What the till collects on top of the points, in cents; `0` when the points cover it.
     * @param value Value to set for the payment_amount property.
     */
    public void setPaymentAmount(@jakarta.annotation.Nullable final Integer value) {
        this.paymentAmount = value;
    }
    /**
     * Sets the product_reference property value. Your own identifier for the product to hand over.
     * @param value Value to set for the product_reference property.
     */
    public void setProductReference(@jakarta.annotation.Nullable final String value) {
        this.productReference = value;
    }
    /**
     * Sets the type property value. Which shape this is.
     * @param value Value to set for the type property.
     */
    public void setType(@jakarta.annotation.Nullable final FreeProductRedemptionDataType value) {
        this.type = value;
    }
}
