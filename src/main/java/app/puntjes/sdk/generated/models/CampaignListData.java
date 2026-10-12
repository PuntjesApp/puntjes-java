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
public class CampaignListData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * null means every branch
     */
    private java.util.List<BranchReferenceData> branches;
    /**
     * Its `type` says which shape this is.
     */
    private CampaignListDataConfig config;
    /**
     * The created_at property
     */
    private String createdAt;
    /**
     * The ends_at property
     */
    private String endsAt;
    /**
     * The family property
     */
    private String family;
    /**
     * The id property
     */
    private Integer id;
    /**
     * The min_transaction_amount property
     */
    private Double minTransactionAmount;
    /**
     * The moment property
     */
    private String moment;
    /**
     * The multiplier property
     */
    private Integer multiplier;
    /**
     * The name property
     */
    private String name;
    /**
     * Its `type` says which shape this is.
     */
    private CampaignListDataRecurrenceConfig recurrenceConfig;
    /**
     * The recurrence_type property
     */
    private String recurrenceType;
    /**
     * The schedule_summary property
     */
    private String scheduleSummary;
    /**
     * The starts_at property
     */
    private String startsAt;
    /**
     * The status property
     */
    private CampaignStatusData status;
    /**
     * The updated_at property
     */
    private String updatedAt;
    /**
     * The version property
     */
    private Integer version;
    /**
     * Instantiates a new {@link CampaignListData} and sets the default values.
     */
    public CampaignListData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link CampaignListData}
     */
    @jakarta.annotation.Nonnull
    public static CampaignListData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new CampaignListData();
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
     * Gets the branches property value. null means every branch
     * @return a {@link java.util.List<BranchReferenceData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<BranchReferenceData> getBranches() {
        return this.branches;
    }
    /**
     * Gets the config property value. Its `type` says which shape this is.
     * @return a {@link CampaignListDataConfig}
     */
    @jakarta.annotation.Nullable
    public CampaignListDataConfig getConfig() {
        return this.config;
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
     * Gets the ends_at property value. The ends_at property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getEndsAt() {
        return this.endsAt;
    }
    /**
     * Gets the family property value. The family property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getFamily() {
        return this.family;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(17);
        deserializerMap.put("branches", (n) -> { this.setBranches(n.getCollectionOfObjectValues(BranchReferenceData::createFromDiscriminatorValue)); });
        deserializerMap.put("config", (n) -> { this.setConfig(n.getObjectValue(CampaignListDataConfig::createFromDiscriminatorValue)); });
        deserializerMap.put("created_at", (n) -> { this.setCreatedAt(n.getStringValue()); });
        deserializerMap.put("ends_at", (n) -> { this.setEndsAt(n.getStringValue()); });
        deserializerMap.put("family", (n) -> { this.setFamily(n.getStringValue()); });
        deserializerMap.put("id", (n) -> { this.setId(n.getIntegerValue()); });
        deserializerMap.put("min_transaction_amount", (n) -> { this.setMinTransactionAmount(n.getDoubleValue()); });
        deserializerMap.put("moment", (n) -> { this.setMoment(n.getStringValue()); });
        deserializerMap.put("multiplier", (n) -> { this.setMultiplier(n.getIntegerValue()); });
        deserializerMap.put("name", (n) -> { this.setName(n.getStringValue()); });
        deserializerMap.put("recurrence_config", (n) -> { this.setRecurrenceConfig(n.getObjectValue(CampaignListDataRecurrenceConfig::createFromDiscriminatorValue)); });
        deserializerMap.put("recurrence_type", (n) -> { this.setRecurrenceType(n.getStringValue()); });
        deserializerMap.put("schedule_summary", (n) -> { this.setScheduleSummary(n.getStringValue()); });
        deserializerMap.put("starts_at", (n) -> { this.setStartsAt(n.getStringValue()); });
        deserializerMap.put("status", (n) -> { this.setStatus(n.getObjectValue(CampaignStatusData::createFromDiscriminatorValue)); });
        deserializerMap.put("updated_at", (n) -> { this.setUpdatedAt(n.getStringValue()); });
        deserializerMap.put("version", (n) -> { this.setVersion(n.getIntegerValue()); });
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
     * Gets the min_transaction_amount property value. The min_transaction_amount property
     * @return a {@link Double}
     */
    @jakarta.annotation.Nullable
    public Double getMinTransactionAmount() {
        return this.minTransactionAmount;
    }
    /**
     * Gets the moment property value. The moment property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getMoment() {
        return this.moment;
    }
    /**
     * Gets the multiplier property value. The multiplier property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getMultiplier() {
        return this.multiplier;
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
     * Gets the recurrence_config property value. Its `type` says which shape this is.
     * @return a {@link CampaignListDataRecurrenceConfig}
     */
    @jakarta.annotation.Nullable
    public CampaignListDataRecurrenceConfig getRecurrenceConfig() {
        return this.recurrenceConfig;
    }
    /**
     * Gets the recurrence_type property value. The recurrence_type property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getRecurrenceType() {
        return this.recurrenceType;
    }
    /**
     * Gets the schedule_summary property value. The schedule_summary property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getScheduleSummary() {
        return this.scheduleSummary;
    }
    /**
     * Gets the starts_at property value. The starts_at property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getStartsAt() {
        return this.startsAt;
    }
    /**
     * Gets the status property value. The status property
     * @return a {@link CampaignStatusData}
     */
    @jakarta.annotation.Nullable
    public CampaignStatusData getStatus() {
        return this.status;
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
     * Gets the version property value. The version property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getVersion() {
        return this.version;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeCollectionOfObjectValues("branches", this.getBranches());
        writer.writeObjectValue("config", this.getConfig());
        writer.writeStringValue("created_at", this.getCreatedAt());
        writer.writeStringValue("ends_at", this.getEndsAt());
        writer.writeStringValue("family", this.getFamily());
        writer.writeIntegerValue("id", this.getId());
        writer.writeDoubleValue("min_transaction_amount", this.getMinTransactionAmount());
        writer.writeStringValue("moment", this.getMoment());
        writer.writeIntegerValue("multiplier", this.getMultiplier());
        writer.writeStringValue("name", this.getName());
        writer.writeObjectValue("recurrence_config", this.getRecurrenceConfig());
        writer.writeStringValue("recurrence_type", this.getRecurrenceType());
        writer.writeStringValue("schedule_summary", this.getScheduleSummary());
        writer.writeStringValue("starts_at", this.getStartsAt());
        writer.writeObjectValue("status", this.getStatus());
        writer.writeStringValue("updated_at", this.getUpdatedAt());
        writer.writeIntegerValue("version", this.getVersion());
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
     * Sets the branches property value. null means every branch
     * @param value Value to set for the branches property.
     */
    public void setBranches(@jakarta.annotation.Nullable final java.util.List<BranchReferenceData> value) {
        this.branches = value;
    }
    /**
     * Sets the config property value. Its `type` says which shape this is.
     * @param value Value to set for the config property.
     */
    public void setConfig(@jakarta.annotation.Nullable final CampaignListDataConfig value) {
        this.config = value;
    }
    /**
     * Sets the created_at property value. The created_at property
     * @param value Value to set for the created_at property.
     */
    public void setCreatedAt(@jakarta.annotation.Nullable final String value) {
        this.createdAt = value;
    }
    /**
     * Sets the ends_at property value. The ends_at property
     * @param value Value to set for the ends_at property.
     */
    public void setEndsAt(@jakarta.annotation.Nullable final String value) {
        this.endsAt = value;
    }
    /**
     * Sets the family property value. The family property
     * @param value Value to set for the family property.
     */
    public void setFamily(@jakarta.annotation.Nullable final String value) {
        this.family = value;
    }
    /**
     * Sets the id property value. The id property
     * @param value Value to set for the id property.
     */
    public void setId(@jakarta.annotation.Nullable final Integer value) {
        this.id = value;
    }
    /**
     * Sets the min_transaction_amount property value. The min_transaction_amount property
     * @param value Value to set for the min_transaction_amount property.
     */
    public void setMinTransactionAmount(@jakarta.annotation.Nullable final Double value) {
        this.minTransactionAmount = value;
    }
    /**
     * Sets the moment property value. The moment property
     * @param value Value to set for the moment property.
     */
    public void setMoment(@jakarta.annotation.Nullable final String value) {
        this.moment = value;
    }
    /**
     * Sets the multiplier property value. The multiplier property
     * @param value Value to set for the multiplier property.
     */
    public void setMultiplier(@jakarta.annotation.Nullable final Integer value) {
        this.multiplier = value;
    }
    /**
     * Sets the name property value. The name property
     * @param value Value to set for the name property.
     */
    public void setName(@jakarta.annotation.Nullable final String value) {
        this.name = value;
    }
    /**
     * Sets the recurrence_config property value. Its `type` says which shape this is.
     * @param value Value to set for the recurrence_config property.
     */
    public void setRecurrenceConfig(@jakarta.annotation.Nullable final CampaignListDataRecurrenceConfig value) {
        this.recurrenceConfig = value;
    }
    /**
     * Sets the recurrence_type property value. The recurrence_type property
     * @param value Value to set for the recurrence_type property.
     */
    public void setRecurrenceType(@jakarta.annotation.Nullable final String value) {
        this.recurrenceType = value;
    }
    /**
     * Sets the schedule_summary property value. The schedule_summary property
     * @param value Value to set for the schedule_summary property.
     */
    public void setScheduleSummary(@jakarta.annotation.Nullable final String value) {
        this.scheduleSummary = value;
    }
    /**
     * Sets the starts_at property value. The starts_at property
     * @param value Value to set for the starts_at property.
     */
    public void setStartsAt(@jakarta.annotation.Nullable final String value) {
        this.startsAt = value;
    }
    /**
     * Sets the status property value. The status property
     * @param value Value to set for the status property.
     */
    public void setStatus(@jakarta.annotation.Nullable final CampaignStatusData value) {
        this.status = value;
    }
    /**
     * Sets the updated_at property value. The updated_at property
     * @param value Value to set for the updated_at property.
     */
    public void setUpdatedAt(@jakarta.annotation.Nullable final String value) {
        this.updatedAt = value;
    }
    /**
     * Sets the version property value. The version property
     * @param value Value to set for the version property.
     */
    public void setVersion(@jakarta.annotation.Nullable final Integer value) {
        this.version = value;
    }
    /**
     * Composed type wrapper for classes {@link AnniversaryCampaignConfigData}, {@link CampaignListDataConfigMember1}, {@link MomentCampaignConfigData}, {@link NthPurchaseCampaignConfigData}, {@link TransactionCampaignConfigData}, {@link WinBackCampaignConfigData}
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public static class CampaignListDataConfig implements ComposedTypeWrapper, Parsable {
        /**
         * Composed type representation for type {@link AnniversaryCampaignConfigData}
         */
        private AnniversaryCampaignConfigData anniversaryCampaignConfigData;
        /**
         * Composed type representation for type {@link CampaignListDataConfigMember1}
         */
        private CampaignListDataConfigMember1 campaignListDataConfigMember1;
        /**
         * Composed type representation for type {@link MomentCampaignConfigData}
         */
        private MomentCampaignConfigData momentCampaignConfigData;
        /**
         * Composed type representation for type {@link NthPurchaseCampaignConfigData}
         */
        private NthPurchaseCampaignConfigData nthPurchaseCampaignConfigData;
        /**
         * Composed type representation for type {@link TransactionCampaignConfigData}
         */
        private TransactionCampaignConfigData transactionCampaignConfigData;
        /**
         * Composed type representation for type {@link WinBackCampaignConfigData}
         */
        private WinBackCampaignConfigData winBackCampaignConfigData;
        /**
         * Creates a new instance of the appropriate class based on discriminator value
         * @param parseNode The parse node to use to read the discriminator value and create the object
         * @return a {@link CampaignListDataConfig}
         */
        @jakarta.annotation.Nonnull
        public static CampaignListDataConfig createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
            Objects.requireNonNull(parseNode);
            final CampaignListDataConfig result = new CampaignListDataConfig();
            final ParseNode mappingValueNode = parseNode.getChildNode("type");
            if (mappingValueNode != null) {
                final String mappingValue = mappingValueNode.getStringValue();
                if ("anniversary".equalsIgnoreCase(mappingValue)) {
                    result.setAnniversaryCampaignConfigData(new AnniversaryCampaignConfigData());
                } else if ("moment".equalsIgnoreCase(mappingValue)) {
                    result.setMomentCampaignConfigData(new MomentCampaignConfigData());
                } else if ("nth_purchase".equalsIgnoreCase(mappingValue)) {
                    result.setNthPurchaseCampaignConfigData(new NthPurchaseCampaignConfigData());
                } else if ("transaction".equalsIgnoreCase(mappingValue)) {
                    result.setTransactionCampaignConfigData(new TransactionCampaignConfigData());
                } else if ("win_back".equalsIgnoreCase(mappingValue)) {
                    result.setWinBackCampaignConfigData(new WinBackCampaignConfigData());
                }
            }
            return result;
        }
        /**
         * Gets the AnniversaryCampaignConfigData property value. Composed type representation for type {@link AnniversaryCampaignConfigData}
         * @return a {@link AnniversaryCampaignConfigData}
         */
        @jakarta.annotation.Nullable
        public AnniversaryCampaignConfigData getAnniversaryCampaignConfigData() {
            return this.anniversaryCampaignConfigData;
        }
        /**
         * Gets the CampaignListData_configMember1 property value. Composed type representation for type {@link CampaignListDataConfigMember1}
         * @return a {@link CampaignListDataConfigMember1}
         */
        @jakarta.annotation.Nullable
        public CampaignListDataConfigMember1 getCampaignListDataConfigMember1() {
            return this.campaignListDataConfigMember1;
        }
        /**
         * The deserialization information for the current model
         * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
         */
        @jakarta.annotation.Nonnull
        public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
            if (this.getAnniversaryCampaignConfigData() != null) {
                return this.getAnniversaryCampaignConfigData().getFieldDeserializers();
            } else if (this.getCampaignListDataConfigMember1() != null) {
                return this.getCampaignListDataConfigMember1().getFieldDeserializers();
            } else if (this.getMomentCampaignConfigData() != null) {
                return this.getMomentCampaignConfigData().getFieldDeserializers();
            } else if (this.getNthPurchaseCampaignConfigData() != null) {
                return this.getNthPurchaseCampaignConfigData().getFieldDeserializers();
            } else if (this.getTransactionCampaignConfigData() != null) {
                return this.getTransactionCampaignConfigData().getFieldDeserializers();
            } else if (this.getWinBackCampaignConfigData() != null) {
                return this.getWinBackCampaignConfigData().getFieldDeserializers();
            }
            return new HashMap<String, java.util.function.Consumer<ParseNode>>();
        }
        /**
         * Gets the MomentCampaignConfigData property value. Composed type representation for type {@link MomentCampaignConfigData}
         * @return a {@link MomentCampaignConfigData}
         */
        @jakarta.annotation.Nullable
        public MomentCampaignConfigData getMomentCampaignConfigData() {
            return this.momentCampaignConfigData;
        }
        /**
         * Gets the NthPurchaseCampaignConfigData property value. Composed type representation for type {@link NthPurchaseCampaignConfigData}
         * @return a {@link NthPurchaseCampaignConfigData}
         */
        @jakarta.annotation.Nullable
        public NthPurchaseCampaignConfigData getNthPurchaseCampaignConfigData() {
            return this.nthPurchaseCampaignConfigData;
        }
        /**
         * Gets the TransactionCampaignConfigData property value. Composed type representation for type {@link TransactionCampaignConfigData}
         * @return a {@link TransactionCampaignConfigData}
         */
        @jakarta.annotation.Nullable
        public TransactionCampaignConfigData getTransactionCampaignConfigData() {
            return this.transactionCampaignConfigData;
        }
        /**
         * Gets the WinBackCampaignConfigData property value. Composed type representation for type {@link WinBackCampaignConfigData}
         * @return a {@link WinBackCampaignConfigData}
         */
        @jakarta.annotation.Nullable
        public WinBackCampaignConfigData getWinBackCampaignConfigData() {
            return this.winBackCampaignConfigData;
        }
        /**
         * Serializes information the current object
         * @param writer Serialization writer to use to serialize this model
         */
        public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
            Objects.requireNonNull(writer);
            if (this.getAnniversaryCampaignConfigData() != null) {
                writer.writeObjectValue(null, this.getAnniversaryCampaignConfigData());
            } else if (this.getCampaignListDataConfigMember1() != null) {
                writer.writeObjectValue(null, this.getCampaignListDataConfigMember1());
            } else if (this.getMomentCampaignConfigData() != null) {
                writer.writeObjectValue(null, this.getMomentCampaignConfigData());
            } else if (this.getNthPurchaseCampaignConfigData() != null) {
                writer.writeObjectValue(null, this.getNthPurchaseCampaignConfigData());
            } else if (this.getTransactionCampaignConfigData() != null) {
                writer.writeObjectValue(null, this.getTransactionCampaignConfigData());
            } else if (this.getWinBackCampaignConfigData() != null) {
                writer.writeObjectValue(null, this.getWinBackCampaignConfigData());
            }
        }
        /**
         * Sets the AnniversaryCampaignConfigData property value. Composed type representation for type {@link AnniversaryCampaignConfigData}
         * @param value Value to set for the AnniversaryCampaignConfigData property.
         */
        public void setAnniversaryCampaignConfigData(@jakarta.annotation.Nullable final AnniversaryCampaignConfigData value) {
            this.anniversaryCampaignConfigData = value;
        }
        /**
         * Sets the CampaignListData_configMember1 property value. Composed type representation for type {@link CampaignListDataConfigMember1}
         * @param value Value to set for the CampaignListData_configMember1 property.
         */
        public void setCampaignListDataConfigMember1(@jakarta.annotation.Nullable final CampaignListDataConfigMember1 value) {
            this.campaignListDataConfigMember1 = value;
        }
        /**
         * Sets the MomentCampaignConfigData property value. Composed type representation for type {@link MomentCampaignConfigData}
         * @param value Value to set for the MomentCampaignConfigData property.
         */
        public void setMomentCampaignConfigData(@jakarta.annotation.Nullable final MomentCampaignConfigData value) {
            this.momentCampaignConfigData = value;
        }
        /**
         * Sets the NthPurchaseCampaignConfigData property value. Composed type representation for type {@link NthPurchaseCampaignConfigData}
         * @param value Value to set for the NthPurchaseCampaignConfigData property.
         */
        public void setNthPurchaseCampaignConfigData(@jakarta.annotation.Nullable final NthPurchaseCampaignConfigData value) {
            this.nthPurchaseCampaignConfigData = value;
        }
        /**
         * Sets the TransactionCampaignConfigData property value. Composed type representation for type {@link TransactionCampaignConfigData}
         * @param value Value to set for the TransactionCampaignConfigData property.
         */
        public void setTransactionCampaignConfigData(@jakarta.annotation.Nullable final TransactionCampaignConfigData value) {
            this.transactionCampaignConfigData = value;
        }
        /**
         * Sets the WinBackCampaignConfigData property value. Composed type representation for type {@link WinBackCampaignConfigData}
         * @param value Value to set for the WinBackCampaignConfigData property.
         */
        public void setWinBackCampaignConfigData(@jakarta.annotation.Nullable final WinBackCampaignConfigData value) {
            this.winBackCampaignConfigData = value;
        }
    }
    /**
     * Composed type wrapper for classes {@link CampaignListDataRecurrenceConfigMember1}, {@link DateRangeRecurrenceData}, {@link DaysOfWeekRecurrenceData}, {@link SpecificDatesRecurrenceData}
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public static class CampaignListDataRecurrenceConfig implements ComposedTypeWrapper, Parsable {
        /**
         * Composed type representation for type {@link CampaignListDataRecurrenceConfigMember1}
         */
        private CampaignListDataRecurrenceConfigMember1 campaignListDataRecurrenceConfigMember1;
        /**
         * Composed type representation for type {@link DateRangeRecurrenceData}
         */
        private DateRangeRecurrenceData dateRangeRecurrenceData;
        /**
         * Composed type representation for type {@link DaysOfWeekRecurrenceData}
         */
        private DaysOfWeekRecurrenceData daysOfWeekRecurrenceData;
        /**
         * Composed type representation for type {@link SpecificDatesRecurrenceData}
         */
        private SpecificDatesRecurrenceData specificDatesRecurrenceData;
        /**
         * Creates a new instance of the appropriate class based on discriminator value
         * @param parseNode The parse node to use to read the discriminator value and create the object
         * @return a {@link CampaignListDataRecurrenceConfig}
         */
        @jakarta.annotation.Nonnull
        public static CampaignListDataRecurrenceConfig createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
            Objects.requireNonNull(parseNode);
            final CampaignListDataRecurrenceConfig result = new CampaignListDataRecurrenceConfig();
            final ParseNode mappingValueNode = parseNode.getChildNode("type");
            if (mappingValueNode != null) {
                final String mappingValue = mappingValueNode.getStringValue();
                if ("date_range".equalsIgnoreCase(mappingValue)) {
                    result.setDateRangeRecurrenceData(new DateRangeRecurrenceData());
                } else if ("days_of_week".equalsIgnoreCase(mappingValue)) {
                    result.setDaysOfWeekRecurrenceData(new DaysOfWeekRecurrenceData());
                } else if ("specific_dates".equalsIgnoreCase(mappingValue)) {
                    result.setSpecificDatesRecurrenceData(new SpecificDatesRecurrenceData());
                }
            }
            return result;
        }
        /**
         * Gets the CampaignListData_recurrence_configMember1 property value. Composed type representation for type {@link CampaignListDataRecurrenceConfigMember1}
         * @return a {@link CampaignListDataRecurrenceConfigMember1}
         */
        @jakarta.annotation.Nullable
        public CampaignListDataRecurrenceConfigMember1 getCampaignListDataRecurrenceConfigMember1() {
            return this.campaignListDataRecurrenceConfigMember1;
        }
        /**
         * Gets the DateRangeRecurrenceData property value. Composed type representation for type {@link DateRangeRecurrenceData}
         * @return a {@link DateRangeRecurrenceData}
         */
        @jakarta.annotation.Nullable
        public DateRangeRecurrenceData getDateRangeRecurrenceData() {
            return this.dateRangeRecurrenceData;
        }
        /**
         * Gets the DaysOfWeekRecurrenceData property value. Composed type representation for type {@link DaysOfWeekRecurrenceData}
         * @return a {@link DaysOfWeekRecurrenceData}
         */
        @jakarta.annotation.Nullable
        public DaysOfWeekRecurrenceData getDaysOfWeekRecurrenceData() {
            return this.daysOfWeekRecurrenceData;
        }
        /**
         * The deserialization information for the current model
         * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
         */
        @jakarta.annotation.Nonnull
        public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
            if (this.getCampaignListDataRecurrenceConfigMember1() != null) {
                return this.getCampaignListDataRecurrenceConfigMember1().getFieldDeserializers();
            } else if (this.getDateRangeRecurrenceData() != null) {
                return this.getDateRangeRecurrenceData().getFieldDeserializers();
            } else if (this.getDaysOfWeekRecurrenceData() != null) {
                return this.getDaysOfWeekRecurrenceData().getFieldDeserializers();
            } else if (this.getSpecificDatesRecurrenceData() != null) {
                return this.getSpecificDatesRecurrenceData().getFieldDeserializers();
            }
            return new HashMap<String, java.util.function.Consumer<ParseNode>>();
        }
        /**
         * Gets the SpecificDatesRecurrenceData property value. Composed type representation for type {@link SpecificDatesRecurrenceData}
         * @return a {@link SpecificDatesRecurrenceData}
         */
        @jakarta.annotation.Nullable
        public SpecificDatesRecurrenceData getSpecificDatesRecurrenceData() {
            return this.specificDatesRecurrenceData;
        }
        /**
         * Serializes information the current object
         * @param writer Serialization writer to use to serialize this model
         */
        public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
            Objects.requireNonNull(writer);
            if (this.getCampaignListDataRecurrenceConfigMember1() != null) {
                writer.writeObjectValue(null, this.getCampaignListDataRecurrenceConfigMember1());
            } else if (this.getDateRangeRecurrenceData() != null) {
                writer.writeObjectValue(null, this.getDateRangeRecurrenceData());
            } else if (this.getDaysOfWeekRecurrenceData() != null) {
                writer.writeObjectValue(null, this.getDaysOfWeekRecurrenceData());
            } else if (this.getSpecificDatesRecurrenceData() != null) {
                writer.writeObjectValue(null, this.getSpecificDatesRecurrenceData());
            }
        }
        /**
         * Sets the CampaignListData_recurrence_configMember1 property value. Composed type representation for type {@link CampaignListDataRecurrenceConfigMember1}
         * @param value Value to set for the CampaignListData_recurrence_configMember1 property.
         */
        public void setCampaignListDataRecurrenceConfigMember1(@jakarta.annotation.Nullable final CampaignListDataRecurrenceConfigMember1 value) {
            this.campaignListDataRecurrenceConfigMember1 = value;
        }
        /**
         * Sets the DateRangeRecurrenceData property value. Composed type representation for type {@link DateRangeRecurrenceData}
         * @param value Value to set for the DateRangeRecurrenceData property.
         */
        public void setDateRangeRecurrenceData(@jakarta.annotation.Nullable final DateRangeRecurrenceData value) {
            this.dateRangeRecurrenceData = value;
        }
        /**
         * Sets the DaysOfWeekRecurrenceData property value. Composed type representation for type {@link DaysOfWeekRecurrenceData}
         * @param value Value to set for the DaysOfWeekRecurrenceData property.
         */
        public void setDaysOfWeekRecurrenceData(@jakarta.annotation.Nullable final DaysOfWeekRecurrenceData value) {
            this.daysOfWeekRecurrenceData = value;
        }
        /**
         * Sets the SpecificDatesRecurrenceData property value. Composed type representation for type {@link SpecificDatesRecurrenceData}
         * @param value Value to set for the SpecificDatesRecurrenceData property.
         */
        public void setSpecificDatesRecurrenceData(@jakarta.annotation.Nullable final SpecificDatesRecurrenceData value) {
            this.specificDatesRecurrenceData = value;
        }
    }
}
