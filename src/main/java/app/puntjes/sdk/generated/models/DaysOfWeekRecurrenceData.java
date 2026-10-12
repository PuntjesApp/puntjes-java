package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class DaysOfWeekRecurrenceData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The days it runs, 0 for Sunday through 6 for Saturday.
     */
    private java.util.List<Integer> days;
    /**
     * Which shape this is.
     */
    private DaysOfWeekRecurrenceDataType type;
    /**
     * Instantiates a new {@link DaysOfWeekRecurrenceData} and sets the default values.
     */
    public DaysOfWeekRecurrenceData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link DaysOfWeekRecurrenceData}
     */
    @jakarta.annotation.Nonnull
    public static DaysOfWeekRecurrenceData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new DaysOfWeekRecurrenceData();
    }
    /**
     * Gets the AdditionalData property value. Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     * @return a {@link Map<String, Object>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, Object> getAdditionalData() {
        return this.additionalData;
    }
    /**
     * Gets the days property value. The days it runs, 0 for Sunday through 6 for Saturday.
     * @return a {@link java.util.List<Integer>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<Integer> getDays() {
        return this.days;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(2);
        deserializerMap.put("days", (n) -> { this.setDays(n.getCollectionOfPrimitiveValues(Integer.class)); });
        deserializerMap.put("type", (n) -> { this.setType(n.getEnumValue(DaysOfWeekRecurrenceDataType::forValue)); });
        return deserializerMap;
    }
    /**
     * Gets the type property value. Which shape this is.
     * @return a {@link DaysOfWeekRecurrenceDataType}
     */
    @jakarta.annotation.Nullable
    public DaysOfWeekRecurrenceDataType getType() {
        return this.type;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeCollectionOfPrimitiveValues("days", this.getDays());
        writer.writeEnumValue("type", this.getType());
        writer.writeAdditionalData(this.getAdditionalData());
    }
    /**
     * Sets the AdditionalData property value. Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     * @param value Value to set for the AdditionalData property.
     */
    public void setAdditionalData(@jakarta.annotation.Nullable final Map<String, Object> value) {
        this.additionalData = value;
    }
    /**
     * Sets the days property value. The days it runs, 0 for Sunday through 6 for Saturday.
     * @param value Value to set for the days property.
     */
    public void setDays(@jakarta.annotation.Nullable final java.util.List<Integer> value) {
        this.days = value;
    }
    /**
     * Sets the type property value. Which shape this is.
     * @param value Value to set for the type property.
     */
    public void setType(@jakarta.annotation.Nullable final DaysOfWeekRecurrenceDataType value) {
        this.type = value;
    }
}
