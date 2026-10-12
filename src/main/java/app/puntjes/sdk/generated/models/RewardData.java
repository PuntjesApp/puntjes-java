package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class RewardData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The available_from property
     */
    private String availableFrom;
    /**
     * The available_until property
     */
    private String availableUntil;
    /**
     * The code_valid_for_hours property
     */
    private Integer codeValidForHours;
    /**
     * The created_at property
     */
    private String createdAt;
    /**
     * The description property
     */
    private String description;
    /**
     * The discount_type property
     */
    private String discountType;
    /**
     * The discount_value property
     */
    private Integer discountValue;
    /**
     * The id property
     */
    private Integer id;
    /**
     * The image_url property
     */
    private String imageUrl;
    /**
     * True when the reward has no stock limit; remaining_stock is then 0.
     */
    private Boolean isUnlimited;
    /**
     * The max_redemptions_per_customer property
     */
    private Integer maxRedemptionsPerCustomer;
    /**
     * The name property
     */
    private String name;
    /**
     * The payment_amount property
     */
    private Integer paymentAmount;
    /**
     * The point_cost property
     */
    private Integer pointCost;
    /**
     * The product_id property
     */
    private Integer productId;
    /**
     * The product_reference property
     */
    private String productReference;
    /**
     * The remaining_stock property
     */
    private Integer remainingStock;
    /**
     * The status property
     */
    private RewardStatusData status;
    /**
     * The total_stock property
     */
    private Integer totalStock;
    /**
     * The type property
     */
    private String type;
    /**
     * The updated_at property
     */
    private String updatedAt;
    /**
     * Instantiates a new {@link RewardData} and sets the default values.
     */
    public RewardData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link RewardData}
     */
    @jakarta.annotation.Nonnull
    public static RewardData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new RewardData();
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
     * Gets the available_from property value. The available_from property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getAvailableFrom() {
        return this.availableFrom;
    }
    /**
     * Gets the available_until property value. The available_until property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getAvailableUntil() {
        return this.availableUntil;
    }
    /**
     * Gets the code_valid_for_hours property value. The code_valid_for_hours property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getCodeValidForHours() {
        return this.codeValidForHours;
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
     * Gets the description property value. The description property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getDescription() {
        return this.description;
    }
    /**
     * Gets the discount_type property value. The discount_type property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getDiscountType() {
        return this.discountType;
    }
    /**
     * Gets the discount_value property value. The discount_value property
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
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(21);
        deserializerMap.put("available_from", (n) -> { this.setAvailableFrom(n.getStringValue()); });
        deserializerMap.put("available_until", (n) -> { this.setAvailableUntil(n.getStringValue()); });
        deserializerMap.put("code_valid_for_hours", (n) -> { this.setCodeValidForHours(n.getIntegerValue()); });
        deserializerMap.put("created_at", (n) -> { this.setCreatedAt(n.getStringValue()); });
        deserializerMap.put("description", (n) -> { this.setDescription(n.getStringValue()); });
        deserializerMap.put("discount_type", (n) -> { this.setDiscountType(n.getStringValue()); });
        deserializerMap.put("discount_value", (n) -> { this.setDiscountValue(n.getIntegerValue()); });
        deserializerMap.put("id", (n) -> { this.setId(n.getIntegerValue()); });
        deserializerMap.put("image_url", (n) -> { this.setImageUrl(n.getStringValue()); });
        deserializerMap.put("is_unlimited", (n) -> { this.setIsUnlimited(n.getBooleanValue()); });
        deserializerMap.put("max_redemptions_per_customer", (n) -> { this.setMaxRedemptionsPerCustomer(n.getIntegerValue()); });
        deserializerMap.put("name", (n) -> { this.setName(n.getStringValue()); });
        deserializerMap.put("payment_amount", (n) -> { this.setPaymentAmount(n.getIntegerValue()); });
        deserializerMap.put("point_cost", (n) -> { this.setPointCost(n.getIntegerValue()); });
        deserializerMap.put("product_id", (n) -> { this.setProductId(n.getIntegerValue()); });
        deserializerMap.put("product_reference", (n) -> { this.setProductReference(n.getStringValue()); });
        deserializerMap.put("remaining_stock", (n) -> { this.setRemainingStock(n.getIntegerValue()); });
        deserializerMap.put("status", (n) -> { this.setStatus(n.getObjectValue(RewardStatusData::createFromDiscriminatorValue)); });
        deserializerMap.put("total_stock", (n) -> { this.setTotalStock(n.getIntegerValue()); });
        deserializerMap.put("type", (n) -> { this.setType(n.getStringValue()); });
        deserializerMap.put("updated_at", (n) -> { this.setUpdatedAt(n.getStringValue()); });
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
     * Gets the image_url property value. The image_url property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getImageUrl() {
        return this.imageUrl;
    }
    /**
     * Gets the is_unlimited property value. True when the reward has no stock limit; remaining_stock is then 0.
     * @return a {@link Boolean}
     */
    @jakarta.annotation.Nullable
    public Boolean getIsUnlimited() {
        return this.isUnlimited;
    }
    /**
     * Gets the max_redemptions_per_customer property value. The max_redemptions_per_customer property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getMaxRedemptionsPerCustomer() {
        return this.maxRedemptionsPerCustomer;
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
     * Gets the payment_amount property value. The payment_amount property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getPaymentAmount() {
        return this.paymentAmount;
    }
    /**
     * Gets the point_cost property value. The point_cost property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getPointCost() {
        return this.pointCost;
    }
    /**
     * Gets the product_id property value. The product_id property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getProductId() {
        return this.productId;
    }
    /**
     * Gets the product_reference property value. The product_reference property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getProductReference() {
        return this.productReference;
    }
    /**
     * Gets the remaining_stock property value. The remaining_stock property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getRemainingStock() {
        return this.remainingStock;
    }
    /**
     * Gets the status property value. The status property
     * @return a {@link RewardStatusData}
     */
    @jakarta.annotation.Nullable
    public RewardStatusData getStatus() {
        return this.status;
    }
    /**
     * Gets the total_stock property value. The total_stock property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getTotalStock() {
        return this.totalStock;
    }
    /**
     * Gets the type property value. The type property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getType() {
        return this.type;
    }
    /**
     * Gets the updated_at property value. The updated_at property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getUpdatedAt() {
        return this.updatedAt;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("available_from", this.getAvailableFrom());
        writer.writeStringValue("available_until", this.getAvailableUntil());
        writer.writeIntegerValue("code_valid_for_hours", this.getCodeValidForHours());
        writer.writeStringValue("created_at", this.getCreatedAt());
        writer.writeStringValue("description", this.getDescription());
        writer.writeStringValue("discount_type", this.getDiscountType());
        writer.writeIntegerValue("discount_value", this.getDiscountValue());
        writer.writeIntegerValue("id", this.getId());
        writer.writeStringValue("image_url", this.getImageUrl());
        writer.writeBooleanValue("is_unlimited", this.getIsUnlimited());
        writer.writeIntegerValue("max_redemptions_per_customer", this.getMaxRedemptionsPerCustomer());
        writer.writeStringValue("name", this.getName());
        writer.writeIntegerValue("payment_amount", this.getPaymentAmount());
        writer.writeIntegerValue("point_cost", this.getPointCost());
        writer.writeIntegerValue("product_id", this.getProductId());
        writer.writeStringValue("product_reference", this.getProductReference());
        writer.writeIntegerValue("remaining_stock", this.getRemainingStock());
        writer.writeObjectValue("status", this.getStatus());
        writer.writeIntegerValue("total_stock", this.getTotalStock());
        writer.writeStringValue("type", this.getType());
        writer.writeStringValue("updated_at", this.getUpdatedAt());
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
     * Sets the available_from property value. The available_from property
     * @param value Value to set for the available_from property.
     */
    public void setAvailableFrom(@jakarta.annotation.Nullable final String value) {
        this.availableFrom = value;
    }
    /**
     * Sets the available_until property value. The available_until property
     * @param value Value to set for the available_until property.
     */
    public void setAvailableUntil(@jakarta.annotation.Nullable final String value) {
        this.availableUntil = value;
    }
    /**
     * Sets the code_valid_for_hours property value. The code_valid_for_hours property
     * @param value Value to set for the code_valid_for_hours property.
     */
    public void setCodeValidForHours(@jakarta.annotation.Nullable final Integer value) {
        this.codeValidForHours = value;
    }
    /**
     * Sets the created_at property value. The created_at property
     * @param value Value to set for the created_at property.
     */
    public void setCreatedAt(@jakarta.annotation.Nullable final String value) {
        this.createdAt = value;
    }
    /**
     * Sets the description property value. The description property
     * @param value Value to set for the description property.
     */
    public void setDescription(@jakarta.annotation.Nullable final String value) {
        this.description = value;
    }
    /**
     * Sets the discount_type property value. The discount_type property
     * @param value Value to set for the discount_type property.
     */
    public void setDiscountType(@jakarta.annotation.Nullable final String value) {
        this.discountType = value;
    }
    /**
     * Sets the discount_value property value. The discount_value property
     * @param value Value to set for the discount_value property.
     */
    public void setDiscountValue(@jakarta.annotation.Nullable final Integer value) {
        this.discountValue = value;
    }
    /**
     * Sets the id property value. The id property
     * @param value Value to set for the id property.
     */
    public void setId(@jakarta.annotation.Nullable final Integer value) {
        this.id = value;
    }
    /**
     * Sets the image_url property value. The image_url property
     * @param value Value to set for the image_url property.
     */
    public void setImageUrl(@jakarta.annotation.Nullable final String value) {
        this.imageUrl = value;
    }
    /**
     * Sets the is_unlimited property value. True when the reward has no stock limit; remaining_stock is then 0.
     * @param value Value to set for the is_unlimited property.
     */
    public void setIsUnlimited(@jakarta.annotation.Nullable final Boolean value) {
        this.isUnlimited = value;
    }
    /**
     * Sets the max_redemptions_per_customer property value. The max_redemptions_per_customer property
     * @param value Value to set for the max_redemptions_per_customer property.
     */
    public void setMaxRedemptionsPerCustomer(@jakarta.annotation.Nullable final Integer value) {
        this.maxRedemptionsPerCustomer = value;
    }
    /**
     * Sets the name property value. The name property
     * @param value Value to set for the name property.
     */
    public void setName(@jakarta.annotation.Nullable final String value) {
        this.name = value;
    }
    /**
     * Sets the payment_amount property value. The payment_amount property
     * @param value Value to set for the payment_amount property.
     */
    public void setPaymentAmount(@jakarta.annotation.Nullable final Integer value) {
        this.paymentAmount = value;
    }
    /**
     * Sets the point_cost property value. The point_cost property
     * @param value Value to set for the point_cost property.
     */
    public void setPointCost(@jakarta.annotation.Nullable final Integer value) {
        this.pointCost = value;
    }
    /**
     * Sets the product_id property value. The product_id property
     * @param value Value to set for the product_id property.
     */
    public void setProductId(@jakarta.annotation.Nullable final Integer value) {
        this.productId = value;
    }
    /**
     * Sets the product_reference property value. The product_reference property
     * @param value Value to set for the product_reference property.
     */
    public void setProductReference(@jakarta.annotation.Nullable final String value) {
        this.productReference = value;
    }
    /**
     * Sets the remaining_stock property value. The remaining_stock property
     * @param value Value to set for the remaining_stock property.
     */
    public void setRemainingStock(@jakarta.annotation.Nullable final Integer value) {
        this.remainingStock = value;
    }
    /**
     * Sets the status property value. The status property
     * @param value Value to set for the status property.
     */
    public void setStatus(@jakarta.annotation.Nullable final RewardStatusData value) {
        this.status = value;
    }
    /**
     * Sets the total_stock property value. The total_stock property
     * @param value Value to set for the total_stock property.
     */
    public void setTotalStock(@jakarta.annotation.Nullable final Integer value) {
        this.totalStock = value;
    }
    /**
     * Sets the type property value. The type property
     * @param value Value to set for the type property.
     */
    public void setType(@jakarta.annotation.Nullable final String value) {
        this.type = value;
    }
    /**
     * Sets the updated_at property value. The updated_at property
     * @param value Value to set for the updated_at property.
     */
    public void setUpdatedAt(@jakarta.annotation.Nullable final String value) {
        this.updatedAt = value;
    }
}
