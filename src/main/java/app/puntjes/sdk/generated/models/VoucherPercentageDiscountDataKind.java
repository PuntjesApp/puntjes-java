package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

/**
 * Deprecated: read `type`, which carries the same value. Always `percentage` for this shape.
 * @deprecated
 * 
 */
@Deprecated
@jakarta.annotation.Generated("com.microsoft.kiota")
public enum VoucherPercentageDiscountDataKind implements ValuedEnum {
    Percentage("percentage");
    public final String value;
    VoucherPercentageDiscountDataKind(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static VoucherPercentageDiscountDataKind forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "percentage": return Percentage;
            default: return null;
        }
    }
}
