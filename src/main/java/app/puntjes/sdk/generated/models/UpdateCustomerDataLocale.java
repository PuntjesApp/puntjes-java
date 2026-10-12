package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

@jakarta.annotation.Generated("com.microsoft.kiota")
public enum UpdateCustomerDataLocale implements ValuedEnum {
    Nl("nl"),
    En("en"),
    OpenapiJsonNullSentinelValue2BF936000FE44250987AE5DDB203E464("openapi-json-null-sentinel-value-2BF93600-0FE4-4250-987A-E5DDB203E464");
    public final String value;
    UpdateCustomerDataLocale(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static UpdateCustomerDataLocale forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "nl": return Nl;
            case "en": return En;
            case "openapi-json-null-sentinel-value-2BF93600-0FE4-4250-987A-E5DDB203E464": return OpenapiJsonNullSentinelValue2BF936000FE44250987AE5DDB203E464;
            default: return null;
        }
    }
}
