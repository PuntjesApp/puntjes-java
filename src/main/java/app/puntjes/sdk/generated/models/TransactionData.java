package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class TransactionData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The branch property
     */
    private BranchReferenceData branch;
    /**
     * The created_at property
     */
    private String createdAt;
    /**
     * The customer_id property
     */
    private Integer customerId;
    /**
     * The description property
     */
    private String description;
    /**
     * The external_reference property
     */
    private String externalReference;
    /**
     * The id property
     */
    private Integer id;
    /**
     * The idempotency_key property
     */
    private String idempotencyKey;
    /**
     * The items property
     */
    private java.util.List<TransactionItemData> items;
    /**
     * The points_earned property
     */
    private Integer pointsEarned;
    /**
     * The rules_applied property
     */
    private java.util.List<EarnResultData> rulesApplied;
    /**
     * The total_amount property
     */
    private Integer totalAmount;
    /**
     * Instantiates a new {@link TransactionData} and sets the default values.
     */
    public TransactionData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link TransactionData}
     */
    @jakarta.annotation.Nonnull
    public static TransactionData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new TransactionData();
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
     * @return a {@link BranchReferenceData}
     */
    @jakarta.annotation.Nullable
    public BranchReferenceData getBranch() {
        return this.branch;
    }
    /**
     * Gets the created_at property value. The created_at property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getCreatedAt() {
        return this.createdAt;
    }
    /**
     * Gets the customer_id property value. The customer_id property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getCustomerId() {
        return this.customerId;
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
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(11);
        deserializerMap.put("branch", (n) -> { this.setBranch(n.getObjectValue(BranchReferenceData::createFromDiscriminatorValue)); });
        deserializerMap.put("created_at", (n) -> { this.setCreatedAt(n.getStringValue()); });
        deserializerMap.put("customer_id", (n) -> { this.setCustomerId(n.getIntegerValue()); });
        deserializerMap.put("description", (n) -> { this.setDescription(n.getStringValue()); });
        deserializerMap.put("external_reference", (n) -> { this.setExternalReference(n.getStringValue()); });
        deserializerMap.put("id", (n) -> { this.setId(n.getIntegerValue()); });
        deserializerMap.put("idempotency_key", (n) -> { this.setIdempotencyKey(n.getStringValue()); });
        deserializerMap.put("items", (n) -> { this.setItems(n.getCollectionOfObjectValues(TransactionItemData::createFromDiscriminatorValue)); });
        deserializerMap.put("points_earned", (n) -> { this.setPointsEarned(n.getIntegerValue()); });
        deserializerMap.put("rules_applied", (n) -> { this.setRulesApplied(n.getCollectionOfObjectValues(EarnResultData::createFromDiscriminatorValue)); });
        deserializerMap.put("total_amount", (n) -> { this.setTotalAmount(n.getIntegerValue()); });
        return deserializerMap;
    }
    /**
     * Gets the id property value. The id property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getId() {
        return this.id;
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
     * Gets the items property value. The items property
     * @return a {@link java.util.List<TransactionItemData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<TransactionItemData> getItems() {
        return this.items;
    }
    /**
     * Gets the points_earned property value. The points_earned property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getPointsEarned() {
        return this.pointsEarned;
    }
    /**
     * Gets the rules_applied property value. The rules_applied property
     * @return a {@link java.util.List<EarnResultData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<EarnResultData> getRulesApplied() {
        return this.rulesApplied;
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
        writer.writeObjectValue("branch", this.getBranch());
        writer.writeStringValue("created_at", this.getCreatedAt());
        writer.writeIntegerValue("customer_id", this.getCustomerId());
        writer.writeStringValue("description", this.getDescription());
        writer.writeStringValue("external_reference", this.getExternalReference());
        writer.writeIntegerValue("id", this.getId());
        writer.writeStringValue("idempotency_key", this.getIdempotencyKey());
        writer.writeCollectionOfObjectValues("items", this.getItems());
        writer.writeIntegerValue("points_earned", this.getPointsEarned());
        writer.writeCollectionOfObjectValues("rules_applied", this.getRulesApplied());
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
    public void setBranch(@jakarta.annotation.Nullable final BranchReferenceData value) {
        this.branch = value;
    }
    /**
     * Sets the created_at property value. The created_at property
     * @param value Value to set for the created_at property.
     */
    public void setCreatedAt(@jakarta.annotation.Nullable final String value) {
        this.createdAt = value;
    }
    /**
     * Sets the customer_id property value. The customer_id property
     * @param value Value to set for the customer_id property.
     */
    public void setCustomerId(@jakarta.annotation.Nullable final Integer value) {
        this.customerId = value;
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
     * Sets the id property value. The id property
     * @param value Value to set for the id property.
     */
    public void setId(@jakarta.annotation.Nullable final Integer value) {
        this.id = value;
    }
    /**
     * Sets the idempotency_key property value. The idempotency_key property
     * @param value Value to set for the idempotency_key property.
     */
    public void setIdempotencyKey(@jakarta.annotation.Nullable final String value) {
        this.idempotencyKey = value;
    }
    /**
     * Sets the items property value. The items property
     * @param value Value to set for the items property.
     */
    public void setItems(@jakarta.annotation.Nullable final java.util.List<TransactionItemData> value) {
        this.items = value;
    }
    /**
     * Sets the points_earned property value. The points_earned property
     * @param value Value to set for the points_earned property.
     */
    public void setPointsEarned(@jakarta.annotation.Nullable final Integer value) {
        this.pointsEarned = value;
    }
    /**
     * Sets the rules_applied property value. The rules_applied property
     * @param value Value to set for the rules_applied property.
     */
    public void setRulesApplied(@jakarta.annotation.Nullable final java.util.List<EarnResultData> value) {
        this.rulesApplied = value;
    }
    /**
     * Sets the total_amount property value. The total_amount property
     * @param value Value to set for the total_amount property.
     */
    public void setTotalAmount(@jakarta.annotation.Nullable final Integer value) {
        this.totalAmount = value;
    }
}
