package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

/**
 * Always `points` for this shape.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public enum PointsGiftDataType implements ValuedEnum {
    Points("points");
    public final String value;
    PointsGiftDataType(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static PointsGiftDataType forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "points": return Points;
            default: return null;
        }
    }
}
