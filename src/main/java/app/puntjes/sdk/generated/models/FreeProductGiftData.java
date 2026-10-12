package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class FreeProductGiftData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * A line the customer reads with the gift.
     */
    private String message;
    /**
     * The products the customer gets.
     */
    private java.util.List<GiftProductData> products;
    /**
     * Always `free_product` for this shape.
     */
    private FreeProductGiftDataType type;
    /**
     * Instantiates a new {@link FreeProductGiftData} and sets the default values.
     */
    public FreeProductGiftData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link FreeProductGiftData}
     */
    @jakarta.annotation.Nonnull
    public static FreeProductGiftData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new FreeProductGiftData();
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
        deserializerMap.put("message", (n) -> { this.setMessage(n.getStringValue()); });
        deserializerMap.put("products", (n) -> { this.setProducts(n.getCollectionOfObjectValues(GiftProductData::createFromDiscriminatorValue)); });
        deserializerMap.put("type", (n) -> { this.setType(n.getEnumValue(FreeProductGiftDataType::forValue)); });
        return deserializerMap;
    }
    /**
     * Gets the message property value. A line the customer reads with the gift.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getMessage() {
        return this.message;
    }
    /**
     * Gets the products property value. The products the customer gets.
     * @return a {@link java.util.List<GiftProductData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<GiftProductData> getProducts() {
        return this.products;
    }
    /**
     * Gets the type property value. Always `free_product` for this shape.
     * @return a {@link FreeProductGiftDataType}
     */
    @jakarta.annotation.Nullable
    public FreeProductGiftDataType getType() {
        return this.type;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("message", this.getMessage());
        writer.writeCollectionOfObjectValues("products", this.getProducts());
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
     * Sets the message property value. A line the customer reads with the gift.
     * @param value Value to set for the message property.
     */
    public void setMessage(@jakarta.annotation.Nullable final String value) {
        this.message = value;
    }
    /**
     * Sets the products property value. The products the customer gets.
     * @param value Value to set for the products property.
     */
    public void setProducts(@jakarta.annotation.Nullable final java.util.List<GiftProductData> value) {
        this.products = value;
    }
    /**
     * Sets the type property value. Always `free_product` for this shape.
     * @param value Value to set for the type property.
     */
    public void setType(@jakarta.annotation.Nullable final FreeProductGiftDataType value) {
        this.type = value;
    }
}
