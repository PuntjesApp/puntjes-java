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
public class AnniversaryCampaignConfigData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * Whether customers who passed the mark before the campaign started also get it.
     */
    private Boolean backfill;
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
    private AnniversaryCampaignConfigDataGift gift;
    /**
     * Which shape this is.
     */
    private AnniversaryCampaignConfigDataType type;
    /**
     * How many years after joining the gift is sent.
     */
    private Integer years;
    /**
     * Instantiates a new {@link AnniversaryCampaignConfigData} and sets the default values.
     */
    public AnniversaryCampaignConfigData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link AnniversaryCampaignConfigData}
     */
    @jakarta.annotation.Nonnull
    public static AnniversaryCampaignConfigData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new AnniversaryCampaignConfigData();
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
     * Gets the backfill property value. Whether customers who passed the mark before the campaign started also get it.
     * @return a {@link Boolean}
     */
    @jakarta.annotation.Nullable
    public Boolean getBackfill() {
        return this.backfill;
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
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(6);
        deserializerMap.put("backfill", (n) -> { this.setBackfill(n.getBooleanValue()); });
        deserializerMap.put("branch_ids", (n) -> { this.setBranchIds(n.getCollectionOfPrimitiveValues(Integer.class)); });
        deserializerMap.put("customer_group_ids", (n) -> { this.setCustomerGroupIds(n.getCollectionOfPrimitiveValues(Integer.class)); });
        deserializerMap.put("gift", (n) -> { this.setGift(n.getObjectValue(AnniversaryCampaignConfigDataGift::createFromDiscriminatorValue)); });
        deserializerMap.put("type", (n) -> { this.setType(n.getEnumValue(AnniversaryCampaignConfigDataType::forValue)); });
        deserializerMap.put("years", (n) -> { this.setYears(n.getIntegerValue()); });
        return deserializerMap;
    }
    /**
     * Gets the gift property value. What the customer gets. Its `type` says which shape this is.
     * @return a {@link AnniversaryCampaignConfigDataGift}
     */
    @jakarta.annotation.Nullable
    public AnniversaryCampaignConfigDataGift getGift() {
        return this.gift;
    }
    /**
     * Gets the type property value. Which shape this is.
     * @return a {@link AnniversaryCampaignConfigDataType}
     */
    @jakarta.annotation.Nullable
    public AnniversaryCampaignConfigDataType getType() {
        return this.type;
    }
    /**
     * Gets the years property value. How many years after joining the gift is sent.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getYears() {
        return this.years;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeBooleanValue("backfill", this.getBackfill());
        writer.writeCollectionOfPrimitiveValues("branch_ids", this.getBranchIds());
        writer.writeCollectionOfPrimitiveValues("customer_group_ids", this.getCustomerGroupIds());
        writer.writeObjectValue("gift", this.getGift());
        writer.writeEnumValue("type", this.getType());
        writer.writeIntegerValue("years", this.getYears());
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
     * Sets the backfill property value. Whether customers who passed the mark before the campaign started also get it.
     * @param value Value to set for the backfill property.
     */
    public void setBackfill(@jakarta.annotation.Nullable final Boolean value) {
        this.backfill = value;
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
    public void setGift(@jakarta.annotation.Nullable final AnniversaryCampaignConfigDataGift value) {
        this.gift = value;
    }
    /**
     * Sets the type property value. Which shape this is.
     * @param value Value to set for the type property.
     */
    public void setType(@jakarta.annotation.Nullable final AnniversaryCampaignConfigDataType value) {
        this.type = value;
    }
    /**
     * Sets the years property value. How many years after joining the gift is sent.
     * @param value Value to set for the years property.
     */
    public void setYears(@jakarta.annotation.Nullable final Integer value) {
        this.years = value;
    }
    /**
     * Composed type wrapper for classes {@link DiscountGiftData}, {@link FreeProductGiftData}, {@link PointsGiftData}
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public static class AnniversaryCampaignConfigDataGift implements ComposedTypeWrapper, Parsable {
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
         * @return a {@link AnniversaryCampaignConfigDataGift}
         */
        @jakarta.annotation.Nonnull
        public static AnniversaryCampaignConfigDataGift createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
            Objects.requireNonNull(parseNode);
            final AnniversaryCampaignConfigDataGift result = new AnniversaryCampaignConfigDataGift();
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
