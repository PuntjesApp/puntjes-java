package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class EarnResultData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The campaign_version property
     */
    private Integer campaignVersion;
    /**
     * The family property
     */
    private String family;
    /**
     * The line_breakdown property
     */
    private java.util.List<EarnResultDataLineBreakdown> lineBreakdown;
    /**
     * The moment property
     */
    private String moment;
    /**
     * The points_earned property
     */
    private Integer pointsEarned;
    /**
     * The reason property
     */
    private String reason;
    /**
     * The rule_id property
     */
    private Integer ruleId;
    /**
     * The rule_name property
     */
    private String ruleName;
    /**
     * The rule_type property
     */
    private String ruleType;
    /**
     * The suppressed_by property
     */
    private Integer suppressedBy;
    /**
     * Instantiates a new {@link EarnResultData} and sets the default values.
     */
    public EarnResultData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link EarnResultData}
     */
    @jakarta.annotation.Nonnull
    public static EarnResultData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new EarnResultData();
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
     * Gets the campaign_version property value. The campaign_version property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getCampaignVersion() {
        return this.campaignVersion;
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
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(10);
        deserializerMap.put("campaign_version", (n) -> { this.setCampaignVersion(n.getIntegerValue()); });
        deserializerMap.put("family", (n) -> { this.setFamily(n.getStringValue()); });
        deserializerMap.put("line_breakdown", (n) -> { this.setLineBreakdown(n.getCollectionOfObjectValues(EarnResultDataLineBreakdown::createFromDiscriminatorValue)); });
        deserializerMap.put("moment", (n) -> { this.setMoment(n.getStringValue()); });
        deserializerMap.put("points_earned", (n) -> { this.setPointsEarned(n.getIntegerValue()); });
        deserializerMap.put("reason", (n) -> { this.setReason(n.getStringValue()); });
        deserializerMap.put("rule_id", (n) -> { this.setRuleId(n.getIntegerValue()); });
        deserializerMap.put("rule_name", (n) -> { this.setRuleName(n.getStringValue()); });
        deserializerMap.put("rule_type", (n) -> { this.setRuleType(n.getStringValue()); });
        deserializerMap.put("suppressed_by", (n) -> { this.setSuppressedBy(n.getIntegerValue()); });
        return deserializerMap;
    }
    /**
     * Gets the line_breakdown property value. The line_breakdown property
     * @return a {@link java.util.List<EarnResultDataLineBreakdown>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<EarnResultDataLineBreakdown> getLineBreakdown() {
        return this.lineBreakdown;
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
     * Gets the points_earned property value. The points_earned property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getPointsEarned() {
        return this.pointsEarned;
    }
    /**
     * Gets the reason property value. The reason property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getReason() {
        return this.reason;
    }
    /**
     * Gets the rule_id property value. The rule_id property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getRuleId() {
        return this.ruleId;
    }
    /**
     * Gets the rule_name property value. The rule_name property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getRuleName() {
        return this.ruleName;
    }
    /**
     * Gets the rule_type property value. The rule_type property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getRuleType() {
        return this.ruleType;
    }
    /**
     * Gets the suppressed_by property value. The suppressed_by property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getSuppressedBy() {
        return this.suppressedBy;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeIntegerValue("campaign_version", this.getCampaignVersion());
        writer.writeStringValue("family", this.getFamily());
        writer.writeCollectionOfObjectValues("line_breakdown", this.getLineBreakdown());
        writer.writeStringValue("moment", this.getMoment());
        writer.writeIntegerValue("points_earned", this.getPointsEarned());
        writer.writeStringValue("reason", this.getReason());
        writer.writeIntegerValue("rule_id", this.getRuleId());
        writer.writeStringValue("rule_name", this.getRuleName());
        writer.writeStringValue("rule_type", this.getRuleType());
        writer.writeIntegerValue("suppressed_by", this.getSuppressedBy());
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
     * Sets the campaign_version property value. The campaign_version property
     * @param value Value to set for the campaign_version property.
     */
    public void setCampaignVersion(@jakarta.annotation.Nullable final Integer value) {
        this.campaignVersion = value;
    }
    /**
     * Sets the family property value. The family property
     * @param value Value to set for the family property.
     */
    public void setFamily(@jakarta.annotation.Nullable final String value) {
        this.family = value;
    }
    /**
     * Sets the line_breakdown property value. The line_breakdown property
     * @param value Value to set for the line_breakdown property.
     */
    public void setLineBreakdown(@jakarta.annotation.Nullable final java.util.List<EarnResultDataLineBreakdown> value) {
        this.lineBreakdown = value;
    }
    /**
     * Sets the moment property value. The moment property
     * @param value Value to set for the moment property.
     */
    public void setMoment(@jakarta.annotation.Nullable final String value) {
        this.moment = value;
    }
    /**
     * Sets the points_earned property value. The points_earned property
     * @param value Value to set for the points_earned property.
     */
    public void setPointsEarned(@jakarta.annotation.Nullable final Integer value) {
        this.pointsEarned = value;
    }
    /**
     * Sets the reason property value. The reason property
     * @param value Value to set for the reason property.
     */
    public void setReason(@jakarta.annotation.Nullable final String value) {
        this.reason = value;
    }
    /**
     * Sets the rule_id property value. The rule_id property
     * @param value Value to set for the rule_id property.
     */
    public void setRuleId(@jakarta.annotation.Nullable final Integer value) {
        this.ruleId = value;
    }
    /**
     * Sets the rule_name property value. The rule_name property
     * @param value Value to set for the rule_name property.
     */
    public void setRuleName(@jakarta.annotation.Nullable final String value) {
        this.ruleName = value;
    }
    /**
     * Sets the rule_type property value. The rule_type property
     * @param value Value to set for the rule_type property.
     */
    public void setRuleType(@jakarta.annotation.Nullable final String value) {
        this.ruleType = value;
    }
    /**
     * Sets the suppressed_by property value. The suppressed_by property
     * @param value Value to set for the suppressed_by property.
     */
    public void setSuppressedBy(@jakarta.annotation.Nullable final Integer value) {
        this.suppressedBy = value;
    }
}
