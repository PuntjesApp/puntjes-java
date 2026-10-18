package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.ComposedTypeWrapper;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class RedemptionCreatedData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The branches the reward has now; null means every branch.
     */
    private java.util.List<BranchReferenceData> branches;
    /**
     * The confirmation_code property
     */
    private String confirmationCode;
    /**
     * The expires_at property
     */
    private String expiresAt;
    /**
     * The points_deducted property
     */
    private Integer pointsDeducted;
    /**
     * The redeemed_at property
     */
    private String redeemedAt;
    /**
     * The redemption_id property
     */
    private Integer redemptionId;
    /**
     * The remaining_balance property
     */
    private Integer remainingBalance;
    /**
     * The reward property
     */
    private RedemptionRewardData reward;
    /**
     * What the counter needs, shaped by the reward&apos;s type. Its `type` says which shape this is.
     */
    private RedemptionCreatedDataTypeSpecificData typeSpecificData;
    /**
     * Instantiates a new {@link RedemptionCreatedData} and sets the default values.
     */
    public RedemptionCreatedData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link RedemptionCreatedData}
     */
    @jakarta.annotation.Nonnull
    public static RedemptionCreatedData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new RedemptionCreatedData();
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
     * Gets the branches property value. The branches the reward has now; null means every branch.
     * @return a {@link java.util.List<BranchReferenceData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<BranchReferenceData> getBranches() {
        return this.branches;
    }
    /**
     * Gets the confirmation_code property value. The confirmation_code property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getConfirmationCode() {
        return this.confirmationCode;
    }
    /**
     * Gets the expires_at property value. The expires_at property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getExpiresAt() {
        return this.expiresAt;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(9);
        deserializerMap.put("branches", (n) -> { this.setBranches(n.getCollectionOfObjectValues(BranchReferenceData::createFromDiscriminatorValue)); });
        deserializerMap.put("confirmation_code", (n) -> { this.setConfirmationCode(n.getStringValue()); });
        deserializerMap.put("expires_at", (n) -> { this.setExpiresAt(n.getStringValue()); });
        deserializerMap.put("points_deducted", (n) -> { this.setPointsDeducted(n.getIntegerValue()); });
        deserializerMap.put("redeemed_at", (n) -> { this.setRedeemedAt(n.getStringValue()); });
        deserializerMap.put("redemption_id", (n) -> { this.setRedemptionId(n.getIntegerValue()); });
        deserializerMap.put("remaining_balance", (n) -> { this.setRemainingBalance(n.getIntegerValue()); });
        deserializerMap.put("reward", (n) -> { this.setReward(n.getObjectValue(RedemptionRewardData::createFromDiscriminatorValue)); });
        deserializerMap.put("type_specific_data", (n) -> { this.setTypeSpecificData(n.getObjectValue(RedemptionCreatedDataTypeSpecificData::createFromDiscriminatorValue)); });
        return deserializerMap;
    }
    /**
     * Gets the points_deducted property value. The points_deducted property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getPointsDeducted() {
        return this.pointsDeducted;
    }
    /**
     * Gets the redeemed_at property value. The redeemed_at property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getRedeemedAt() {
        return this.redeemedAt;
    }
    /**
     * Gets the redemption_id property value. The redemption_id property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getRedemptionId() {
        return this.redemptionId;
    }
    /**
     * Gets the remaining_balance property value. The remaining_balance property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getRemainingBalance() {
        return this.remainingBalance;
    }
    /**
     * Gets the reward property value. The reward property
     * @return a {@link RedemptionRewardData}
     */
    @jakarta.annotation.Nullable
    public RedemptionRewardData getReward() {
        return this.reward;
    }
    /**
     * Gets the type_specific_data property value. What the counter needs, shaped by the reward&apos;s type. Its `type` says which shape this is.
     * @return a {@link RedemptionCreatedDataTypeSpecificData}
     */
    @jakarta.annotation.Nullable
    public RedemptionCreatedDataTypeSpecificData getTypeSpecificData() {
        return this.typeSpecificData;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeCollectionOfObjectValues("branches", this.getBranches());
        writer.writeStringValue("confirmation_code", this.getConfirmationCode());
        writer.writeStringValue("expires_at", this.getExpiresAt());
        writer.writeIntegerValue("points_deducted", this.getPointsDeducted());
        writer.writeStringValue("redeemed_at", this.getRedeemedAt());
        writer.writeIntegerValue("redemption_id", this.getRedemptionId());
        writer.writeIntegerValue("remaining_balance", this.getRemainingBalance());
        writer.writeObjectValue("reward", this.getReward());
        writer.writeObjectValue("type_specific_data", this.getTypeSpecificData());
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
     * Sets the branches property value. The branches the reward has now; null means every branch.
     * @param value Value to set for the branches property.
     */
    public void setBranches(@jakarta.annotation.Nullable final java.util.List<BranchReferenceData> value) {
        this.branches = value;
    }
    /**
     * Sets the confirmation_code property value. The confirmation_code property
     * @param value Value to set for the confirmation_code property.
     */
    public void setConfirmationCode(@jakarta.annotation.Nullable final String value) {
        this.confirmationCode = value;
    }
    /**
     * Sets the expires_at property value. The expires_at property
     * @param value Value to set for the expires_at property.
     */
    public void setExpiresAt(@jakarta.annotation.Nullable final String value) {
        this.expiresAt = value;
    }
    /**
     * Sets the points_deducted property value. The points_deducted property
     * @param value Value to set for the points_deducted property.
     */
    public void setPointsDeducted(@jakarta.annotation.Nullable final Integer value) {
        this.pointsDeducted = value;
    }
    /**
     * Sets the redeemed_at property value. The redeemed_at property
     * @param value Value to set for the redeemed_at property.
     */
    public void setRedeemedAt(@jakarta.annotation.Nullable final String value) {
        this.redeemedAt = value;
    }
    /**
     * Sets the redemption_id property value. The redemption_id property
     * @param value Value to set for the redemption_id property.
     */
    public void setRedemptionId(@jakarta.annotation.Nullable final Integer value) {
        this.redemptionId = value;
    }
    /**
     * Sets the remaining_balance property value. The remaining_balance property
     * @param value Value to set for the remaining_balance property.
     */
    public void setRemainingBalance(@jakarta.annotation.Nullable final Integer value) {
        this.remainingBalance = value;
    }
    /**
     * Sets the reward property value. The reward property
     * @param value Value to set for the reward property.
     */
    public void setReward(@jakarta.annotation.Nullable final RedemptionRewardData value) {
        this.reward = value;
    }
    /**
     * Sets the type_specific_data property value. What the counter needs, shaped by the reward&apos;s type. Its `type` says which shape this is.
     * @param value Value to set for the type_specific_data property.
     */
    public void setTypeSpecificData(@jakarta.annotation.Nullable final RedemptionCreatedDataTypeSpecificData value) {
        this.typeSpecificData = value;
    }
    /**
     * Composed type wrapper for classes {@link DiscountRedemptionData}, {@link FreeProductRedemptionData}
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public static class RedemptionCreatedDataTypeSpecificData implements ComposedTypeWrapper, Parsable {
        /**
         * Composed type representation for type {@link DiscountRedemptionData}
         */
        private DiscountRedemptionData discountRedemptionData;
        /**
         * Composed type representation for type {@link FreeProductRedemptionData}
         */
        private FreeProductRedemptionData freeProductRedemptionData;
        /**
         * Creates a new instance of the appropriate class based on discriminator value
         * @param parseNode The parse node to use to read the discriminator value and create the object
         * @return a {@link RedemptionCreatedDataTypeSpecificData}
         */
        @jakarta.annotation.Nonnull
        public static RedemptionCreatedDataTypeSpecificData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
            Objects.requireNonNull(parseNode);
            final RedemptionCreatedDataTypeSpecificData result = new RedemptionCreatedDataTypeSpecificData();
            final ParseNode mappingValueNode = parseNode.getChildNode("type");
            if (mappingValueNode != null) {
                final String mappingValue = mappingValueNode.getStringValue();
                if ("discount".equalsIgnoreCase(mappingValue)) {
                    result.setDiscountRedemptionData(new DiscountRedemptionData());
                } else if ("free_product".equalsIgnoreCase(mappingValue)) {
                    result.setFreeProductRedemptionData(new FreeProductRedemptionData());
                }
            }
            return result;
        }
        /**
         * Gets the DiscountRedemptionData property value. Composed type representation for type {@link DiscountRedemptionData}
         * @return a {@link DiscountRedemptionData}
         */
        @jakarta.annotation.Nullable
        public DiscountRedemptionData getDiscountRedemptionData() {
            return this.discountRedemptionData;
        }
        /**
         * The deserialization information for the current model
         * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
         */
        @jakarta.annotation.Nonnull
        public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
            if (this.getDiscountRedemptionData() != null) {
                return this.getDiscountRedemptionData().getFieldDeserializers();
            } else if (this.getFreeProductRedemptionData() != null) {
                return this.getFreeProductRedemptionData().getFieldDeserializers();
            }
            return new HashMap<String, java.util.function.Consumer<ParseNode>>();
        }
        /**
         * Gets the FreeProductRedemptionData property value. Composed type representation for type {@link FreeProductRedemptionData}
         * @return a {@link FreeProductRedemptionData}
         */
        @jakarta.annotation.Nullable
        public FreeProductRedemptionData getFreeProductRedemptionData() {
            return this.freeProductRedemptionData;
        }
        /**
         * Serializes information the current object
         * @param writer Serialization writer to use to serialize this model
         */
        public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
            Objects.requireNonNull(writer);
            if (this.getDiscountRedemptionData() != null) {
                writer.writeObjectValue(null, this.getDiscountRedemptionData());
            } else if (this.getFreeProductRedemptionData() != null) {
                writer.writeObjectValue(null, this.getFreeProductRedemptionData());
            }
        }
        /**
         * Sets the DiscountRedemptionData property value. Composed type representation for type {@link DiscountRedemptionData}
         * @param value Value to set for the DiscountRedemptionData property.
         */
        public void setDiscountRedemptionData(@jakarta.annotation.Nullable final DiscountRedemptionData value) {
            this.discountRedemptionData = value;
        }
        /**
         * Sets the FreeProductRedemptionData property value. Composed type representation for type {@link FreeProductRedemptionData}
         * @param value Value to set for the FreeProductRedemptionData property.
         */
        public void setFreeProductRedemptionData(@jakarta.annotation.Nullable final FreeProductRedemptionData value) {
            this.freeProductRedemptionData = value;
        }
    }
}
