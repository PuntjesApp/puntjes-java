package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

/**
 * Which shape this is.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public enum DaysOfWeekRecurrenceDataType implements ValuedEnum {
    Days_of_week("days_of_week");
    public final String value;
    DaysOfWeekRecurrenceDataType(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static DaysOfWeekRecurrenceDataType forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "days_of_week": return Days_of_week;
            default: return null;
        }
    }
}
