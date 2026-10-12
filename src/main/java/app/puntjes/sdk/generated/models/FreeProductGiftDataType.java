package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

/**
 * Always `free_product` for this shape.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public enum FreeProductGiftDataType implements ValuedEnum {
    Free_product("free_product");
    public final String value;
    FreeProductGiftDataType(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static FreeProductGiftDataType forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "free_product": return Free_product;
            default: return null;
        }
    }
}
