package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

@jakarta.annotation.Generated("com.microsoft.kiota")
public enum SendLoyaltyCardRequestDataChannel implements ValuedEnum {
    Email("email"),
    OpenapiJsonNullSentinelValue2BF936000FE44250987AE5DDB203E464("openapi-json-null-sentinel-value-2BF93600-0FE4-4250-987A-E5DDB203E464");
    public final String value;
    SendLoyaltyCardRequestDataChannel(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static SendLoyaltyCardRequestDataChannel forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "email": return Email;
            case "openapi-json-null-sentinel-value-2BF93600-0FE4-4250-987A-E5DDB203E464": return OpenapiJsonNullSentinelValue2BF936000FE44250987AE5DDB203E464;
            default: return null;
        }
    }
}
