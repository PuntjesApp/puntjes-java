package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class CreateTransactionData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The branch property
     */
    private String branch;
    /**
     * The description property
     */
    private String description;
    /**
     * The external_reference property
     */
    private String externalReference;
    /**
     * The idempotency_key property
     */
    private String idempotencyKey;
    /**
     * The identifier property
     */
    private String identifier;
    /**
     * Optional order line items.
     */
    private java.util.List<CreateTransactionItemData> items;
    /**
     * The total_amount property
     */
    private Integer totalAmount;
    /**
     * Instantiates a new {@link CreateTransactionData} and sets the default values.
     */
    public CreateTransactionData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link CreateTransactionData}
     */
    @jakarta.annotation.Nonnull
    public static CreateTransactionData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new CreateTransactionData();
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
     * Gets the branch property value. The branch property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getBranch() {
        return this.branch;
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
     * Gets the external_reference property value. The external_reference property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getExternalReference() {
        return this.externalReference;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(7);
        deserializerMap.put("branch", (n) -> { this.setBranch(n.getStringValue()); });
        deserializerMap.put("description", (n) -> { this.setDescription(n.getStringValue()); });
        deserializerMap.put("external_reference", (n) -> { this.setExternalReference(n.getStringValue()); });
        deserializerMap.put("idempotency_key", (n) -> { this.setIdempotencyKey(n.getStringValue()); });
        deserializerMap.put("identifier", (n) -> { this.setIdentifier(n.getStringValue()); });
        deserializerMap.put("items", (n) -> { this.setItems(n.getCollectionOfObjectValues(CreateTransactionItemData::createFromDiscriminatorValue)); });
        deserializerMap.put("total_amount", (n) -> { this.setTotalAmount(n.getIntegerValue()); });
        return deserializerMap;
    }
    /**
     * Gets the idempotency_key property value. The idempotency_key property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }
    /**
     * Gets the identifier property value. The identifier property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getIdentifier() {
        return this.identifier;
    }
    /**
     * Gets the items property value. Optional order line items.
     * @return a {@link java.util.List<CreateTransactionItemData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<CreateTransactionItemData> getItems() {
        return this.items;
    }
    /**
     * Gets the total_amount property value. The total_amount property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getTotalAmount() {
        return this.totalAmount;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("branch", this.getBranch());
        writer.writeStringValue("description", this.getDescription());
        writer.writeStringValue("external_reference", this.getExternalReference());
        writer.writeStringValue("idempotency_key", this.getIdempotencyKey());
        writer.writeStringValue("identifier", this.getIdentifier());
        writer.writeCollectionOfObjectValues("items", this.getItems());
        writer.writeIntegerValue("total_amount", this.getTotalAmount());
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
     * Sets the branch property value. The branch property
     * @param value Value to set for the branch property.
     */
    public void setBranch(@jakarta.annotation.Nullable final String value) {
        this.branch = value;
    }
    /**
     * Sets the description property value. The description property
     * @param value Value to set for the description property.
     */
    public void setDescription(@jakarta.annotation.Nullable final String value) {
        this.description = value;
    }
    /**
     * Sets the external_reference property value. The external_reference property
     * @param value Value to set for the external_reference property.
     */
    public void setExternalReference(@jakarta.annotation.Nullable final String value) {
        this.externalReference = value;
    }
    /**
     * Sets the idempotency_key property value. The idempotency_key property
     * @param value Value to set for the idempotency_key property.
     */
    public void setIdempotencyKey(@jakarta.annotation.Nullable final String value) {
        this.idempotencyKey = value;
    }
    /**
     * Sets the identifier property value. The identifier property
     * @param value Value to set for the identifier property.
     */
    public void setIdentifier(@jakarta.annotation.Nullable final String value) {
        this.identifier = value;
    }
    /**
     * Sets the items property value. Optional order line items.
     * @param value Value to set for the items property.
     */
    public void setItems(@jakarta.annotation.Nullable final java.util.List<CreateTransactionItemData> value) {
        this.items = value;
    }
    /**
     * Sets the total_amount property value. The total_amount property
     * @param value Value to set for the total_amount property.
     */
    public void setTotalAmount(@jakarta.annotation.Nullable final Integer value) {
        this.totalAmount = value;
    }
}
