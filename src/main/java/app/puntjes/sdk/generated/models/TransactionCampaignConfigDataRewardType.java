package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

/**
 * Multiply the points earned, or add a fixed number. Absent reads as `multiplier`.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public enum TransactionCampaignConfigDataRewardType implements ValuedEnum {
    Multiplier("multiplier"),
    Fixed_points("fixed_points");
    public final String value;
    TransactionCampaignConfigDataRewardType(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static TransactionCampaignConfigDataRewardType forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "multiplier": return Multiplier;
            case "fixed_points": return Fixed_points;
            default: return null;
        }
    }
}
