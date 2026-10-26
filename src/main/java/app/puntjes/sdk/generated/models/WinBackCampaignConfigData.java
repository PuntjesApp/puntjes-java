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
public class WinBackCampaignConfigData implements AdditionalDataHolder, Parsable {
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
     * What the customer gets. Its `type` says which shape this is.
     */
    private WinBackCampaignConfigDataGift gift;
    /**
     * How many months without a purchase before the gift is sent.
     */
    private Integer months;
    /**
     * Which shape this is.
     */
    private WinBackCampaignConfigDataType type;
    /**
     * Instantiates a new {@link WinBackCampaignConfigData} and sets the default values.
     */
    public WinBackCampaignConfigData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link WinBackCampaignConfigData}
     */
    @jakarta.annotation.Nonnull
    public static WinBackCampaignConfigData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new WinBackCampaignConfigData();
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
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(5);
        deserializerMap.put("branch_ids", (n) -> { this.setBranchIds(n.getCollectionOfPrimitiveValues(Integer.class)); });
        deserializerMap.put("customer_group_ids", (n) -> { this.setCustomerGroupIds(n.getCollectionOfPrimitiveValues(Integer.class)); });
        deserializerMap.put("gift", (n) -> { this.setGift(n.getObjectValue(WinBackCampaignConfigDataGift::createFromDiscriminatorValue)); });
        deserializerMap.put("months", (n) -> { this.setMonths(n.getIntegerValue()); });
        deserializerMap.put("type", (n) -> { this.setType(n.getEnumValue(WinBackCampaignConfigDataType::forValue)); });
        return deserializerMap;
    }
    /**
     * Gets the gift property value. What the customer gets. Its `type` says which shape this is.
     * @return a {@link WinBackCampaignConfigDataGift}
     */
    @jakarta.annotation.Nullable
    public WinBackCampaignConfigDataGift getGift() {
        return this.gift;
    }
    /**
     * Gets the months property value. How many months without a purchase before the gift is sent.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getMonths() {
        return this.months;
    }
    /**
     * Gets the type property value. Which shape this is.
     * @return a {@link WinBackCampaignConfigDataType}
     */
    @jakarta.annotation.Nullable
    public WinBackCampaignConfigDataType getType() {
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
        writer.writeObjectValue("gift", this.getGift());
        writer.writeIntegerValue("months", this.getMonths());
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
     * Sets the gift property value. What the customer gets. Its `type` says which shape this is.
     * @param value Value to set for the gift property.
     */
    public void setGift(@jakarta.annotation.Nullable final WinBackCampaignConfigDataGift value) {
        this.gift = value;
    }
    /**
     * Sets the months property value. How many months without a purchase before the gift is sent.
     * @param value Value to set for the months property.
     */
    public void setMonths(@jakarta.annotation.Nullable final Integer value) {
        this.months = value;
    }
    /**
     * Sets the type property value. Which shape this is.
     * @param value Value to set for the type property.
     */
    public void setType(@jakarta.annotation.Nullable final WinBackCampaignConfigDataType value) {
        this.type = value;
    }
    /**
     * Composed type wrapper for classes {@link DiscountGiftData}, {@link FreeProductGiftData}, {@link PointsGiftData}
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public static class WinBackCampaignConfigDataGift implements ComposedTypeWrapper, Parsable {
        /**
         * Composed type representation for type {@link DiscountGiftData}
         */
        private DiscountGiftData discountGiftData;
        /**
         * Composed type representation for type {@link FreeProductGiftData}
         */
        private FreeProductGiftData freeProductGiftData;
        /**
         * Composed type representation for type {@link PointsGiftData}
         */
        private PointsGiftData pointsGiftData;
        /**
         * Creates a new instance of the appropriate class based on discriminator value
         * @param parseNode The parse node to use to read the discriminator value and create the object
         * @return a {@link WinBackCampaignConfigDataGift}
         */
        @jakarta.annotation.Nonnull
        public static WinBackCampaignConfigDataGift createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
            Objects.requireNonNull(parseNode);
            final WinBackCampaignConfigDataGift result = new WinBackCampaignConfigDataGift();
            final ParseNode mappingValueNode = parseNode.getChildNode("type");
            if (mappingValueNode != null) {
                final String mappingValue = mappingValueNode.getStringValue();
                if ("discount".equalsIgnoreCase(mappingValue)) {
                    result.setDiscountGiftData(new DiscountGiftData());
                } else if ("free_product".equalsIgnoreCase(mappingValue)) {
                    result.setFreeProductGiftData(new FreeProductGiftData());
                } else if ("points".equalsIgnoreCase(mappingValue)) {
                    result.setPointsGiftData(new PointsGiftData());
                }
            }
            return result;
        }
        /**
         * Gets the DiscountGiftData property value. Composed type representation for type {@link DiscountGiftData}
         * @return a {@link DiscountGiftData}
         */
        @jakarta.annotation.Nullable
        public DiscountGiftData getDiscountGiftData() {
            return this.discountGiftData;
        }
        /**
         * The deserialization information for the current model
         * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
         */
        @jakarta.annotation.Nonnull
        public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
            if (this.getDiscountGiftData() != null) {
                return this.getDiscountGiftData().getFieldDeserializers();
            } else if (this.getFreeProductGiftData() != null) {
                return this.getFreeProductGiftData().getFieldDeserializers();
            } else if (this.getPointsGiftData() != null) {
                return this.getPointsGiftData().getFieldDeserializers();
            }
            return new HashMap<String, java.util.function.Consumer<ParseNode>>();
        }
        /**
         * Gets the FreeProductGiftData property value. Composed type representation for type {@link FreeProductGiftData}
         * @return a {@link FreeProductGiftData}
         */
        @jakarta.annotation.Nullable
        public FreeProductGiftData getFreeProductGiftData() {
            return this.freeProductGiftData;
        }
        /**
         * Gets the PointsGiftData property value. Composed type representation for type {@link PointsGiftData}
         * @return a {@link PointsGiftData}
         */
        @jakarta.annotation.Nullable
        public PointsGiftData getPointsGiftData() {
            return this.pointsGiftData;
        }
        /**
         * Serializes information the current object
         * @param writer Serialization writer to use to serialize this model
         */
        public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
            Objects.requireNonNull(writer);
            if (this.getDiscountGiftData() != null) {
                writer.writeObjectValue(null, this.getDiscountGiftData());
            } else if (this.getFreeProductGiftData() != null) {
                writer.writeObjectValue(null, this.getFreeProductGiftData());
            } else if (this.getPointsGiftData() != null) {
                writer.writeObjectValue(null, this.getPointsGiftData());
            }
        }
        /**
         * Sets the DiscountGiftData property value. Composed type representation for type {@link DiscountGiftData}
         * @param value Value to set for the DiscountGiftData property.
         */
        public void setDiscountGiftData(@jakarta.annotation.Nullable final DiscountGiftData value) {
            this.discountGiftData = value;
        }
        /**
         * Sets the FreeProductGiftData property value. Composed type representation for type {@link FreeProductGiftData}
         * @param value Value to set for the FreeProductGiftData property.
         */
        public void setFreeProductGiftData(@jakarta.annotation.Nullable final FreeProductGiftData value) {
            this.freeProductGiftData = value;
        }
        /**
         * Sets the PointsGiftData property value. Composed type representation for type {@link PointsGiftData}
         * @param value Value to set for the PointsGiftData property.
         */
        public void setPointsGiftData(@jakarta.annotation.Nullable final PointsGiftData value) {
            this.pointsGiftData = value;
        }
    }
}
