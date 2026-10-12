package app.puntjes.sdk.generated.products;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

@jakarta.annotation.Generated("com.microsoft.kiota")
public enum GetStatusQueryParameterType implements ValuedEnum {
    Active("active"),
    Inactive("inactive"),
    Archived("archived");
    public final String value;
    GetStatusQueryParameterType(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static GetStatusQueryParameterType forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "active": return Active;
            case "inactive": return Inactive;
            case "archived": return Archived;
            default: return null;
        }
    }
}
