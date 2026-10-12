package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class LoyaltyStatisticsData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * points_expired divided by points_issued, 4 decimals. Counts imported points when they expire but not when they arrive, so it can pass 1.0 after an import. Use breakage_rate_excluding_import.
     */
    private Double breakageRate;
    /**
     * Points expired minus points_expired_from_import, divided by points_issued, 4 decimals; null when nothing was issued. The rate the dashboard shows.
     */
    private Double breakageRateExcludingImport;
    /**
     * The net_adjustments property
     */
    private Integer netAdjustments;
    /**
     * Points that expired in the period, including points customers brought along from another loyalty system.
     */
    private Integer pointsExpired;
    /**
     * The part of points_expired that came from points customers brought along from another loyalty system.
     */
    private Integer pointsExpiredFromImport;
    /**
     * The points_issued property
     */
    private Integer pointsIssued;
    /**
     * Points spent on rewards in the period, including points customers brought along from another loyalty system.
     */
    private Integer pointsRedeemed;
    /**
     * The part of points_redeemed that came from points customers brought along from another loyalty system.
     */
    private Integer pointsRedeemedFromImport;
    /**
     * points_redeemed divided by points_issued, 3 decimals. Counts imported points when they are spent but not when they arrive, so it can pass 1.0 after an import. Use redemption_rate_excluding_import.
     */
    private Double redemptionRate;
    /**
     * Points redeemed minus points_redeemed_from_import, divided by points_issued, 3 decimals; null when nothing was issued. The rate the dashboard shows.
     */
    private Double redemptionRateExcludingImport;
    /**
     * Instantiates a new {@link LoyaltyStatisticsData} and sets the default values.
     */
    public LoyaltyStatisticsData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link LoyaltyStatisticsData}
     */
    @jakarta.annotation.Nonnull
    public static LoyaltyStatisticsData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new LoyaltyStatisticsData();
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
     * Gets the breakage_rate property value. points_expired divided by points_issued, 4 decimals. Counts imported points when they expire but not when they arrive, so it can pass 1.0 after an import. Use breakage_rate_excluding_import.
     * @return a {@link Double}
     */
    @jakarta.annotation.Nullable
    public Double getBreakageRate() {
        return this.breakageRate;
    }
    /**
     * Gets the breakage_rate_excluding_import property value. Points expired minus points_expired_from_import, divided by points_issued, 4 decimals; null when nothing was issued. The rate the dashboard shows.
     * @return a {@link Double}
     */
    @jakarta.annotation.Nullable
    public Double getBreakageRateExcludingImport() {
        return this.breakageRateExcludingImport;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(10);
        deserializerMap.put("breakage_rate", (n) -> { this.setBreakageRate(n.getDoubleValue()); });
        deserializerMap.put("breakage_rate_excluding_import", (n) -> { this.setBreakageRateExcludingImport(n.getDoubleValue()); });
        deserializerMap.put("net_adjustments", (n) -> { this.setNetAdjustments(n.getIntegerValue()); });
        deserializerMap.put("points_expired", (n) -> { this.setPointsExpired(n.getIntegerValue()); });
        deserializerMap.put("points_expired_from_import", (n) -> { this.setPointsExpiredFromImport(n.getIntegerValue()); });
        deserializerMap.put("points_issued", (n) -> { this.setPointsIssued(n.getIntegerValue()); });
        deserializerMap.put("points_redeemed", (n) -> { this.setPointsRedeemed(n.getIntegerValue()); });
        deserializerMap.put("points_redeemed_from_import", (n) -> { this.setPointsRedeemedFromImport(n.getIntegerValue()); });
        deserializerMap.put("redemption_rate", (n) -> { this.setRedemptionRate(n.getDoubleValue()); });
        deserializerMap.put("redemption_rate_excluding_import", (n) -> { this.setRedemptionRateExcludingImport(n.getDoubleValue()); });
        return deserializerMap;
    }
    /**
     * Gets the net_adjustments property value. The net_adjustments property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getNetAdjustments() {
        return this.netAdjustments;
    }
    /**
     * Gets the points_expired property value. Points that expired in the period, including points customers brought along from another loyalty system.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getPointsExpired() {
        return this.pointsExpired;
    }
    /**
     * Gets the points_expired_from_import property value. The part of points_expired that came from points customers brought along from another loyalty system.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getPointsExpiredFromImport() {
        return this.pointsExpiredFromImport;
    }
    /**
     * Gets the points_issued property value. The points_issued property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getPointsIssued() {
        return this.pointsIssued;
    }
    /**
     * Gets the points_redeemed property value. Points spent on rewards in the period, including points customers brought along from another loyalty system.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getPointsRedeemed() {
        return this.pointsRedeemed;
    }
    /**
     * Gets the points_redeemed_from_import property value. The part of points_redeemed that came from points customers brought along from another loyalty system.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getPointsRedeemedFromImport() {
        return this.pointsRedeemedFromImport;
    }
    /**
     * Gets the redemption_rate property value. points_redeemed divided by points_issued, 3 decimals. Counts imported points when they are spent but not when they arrive, so it can pass 1.0 after an import. Use redemption_rate_excluding_import.
     * @return a {@link Double}
     */
    @jakarta.annotation.Nullable
    public Double getRedemptionRate() {
        return this.redemptionRate;
    }
    /**
     * Gets the redemption_rate_excluding_import property value. Points redeemed minus points_redeemed_from_import, divided by points_issued, 3 decimals; null when nothing was issued. The rate the dashboard shows.
     * @return a {@link Double}
     */
    @jakarta.annotation.Nullable
    public Double getRedemptionRateExcludingImport() {
        return this.redemptionRateExcludingImport;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeDoubleValue("breakage_rate", this.getBreakageRate());
        writer.writeDoubleValue("breakage_rate_excluding_import", this.getBreakageRateExcludingImport());
        writer.writeIntegerValue("net_adjustments", this.getNetAdjustments());
        writer.writeIntegerValue("points_expired", this.getPointsExpired());
        writer.writeIntegerValue("points_expired_from_import", this.getPointsExpiredFromImport());
        writer.writeIntegerValue("points_issued", this.getPointsIssued());
        writer.writeIntegerValue("points_redeemed", this.getPointsRedeemed());
        writer.writeIntegerValue("points_redeemed_from_import", this.getPointsRedeemedFromImport());
        writer.writeDoubleValue("redemption_rate", this.getRedemptionRate());
        writer.writeDoubleValue("redemption_rate_excluding_import", this.getRedemptionRateExcludingImport());
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
     * Sets the breakage_rate property value. points_expired divided by points_issued, 4 decimals. Counts imported points when they expire but not when they arrive, so it can pass 1.0 after an import. Use breakage_rate_excluding_import.
     * @param value Value to set for the breakage_rate property.
     */
    public void setBreakageRate(@jakarta.annotation.Nullable final Double value) {
        this.breakageRate = value;
    }
    /**
     * Sets the breakage_rate_excluding_import property value. Points expired minus points_expired_from_import, divided by points_issued, 4 decimals; null when nothing was issued. The rate the dashboard shows.
     * @param value Value to set for the breakage_rate_excluding_import property.
     */
    public void setBreakageRateExcludingImport(@jakarta.annotation.Nullable final Double value) {
        this.breakageRateExcludingImport = value;
    }
    /**
     * Sets the net_adjustments property value. The net_adjustments property
     * @param value Value to set for the net_adjustments property.
     */
    public void setNetAdjustments(@jakarta.annotation.Nullable final Integer value) {
        this.netAdjustments = value;
    }
    /**
     * Sets the points_expired property value. Points that expired in the period, including points customers brought along from another loyalty system.
     * @param value Value to set for the points_expired property.
     */
    public void setPointsExpired(@jakarta.annotation.Nullable final Integer value) {
        this.pointsExpired = value;
    }
    /**
     * Sets the points_expired_from_import property value. The part of points_expired that came from points customers brought along from another loyalty system.
     * @param value Value to set for the points_expired_from_import property.
     */
    public void setPointsExpiredFromImport(@jakarta.annotation.Nullable final Integer value) {
        this.pointsExpiredFromImport = value;
    }
    /**
     * Sets the points_issued property value. The points_issued property
     * @param value Value to set for the points_issued property.
     */
    public void setPointsIssued(@jakarta.annotation.Nullable final Integer value) {
        this.pointsIssued = value;
    }
    /**
     * Sets the points_redeemed property value. Points spent on rewards in the period, including points customers brought along from another loyalty system.
     * @param value Value to set for the points_redeemed property.
     */
    public void setPointsRedeemed(@jakarta.annotation.Nullable final Integer value) {
        this.pointsRedeemed = value;
    }
    /**
     * Sets the points_redeemed_from_import property value. The part of points_redeemed that came from points customers brought along from another loyalty system.
     * @param value Value to set for the points_redeemed_from_import property.
     */
    public void setPointsRedeemedFromImport(@jakarta.annotation.Nullable final Integer value) {
        this.pointsRedeemedFromImport = value;
    }
    /**
     * Sets the redemption_rate property value. points_redeemed divided by points_issued, 3 decimals. Counts imported points when they are spent but not when they arrive, so it can pass 1.0 after an import. Use redemption_rate_excluding_import.
     * @param value Value to set for the redemption_rate property.
     */
    public void setRedemptionRate(@jakarta.annotation.Nullable final Double value) {
        this.redemptionRate = value;
    }
    /**
     * Sets the redemption_rate_excluding_import property value. Points redeemed minus points_redeemed_from_import, divided by points_issued, 3 decimals; null when nothing was issued. The rate the dashboard shows.
     * @param value Value to set for the redemption_rate_excluding_import property.
     */
    public void setRedemptionRateExcludingImport(@jakarta.annotation.Nullable final Double value) {
        this.redemptionRateExcludingImport = value;
    }
}
