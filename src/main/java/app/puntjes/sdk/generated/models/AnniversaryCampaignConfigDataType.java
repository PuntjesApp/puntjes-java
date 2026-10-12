package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

/**
 * Which shape this is.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public enum AnniversaryCampaignConfigDataType implements ValuedEnum {
    Anniversary("anniversary");
    public final String value;
    AnniversaryCampaignConfigDataType(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static AnniversaryCampaignConfigDataType forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "anniversary": return Anniversary;
            default: return null;
        }
    }
}
