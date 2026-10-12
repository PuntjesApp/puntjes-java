package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class UpsertProductData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The category property
     */
    private String category;
    /**
     * The description property
     */
    private String description;
    /**
     * The image_url property
     */
    private String imageUrl;
    /**
     * The metadata property
     */
    private UpsertProductDataMetadata metadata;
    /**
     * The name property
     */
    private String name;
    /**
     * The price_cents property
     */
    private Integer priceCents;
    /**
     * The status property
     */
    private UpsertProductDataStatus status;
    /**
     * The stock property
     */
    private Integer stock;
    /**
     * Instantiates a new {@link UpsertProductData} and sets the default values.
     */
    public UpsertProductData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link UpsertProductData}
     */
    @jakarta.annotation.Nonnull
    public static UpsertProductData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new UpsertProductData();
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
     * Gets the category property value. The category property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getCategory() {
        return this.category;
    }
    /**
     * Gets the description property value. The description property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getDescription() {
        return this.description;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(8);
        deserializerMap.put("category", (n) -> { this.setCategory(n.getStringValue()); });
        deserializerMap.put("description", (n) -> { this.setDescription(n.getStringValue()); });
        deserializerMap.put("image_url", (n) -> { this.setImageUrl(n.getStringValue()); });
        deserializerMap.put("metadata", (n) -> { this.setMetadata(n.getObjectValue(UpsertProductDataMetadata::createFromDiscriminatorValue)); });
        deserializerMap.put("name", (n) -> { this.setName(n.getStringValue()); });
        deserializerMap.put("price_cents", (n) -> { this.setPriceCents(n.getIntegerValue()); });
        deserializerMap.put("status", (n) -> { this.setStatus(n.getEnumValue(UpsertProductDataStatus::forValue)); });
        deserializerMap.put("stock", (n) -> { this.setStock(n.getIntegerValue()); });
        return deserializerMap;
    }
    /**
     * Gets the image_url property value. The image_url property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getImageUrl() {
        return this.imageUrl;
    }
    /**
     * Gets the metadata property value. The metadata property
     * @return a {@link UpsertProductDataMetadata}
     */
    @jakarta.annotation.Nullable
    public UpsertProductDataMetadata getMetadata() {
        return this.metadata;
    }
    /**
     * Gets the name property value. The name property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getName() {
        return this.name;
    }
    /**
     * Gets the price_cents property value. The price_cents property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getPriceCents() {
        return this.priceCents;
    }
    /**
     * Gets the status property value. The status property
     * @return a {@link UpsertProductDataStatus}
     */
    @jakarta.annotation.Nullable
    public UpsertProductDataStatus getStatus() {
        return this.status;
    }
    /**
     * Gets the stock property value. The stock property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getStock() {
        return this.stock;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("category", this.getCategory());
        writer.writeStringValue("description", this.getDescription());
        writer.writeStringValue("image_url", this.getImageUrl());
        writer.writeObjectValue("metadata", this.getMetadata());
        writer.writeStringValue("name", this.getName());
        writer.writeIntegerValue("price_cents", this.getPriceCents());
        writer.writeEnumValue("status", this.getStatus());
        writer.writeIntegerValue("stock", this.getStock());
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
     * Sets the category property value. The category property
     * @param value Value to set for the category property.
     */
    public void setCategory(@jakarta.annotation.Nullable final String value) {
        this.category = value;
    }
    /**
     * Sets the description property value. The description property
     * @param value Value to set for the description property.
     */
    public void setDescription(@jakarta.annotation.Nullable final String value) {
        this.description = value;
    }
    /**
     * Sets the image_url property value. The image_url property
     * @param value Value to set for the image_url property.
     */
    public void setImageUrl(@jakarta.annotation.Nullable final String value) {
        this.imageUrl = value;
    }
    /**
     * Sets the metadata property value. The metadata property
     * @param value Value to set for the metadata property.
     */
    public void setMetadata(@jakarta.annotation.Nullable final UpsertProductDataMetadata value) {
        this.metadata = value;
    }
    /**
     * Sets the name property value. The name property
     * @param value Value to set for the name property.
     */
    public void setName(@jakarta.annotation.Nullable final String value) {
        this.name = value;
    }
    /**
     * Sets the price_cents property value. The price_cents property
     * @param value Value to set for the price_cents property.
     */
    public void setPriceCents(@jakarta.annotation.Nullable final Integer value) {
        this.priceCents = value;
    }
    /**
     * Sets the status property value. The status property
     * @param value Value to set for the status property.
     */
    public void setStatus(@jakarta.annotation.Nullable final UpsertProductDataStatus value) {
        this.status = value;
    }
    /**
     * Sets the stock property value. The stock property
     * @param value Value to set for the stock property.
     */
    public void setStock(@jakarta.annotation.Nullable final Integer value) {
        this.stock = value;
    }
}
