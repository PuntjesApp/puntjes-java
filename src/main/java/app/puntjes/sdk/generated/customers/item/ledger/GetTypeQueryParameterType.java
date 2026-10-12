package app.puntjes.sdk.generated.customers.item.ledger;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

@jakarta.annotation.Generated("com.microsoft.kiota")
public enum GetTypeQueryParameterType implements ValuedEnum {
    Earn("earn"),
    Adjust("adjust"),
    Redeem("redeem"),
    Expire("expire");
    public final String value;
    GetTypeQueryParameterType(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static GetTypeQueryParameterType forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "earn": return Earn;
            case "adjust": return Adjust;
            case "redeem": return Redeem;
            case "expire": return Expire;
            default: return null;
        }
    }
}
