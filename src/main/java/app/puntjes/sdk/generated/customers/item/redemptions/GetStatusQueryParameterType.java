package app.puntjes.sdk.generated.customers.item.redemptions;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

@jakarta.annotation.Generated("com.microsoft.kiota")
public enum GetStatusQueryParameterType implements ValuedEnum {
    Valid("valid"),
    Used("used"),
    Expired("expired"),
    Cancelled("cancelled");
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
            case "valid": return Valid;
            case "used": return Used;
            case "expired": return Expired;
            case "cancelled": return Cancelled;
            default: return null;
        }
    }
}
