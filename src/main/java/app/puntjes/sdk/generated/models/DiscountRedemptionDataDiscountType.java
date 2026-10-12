package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

/**
 * Which of the two `discount_value` is.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public enum DiscountRedemptionDataDiscountType implements ValuedEnum {
    Fixed_amount("fixed_amount"),
    Percentage("percentage");
    public final String value;
    DiscountRedemptionDataDiscountType(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static DiscountRedemptionDataDiscountType forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "fixed_amount": return Fixed_amount;
            case "percentage": return Percentage;
            default: return null;
        }
    }
}
