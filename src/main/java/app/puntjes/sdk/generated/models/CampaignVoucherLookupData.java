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
public class CampaignVoucherLookupData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * Only true when `status` is `valid` and the customer is a member of none of its customer groups.
     */
    private Boolean blockedByGroup;
    /**
     * The campaign_id property
     */
    private Integer campaignId;
    /**
     * When the voucher was spent, or null while it is not.
     */
    private String consumedAt;
    /**
     * Groups that may spend it; empty means every customer.
     */
    private java.util.List<CustomerGroupReferenceData> customerGroups;
    /**
     * How much comes off, for a discount voucher. Its `type` says which shape this is.
     */
    private CampaignVoucherLookupDataDiscount discount;
    /**
     * The kind property
     */
    private String kind;
    /**
     * What to hand over, for a free-product voucher.
     */
    private java.util.List<VoucherGiftProductData> products;
    /**
     * `valid`, `used` or `expired`.
     */
    private String status;
    /**
     * The valid_until property
     */
    private String validUntil;
    /**
     * The voucher_code property
     */
    private String voucherCode;
    /**
     * Instantiates a new {@link CampaignVoucherLookupData} and sets the default values.
     */
    public CampaignVoucherLookupData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link CampaignVoucherLookupData}
     */
    @jakarta.annotation.Nonnull
    public static CampaignVoucherLookupData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new CampaignVoucherLookupData();
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
     * Gets the blocked_by_group property value. Only true when `status` is `valid` and the customer is a member of none of its customer groups.
     * @return a {@link Boolean}
     */
    @jakarta.annotation.Nullable
    public Boolean getBlockedByGroup() {
        return this.blockedByGroup;
    }
    /**
     * Gets the campaign_id property value. The campaign_id property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getCampaignId() {
        return this.campaignId;
    }
    /**
     * Gets the consumed_at property value. When the voucher was spent, or null while it is not.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getConsumedAt() {
        return this.consumedAt;
    }
    /**
     * Gets the customer_groups property value. Groups that may spend it; empty means every customer.
     * @return a {@link java.util.List<CustomerGroupReferenceData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<CustomerGroupReferenceData> getCustomerGroups() {
        return this.customerGroups;
    }
    /**
     * Gets the discount property value. How much comes off, for a discount voucher. Its `type` says which shape this is.
     * @return a {@link CampaignVoucherLookupDataDiscount}
     */
    @jakarta.annotation.Nullable
    public CampaignVoucherLookupDataDiscount getDiscount() {
        return this.discount;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(10);
        deserializerMap.put("blocked_by_group", (n) -> { this.setBlockedByGroup(n.getBooleanValue()); });
        deserializerMap.put("campaign_id", (n) -> { this.setCampaignId(n.getIntegerValue()); });
        deserializerMap.put("consumed_at", (n) -> { this.setConsumedAt(n.getStringValue()); });
        deserializerMap.put("customer_groups", (n) -> { this.setCustomerGroups(n.getCollectionOfObjectValues(CustomerGroupReferenceData::createFromDiscriminatorValue)); });
        deserializerMap.put("discount", (n) -> { this.setDiscount(n.getObjectValue(CampaignVoucherLookupDataDiscount::createFromDiscriminatorValue)); });
        deserializerMap.put("kind", (n) -> { this.setKind(n.getStringValue()); });
        deserializerMap.put("products", (n) -> { this.setProducts(n.getCollectionOfObjectValues(VoucherGiftProductData::createFromDiscriminatorValue)); });
        deserializerMap.put("status", (n) -> { this.setStatus(n.getStringValue()); });
        deserializerMap.put("valid_until", (n) -> { this.setValidUntil(n.getStringValue()); });
        deserializerMap.put("voucher_code", (n) -> { this.setVoucherCode(n.getStringValue()); });
        return deserializerMap;
    }
    /**
     * Gets the kind property value. The kind property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getKind() {
        return this.kind;
    }
    /**
     * Gets the products property value. What to hand over, for a free-product voucher.
     * @return a {@link java.util.List<VoucherGiftProductData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<VoucherGiftProductData> getProducts() {
        return this.products;
    }
    /**
     * Gets the status property value. `valid`, `used` or `expired`.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getStatus() {
        return this.status;
    }
    /**
     * Gets the valid_until property value. The valid_until property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getValidUntil() {
        return this.validUntil;
    }
    /**
     * Gets the voucher_code property value. The voucher_code property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getVoucherCode() {
        return this.voucherCode;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeBooleanValue("blocked_by_group", this.getBlockedByGroup());
        writer.writeIntegerValue("campaign_id", this.getCampaignId());
        writer.writeStringValue("consumed_at", this.getConsumedAt());
        writer.writeCollectionOfObjectValues("customer_groups", this.getCustomerGroups());
        writer.writeObjectValue("discount", this.getDiscount());
        writer.writeStringValue("kind", this.getKind());
        writer.writeCollectionOfObjectValues("products", this.getProducts());
        writer.writeStringValue("status", this.getStatus());
        writer.writeStringValue("valid_until", this.getValidUntil());
        writer.writeStringValue("voucher_code", this.getVoucherCode());
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
     * Sets the blocked_by_group property value. Only true when `status` is `valid` and the customer is a member of none of its customer groups.
     * @param value Value to set for the blocked_by_group property.
     */
    public void setBlockedByGroup(@jakarta.annotation.Nullable final Boolean value) {
        this.blockedByGroup = value;
    }
    /**
     * Sets the campaign_id property value. The campaign_id property
     * @param value Value to set for the campaign_id property.
     */
    public void setCampaignId(@jakarta.annotation.Nullable final Integer value) {
        this.campaignId = value;
    }
    /**
     * Sets the consumed_at property value. When the voucher was spent, or null while it is not.
     * @param value Value to set for the consumed_at property.
     */
    public void setConsumedAt(@jakarta.annotation.Nullable final String value) {
        this.consumedAt = value;
    }
    /**
     * Sets the customer_groups property value. Groups that may spend it; empty means every customer.
     * @param value Value to set for the customer_groups property.
     */
    public void setCustomerGroups(@jakarta.annotation.Nullable final java.util.List<CustomerGroupReferenceData> value) {
        this.customerGroups = value;
    }
    /**
     * Sets the discount property value. How much comes off, for a discount voucher. Its `type` says which shape this is.
     * @param value Value to set for the discount property.
     */
    public void setDiscount(@jakarta.annotation.Nullable final CampaignVoucherLookupDataDiscount value) {
        this.discount = value;
    }
    /**
     * Sets the kind property value. The kind property
     * @param value Value to set for the kind property.
     */
    public void setKind(@jakarta.annotation.Nullable final String value) {
        this.kind = value;
    }
    /**
     * Sets the products property value. What to hand over, for a free-product voucher.
     * @param value Value to set for the products property.
     */
    public void setProducts(@jakarta.annotation.Nullable final java.util.List<VoucherGiftProductData> value) {
        this.products = value;
    }
    /**
     * Sets the status property value. `valid`, `used` or `expired`.
     * @param value Value to set for the status property.
     */
    public void setStatus(@jakarta.annotation.Nullable final String value) {
        this.status = value;
    }
    /**
     * Sets the valid_until property value. The valid_until property
     * @param value Value to set for the valid_until property.
     */
    public void setValidUntil(@jakarta.annotation.Nullable final String value) {
        this.validUntil = value;
    }
    /**
     * Sets the voucher_code property value. The voucher_code property
     * @param value Value to set for the voucher_code property.
     */
    public void setVoucherCode(@jakarta.annotation.Nullable final String value) {
        this.voucherCode = value;
    }
    /**
     * Composed type wrapper for classes {@link CampaignVoucherLookupDataDiscountMember1}, {@link VoucherFixedDiscountData}, {@link VoucherPercentageDiscountData}
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public static class CampaignVoucherLookupDataDiscount implements ComposedTypeWrapper, Parsable {
        /**
         * Composed type representation for type {@link CampaignVoucherLookupDataDiscountMember1}
         */
        private CampaignVoucherLookupDataDiscountMember1 campaignVoucherLookupDataDiscountMember1;
        /**
         * Composed type representation for type {@link VoucherFixedDiscountData}
         */
        private VoucherFixedDiscountData voucherFixedDiscountData;
        /**
         * Composed type representation for type {@link VoucherPercentageDiscountData}
         */
        private VoucherPercentageDiscountData voucherPercentageDiscountData;
        /**
         * Creates a new instance of the appropriate class based on discriminator value
         * @param parseNode The parse node to use to read the discriminator value and create the object
         * @return a {@link CampaignVoucherLookupDataDiscount}
         */
        @jakarta.annotation.Nonnull
        public static CampaignVoucherLookupDataDiscount createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
            Objects.requireNonNull(parseNode);
            final CampaignVoucherLookupDataDiscount result = new CampaignVoucherLookupDataDiscount();
            final ParseNode mappingValueNode = parseNode.getChildNode("type");
            if (mappingValueNode != null) {
                final String mappingValue = mappingValueNode.getStringValue();
                if ("fixed".equalsIgnoreCase(mappingValue)) {
                    result.setVoucherFixedDiscountData(new VoucherFixedDiscountData());
                } else if ("percentage".equalsIgnoreCase(mappingValue)) {
                    result.setVoucherPercentageDiscountData(new VoucherPercentageDiscountData());
                }
            }
            return result;
        }
        /**
         * Gets the CampaignVoucherLookupData_discountMember1 property value. Composed type representation for type {@link CampaignVoucherLookupDataDiscountMember1}
         * @return a {@link CampaignVoucherLookupDataDiscountMember1}
         */
        @jakarta.annotation.Nullable
        public CampaignVoucherLookupDataDiscountMember1 getCampaignVoucherLookupDataDiscountMember1() {
            return this.campaignVoucherLookupDataDiscountMember1;
        }
        /**
         * The deserialization information for the current model
         * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
         */
        @jakarta.annotation.Nonnull
        public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
            if (this.getCampaignVoucherLookupDataDiscountMember1() != null) {
                return this.getCampaignVoucherLookupDataDiscountMember1().getFieldDeserializers();
            } else if (this.getVoucherFixedDiscountData() != null) {
                return this.getVoucherFixedDiscountData().getFieldDeserializers();
            } else if (this.getVoucherPercentageDiscountData() != null) {
                return this.getVoucherPercentageDiscountData().getFieldDeserializers();
            }
            return new HashMap<String, java.util.function.Consumer<ParseNode>>();
        }
        /**
         * Gets the VoucherFixedDiscountData property value. Composed type representation for type {@link VoucherFixedDiscountData}
         * @return a {@link VoucherFixedDiscountData}
         */
        @jakarta.annotation.Nullable
        public VoucherFixedDiscountData getVoucherFixedDiscountData() {
            return this.voucherFixedDiscountData;
        }
        /**
         * Gets the VoucherPercentageDiscountData property value. Composed type representation for type {@link VoucherPercentageDiscountData}
         * @return a {@link VoucherPercentageDiscountData}
         */
        @jakarta.annotation.Nullable
        public VoucherPercentageDiscountData getVoucherPercentageDiscountData() {
            return this.voucherPercentageDiscountData;
        }
        /**
         * Serializes information the current object
         * @param writer Serialization writer to use to serialize this model
         */
        public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
            Objects.requireNonNull(writer);
            if (this.getCampaignVoucherLookupDataDiscountMember1() != null) {
                writer.writeObjectValue(null, this.getCampaignVoucherLookupDataDiscountMember1());
            } else if (this.getVoucherFixedDiscountData() != null) {
                writer.writeObjectValue(null, this.getVoucherFixedDiscountData());
            } else if (this.getVoucherPercentageDiscountData() != null) {
                writer.writeObjectValue(null, this.getVoucherPercentageDiscountData());
            }
        }
        /**
         * Sets the CampaignVoucherLookupData_discountMember1 property value. Composed type representation for type {@link CampaignVoucherLookupDataDiscountMember1}
         * @param value Value to set for the CampaignVoucherLookupData_discountMember1 property.
         */
        public void setCampaignVoucherLookupDataDiscountMember1(@jakarta.annotation.Nullable final CampaignVoucherLookupDataDiscountMember1 value) {
            this.campaignVoucherLookupDataDiscountMember1 = value;
        }
        /**
         * Sets the VoucherFixedDiscountData property value. Composed type representation for type {@link VoucherFixedDiscountData}
         * @param value Value to set for the VoucherFixedDiscountData property.
         */
        public void setVoucherFixedDiscountData(@jakarta.annotation.Nullable final VoucherFixedDiscountData value) {
            this.voucherFixedDiscountData = value;
        }
        /**
         * Sets the VoucherPercentageDiscountData property value. Composed type representation for type {@link VoucherPercentageDiscountData}
         * @param value Value to set for the VoucherPercentageDiscountData property.
         */
        public void setVoucherPercentageDiscountData(@jakarta.annotation.Nullable final VoucherPercentageDiscountData value) {
            this.voucherPercentageDiscountData = value;
        }
    }
}
