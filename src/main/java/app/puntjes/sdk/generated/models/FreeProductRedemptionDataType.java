package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

/**
 * Which shape this is.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public enum FreeProductRedemptionDataType implements ValuedEnum {
    Free_product("free_product");
    public final String value;
    FreeProductRedemptionDataType(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static FreeProductRedemptionDataType forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "free_product": return Free_product;
            default: return null;
        }
    }
}
