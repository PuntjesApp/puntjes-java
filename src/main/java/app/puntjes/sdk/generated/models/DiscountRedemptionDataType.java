package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

/**
 * Which shape this is.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public enum DiscountRedemptionDataType implements ValuedEnum {
    Discount("discount");
    public final String value;
    DiscountRedemptionDataType(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static DiscountRedemptionDataType forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "discount": return Discount;
            default: return null;
        }
    }
}
