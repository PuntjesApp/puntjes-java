package app.puntjes.sdk.generated.statistics;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

@jakarta.annotation.Generated("com.microsoft.kiota")
public enum GetPeriodQueryParameterType implements ValuedEnum {
    Today("today"),
    Sevend("7d"),
    ThreeZerod("30d"),
    NineZerod("90d");
    public final String value;
    GetPeriodQueryParameterType(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static GetPeriodQueryParameterType forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "today": return Today;
            case "7d": return Sevend;
            case "30d": return ThreeZerod;
            case "90d": return NineZerod;
            default: return null;
        }
    }
}
