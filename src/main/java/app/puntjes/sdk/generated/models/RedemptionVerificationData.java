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
public class RedemptionVerificationData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The confirmation_code property
     */
    private String confirmationCode;
    /**
     * The points_deducted property
     */
    private Integer pointsDeducted;
    /**
     * The redemption_id property
     */
    private Integer redemptionId;
    /**
     * The reward property
     */
    private RedemptionRewardData reward;
    /**
     * The status property
     */
    private String status;
    /**
     * What the counter needs, shaped by the reward&apos;s type. Its `type` says which shape this is.
     */
    private RedemptionVerificationDataTypeSpecificData typeSpecificData;
    /**
     * The verified_at property
     */
    private String verifiedAt;
    /**
     * Instantiates a new {@link RedemptionVerificationData} and sets the default values.
     */
    public RedemptionVerificationData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link RedemptionVerificationData}
     */
    @jakarta.annotation.Nonnull
    public static RedemptionVerificationData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new RedemptionVerificationData();
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
     * Gets the confirmation_code property value. The confirmation_code property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getConfirmationCode() {
        return this.confirmationCode;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(7);
        deserializerMap.put("confirmation_code", (n) -> { this.setConfirmationCode(n.getStringValue()); });
        deserializerMap.put("points_deducted", (n) -> { this.setPointsDeducted(n.getIntegerValue()); });
        deserializerMap.put("redemption_id", (n) -> { this.setRedemptionId(n.getIntegerValue()); });
        deserializerMap.put("reward", (n) -> { this.setReward(n.getObjectValue(RedemptionRewardData::createFromDiscriminatorValue)); });
        deserializerMap.put("status", (n) -> { this.setStatus(n.getStringValue()); });
        deserializerMap.put("type_specific_data", (n) -> { this.setTypeSpecificData(n.getObjectValue(RedemptionVerificationDataTypeSpecificData::createFromDiscriminatorValue)); });
        deserializerMap.put("verified_at", (n) -> { this.setVerifiedAt(n.getStringValue()); });
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
     * Gets the redemption_id property value. The redemption_id property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getRedemptionId() {
        return this.redemptionId;
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
     * Gets the status property value. The status property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getStatus() {
        return this.status;
    }
    /**
     * Gets the type_specific_data property value. What the counter needs, shaped by the reward&apos;s type. Its `type` says which shape this is.
     * @return a {@link RedemptionVerificationDataTypeSpecificData}
     */
    @jakarta.annotation.Nullable
    public RedemptionVerificationDataTypeSpecificData getTypeSpecificData() {
        return this.typeSpecificData;
    }
    /**
     * Gets the verified_at property value. The verified_at property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getVerifiedAt() {
        return this.verifiedAt;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("confirmation_code", this.getConfirmationCode());
        writer.writeIntegerValue("points_deducted", this.getPointsDeducted());
        writer.writeIntegerValue("redemption_id", this.getRedemptionId());
        writer.writeObjectValue("reward", this.getReward());
        writer.writeStringValue("status", this.getStatus());
        writer.writeObjectValue("type_specific_data", this.getTypeSpecificData());
        writer.writeStringValue("verified_at", this.getVerifiedAt());
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
     * Sets the confirmation_code property value. The confirmation_code property
     * @param value Value to set for the confirmation_code property.
     */
    public void setConfirmationCode(@jakarta.annotation.Nullable final String value) {
        this.confirmationCode = value;
    }
    /**
     * Sets the points_deducted property value. The points_deducted property
     * @param value Value to set for the points_deducted property.
     */
    public void setPointsDeducted(@jakarta.annotation.Nullable final Integer value) {
        this.pointsDeducted = value;
    }
    /**
     * Sets the redemption_id property value. The redemption_id property
     * @param value Value to set for the redemption_id property.
     */
    public void setRedemptionId(@jakarta.annotation.Nullable final Integer value) {
        this.redemptionId = value;
    }
    /**
     * Sets the reward property value. The reward property
     * @param value Value to set for the reward property.
     */
    public void setReward(@jakarta.annotation.Nullable final RedemptionRewardData value) {
        this.reward = value;
    }
    /**
     * Sets the status property value. The status property
     * @param value Value to set for the status property.
     */
    public void setStatus(@jakarta.annotation.Nullable final String value) {
        this.status = value;
    }
    /**
     * Sets the type_specific_data property value. What the counter needs, shaped by the reward&apos;s type. Its `type` says which shape this is.
     * @param value Value to set for the type_specific_data property.
     */
    public void setTypeSpecificData(@jakarta.annotation.Nullable final RedemptionVerificationDataTypeSpecificData value) {
        this.typeSpecificData = value;
    }
    /**
     * Sets the verified_at property value. The verified_at property
     * @param value Value to set for the verified_at property.
     */
    public void setVerifiedAt(@jakarta.annotation.Nullable final String value) {
        this.verifiedAt = value;
    }
    /**
     * Composed type wrapper for classes {@link DiscountRedemptionData}, {@link FreeProductRedemptionData}
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public static class RedemptionVerificationDataTypeSpecificData implements ComposedTypeWrapper, Parsable {
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
         * @return a {@link RedemptionVerificationDataTypeSpecificData}
         */
        @jakarta.annotation.Nonnull
        public static RedemptionVerificationDataTypeSpecificData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
            Objects.requireNonNull(parseNode);
            final RedemptionVerificationDataTypeSpecificData result = new RedemptionVerificationDataTypeSpecificData();
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
