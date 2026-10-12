package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

/**
 * Deprecated: read `type`, which carries the same value. Always `fixed` for this shape.
 * @deprecated
 * 
 */
@Deprecated
@jakarta.annotation.Generated("com.microsoft.kiota")
public enum FixedDiscountDataKind implements ValuedEnum {
    Fixed("fixed");
    public final String value;
    FixedDiscountDataKind(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static FixedDiscountDataKind forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "fixed": return Fixed;
            default: return null;
        }
    }
}
