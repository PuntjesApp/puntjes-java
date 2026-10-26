package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class TransactionCampaignConfigData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The branches this campaign runs in. Absent or empty means all of them.
     */
    private java.util.List<Integer> branchIds;
    /**
     * The groups this campaign is for. Absent or empty means everyone.
     */
    private java.util.List<Integer> customerGroupIds;
    /**
     * The most this campaign pays out on one purchase.
     */
    private Integer maxPointsPerPurchase;
    /**
     * The points added, when `reward_type` is `fixed_points`.
     */
    private Integer points;
    /**
     * The products the campaign is limited to, when `scope` is `products`.
     */
    private java.util.List<CampaignProductRuleData> products;
    /**
     * Multiply the points earned, or add a fixed number. Absent reads as `multiplier`.
     */
    private TransactionCampaignConfigDataRewardType rewardType;
    /**
     * `whole` and `whole_purchase` both mean the whole purchase. Absent reads as `whole`.
     */
    private TransactionCampaignConfigDataScope scope;
    /**
     * Whether it pays out beside another campaign. Older rows carry `combineerbaar`.
     */
    private Boolean stackable;
    /**
     * Which shape this is.
     */
    private TransactionCampaignConfigDataType type;
    /**
     * Instantiates a new {@link TransactionCampaignConfigData} and sets the default values.
     */
    public TransactionCampaignConfigData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link TransactionCampaignConfigData}
     */
    @jakarta.annotation.Nonnull
    public static TransactionCampaignConfigData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new TransactionCampaignConfigData();
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
     * Gets the branch_ids property value. The branches this campaign runs in. Absent or empty means all of them.
     * @return a {@link java.util.List<Integer>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<Integer> getBranchIds() {
        return this.branchIds;
    }
    /**
     * Gets the customer_group_ids property value. The groups this campaign is for. Absent or empty means everyone.
     * @return a {@link java.util.List<Integer>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<Integer> getCustomerGroupIds() {
        return this.customerGroupIds;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(9);
        deserializerMap.put("branch_ids", (n) -> { this.setBranchIds(n.getCollectionOfPrimitiveValues(Integer.class)); });
        deserializerMap.put("customer_group_ids", (n) -> { this.setCustomerGroupIds(n.getCollectionOfPrimitiveValues(Integer.class)); });
        deserializerMap.put("max_points_per_purchase", (n) -> { this.setMaxPointsPerPurchase(n.getIntegerValue()); });
        deserializerMap.put("points", (n) -> { this.setPoints(n.getIntegerValue()); });
        deserializerMap.put("products", (n) -> { this.setProducts(n.getCollectionOfObjectValues(CampaignProductRuleData::createFromDiscriminatorValue)); });
        deserializerMap.put("reward_type", (n) -> { this.setRewardType(n.getEnumValue(TransactionCampaignConfigDataRewardType::forValue)); });
        deserializerMap.put("scope", (n) -> { this.setScope(n.getEnumValue(TransactionCampaignConfigDataScope::forValue)); });
        deserializerMap.put("stackable", (n) -> { this.setStackable(n.getBooleanValue()); });
        deserializerMap.put("type", (n) -> { this.setType(n.getEnumValue(TransactionCampaignConfigDataType::forValue)); });
        return deserializerMap;
    }
    /**
     * Gets the max_points_per_purchase property value. The most this campaign pays out on one purchase.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getMaxPointsPerPurchase() {
        return this.maxPointsPerPurchase;
    }
    /**
     * Gets the points property value. The points added, when `reward_type` is `fixed_points`.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getPoints() {
        return this.points;
    }
    /**
     * Gets the products property value. The products the campaign is limited to, when `scope` is `products`.
     * @return a {@link java.util.List<CampaignProductRuleData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<CampaignProductRuleData> getProducts() {
        return this.products;
    }
    /**
     * Gets the reward_type property value. Multiply the points earned, or add a fixed number. Absent reads as `multiplier`.
     * @return a {@link TransactionCampaignConfigDataRewardType}
     */
    @jakarta.annotation.Nullable
    public TransactionCampaignConfigDataRewardType getRewardType() {
        return this.rewardType;
    }
    /**
     * Gets the scope property value. `whole` and `whole_purchase` both mean the whole purchase. Absent reads as `whole`.
     * @return a {@link TransactionCampaignConfigDataScope}
     */
    @jakarta.annotation.Nullable
    public TransactionCampaignConfigDataScope getScope() {
        return this.scope;
    }
    /**
     * Gets the stackable property value. Whether it pays out beside another campaign. Older rows carry `combineerbaar`.
     * @return a {@link Boolean}
     */
    @jakarta.annotation.Nullable
    public Boolean getStackable() {
        return this.stackable;
    }
    /**
     * Gets the type property value. Which shape this is.
     * @return a {@link TransactionCampaignConfigDataType}
     */
    @jakarta.annotation.Nullable
    public TransactionCampaignConfigDataType getType() {
        return this.type;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeCollectionOfPrimitiveValues("branch_ids", this.getBranchIds());
        writer.writeCollectionOfPrimitiveValues("customer_group_ids", this.getCustomerGroupIds());
        writer.writeIntegerValue("max_points_per_purchase", this.getMaxPointsPerPurchase());
        writer.writeIntegerValue("points", this.getPoints());
        writer.writeCollectionOfObjectValues("products", this.getProducts());
        writer.writeEnumValue("reward_type", this.getRewardType());
        writer.writeEnumValue("scope", this.getScope());
        writer.writeBooleanValue("stackable", this.getStackable());
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
     * Sets the branch_ids property value. The branches this campaign runs in. Absent or empty means all of them.
     * @param value Value to set for the branch_ids property.
     */
    public void setBranchIds(@jakarta.annotation.Nullable final java.util.List<Integer> value) {
        this.branchIds = value;
    }
    /**
     * Sets the customer_group_ids property value. The groups this campaign is for. Absent or empty means everyone.
     * @param value Value to set for the customer_group_ids property.
     */
    public void setCustomerGroupIds(@jakarta.annotation.Nullable final java.util.List<Integer> value) {
        this.customerGroupIds = value;
    }
    /**
     * Sets the max_points_per_purchase property value. The most this campaign pays out on one purchase.
     * @param value Value to set for the max_points_per_purchase property.
     */
    public void setMaxPointsPerPurchase(@jakarta.annotation.Nullable final Integer value) {
        this.maxPointsPerPurchase = value;
    }
    /**
     * Sets the points property value. The points added, when `reward_type` is `fixed_points`.
     * @param value Value to set for the points property.
     */
    public void setPoints(@jakarta.annotation.Nullable final Integer value) {
        this.points = value;
    }
    /**
     * Sets the products property value. The products the campaign is limited to, when `scope` is `products`.
     * @param value Value to set for the products property.
     */
    public void setProducts(@jakarta.annotation.Nullable final java.util.List<CampaignProductRuleData> value) {
        this.products = value;
    }
    /**
     * Sets the reward_type property value. Multiply the points earned, or add a fixed number. Absent reads as `multiplier`.
     * @param value Value to set for the reward_type property.
     */
    public void setRewardType(@jakarta.annotation.Nullable final TransactionCampaignConfigDataRewardType value) {
        this.rewardType = value;
    }
    /**
     * Sets the scope property value. `whole` and `whole_purchase` both mean the whole purchase. Absent reads as `whole`.
     * @param value Value to set for the scope property.
     */
    public void setScope(@jakarta.annotation.Nullable final TransactionCampaignConfigDataScope value) {
        this.scope = value;
    }
    /**
     * Sets the stackable property value. Whether it pays out beside another campaign. Older rows carry `combineerbaar`.
     * @param value Value to set for the stackable property.
     */
    public void setStackable(@jakarta.annotation.Nullable final Boolean value) {
        this.stackable = value;
    }
    /**
     * Sets the type property value. Which shape this is.
     * @param value Value to set for the type property.
     */
    public void setType(@jakarta.annotation.Nullable final TransactionCampaignConfigDataType value) {
        this.type = value;
    }
}
