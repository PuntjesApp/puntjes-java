package app.puntjes.sdk.generated.customers.item.walletpass;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

@jakarta.annotation.Generated("com.microsoft.kiota")
public enum GetPlatformQueryParameterType implements ValuedEnum {
    Apple("apple"),
    Google("google");
    public final String value;
    GetPlatformQueryParameterType(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static GetPlatformQueryParameterType forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "apple": return Apple;
            case "google": return Google;
            default: return null;
        }
    }
}
