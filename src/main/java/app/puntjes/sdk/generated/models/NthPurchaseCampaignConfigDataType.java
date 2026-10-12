package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

/**
 * Which shape this is.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public enum NthPurchaseCampaignConfigDataType implements ValuedEnum {
    Nth_purchase("nth_purchase");
    public final String value;
    NthPurchaseCampaignConfigDataType(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static NthPurchaseCampaignConfigDataType forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "nth_purchase": return Nth_purchase;
            default: return null;
        }
    }
}
