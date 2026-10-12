package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

/**
 * Which shape this is.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public enum SpecificDatesRecurrenceDataType implements ValuedEnum {
    Specific_dates("specific_dates");
    public final String value;
    SpecificDatesRecurrenceDataType(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static SpecificDatesRecurrenceDataType forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "specific_dates": return Specific_dates;
            default: return null;
        }
    }
}
