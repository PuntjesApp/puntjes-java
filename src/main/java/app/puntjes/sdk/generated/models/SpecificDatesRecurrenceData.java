package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class SpecificDatesRecurrenceData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The days it runs, each as `YYYY-MM-DD`.
     */
    private java.util.List<String> dates;
    /**
     * Which shape this is.
     */
    private SpecificDatesRecurrenceDataType type;
    /**
     * Instantiates a new {@link SpecificDatesRecurrenceData} and sets the default values.
     */
    public SpecificDatesRecurrenceData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link SpecificDatesRecurrenceData}
     */
    @jakarta.annotation.Nonnull
    public static SpecificDatesRecurrenceData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new SpecificDatesRecurrenceData();
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
     * Gets the dates property value. The days it runs, each as `YYYY-MM-DD`.
     * @return a {@link java.util.List<String>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<String> getDates() {
        return this.dates;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(2);
        deserializerMap.put("dates", (n) -> { this.setDates(n.getCollectionOfPrimitiveValues(String.class)); });
        deserializerMap.put("type", (n) -> { this.setType(n.getEnumValue(SpecificDatesRecurrenceDataType::forValue)); });
        return deserializerMap;
    }
    /**
     * Gets the type property value. Which shape this is.
     * @return a {@link SpecificDatesRecurrenceDataType}
     */
    @jakarta.annotation.Nullable
    public SpecificDatesRecurrenceDataType getType() {
        return this.type;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeCollectionOfPrimitiveValues("dates", this.getDates());
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
     * Sets the dates property value. The days it runs, each as `YYYY-MM-DD`.
     * @param value Value to set for the dates property.
     */
    public void setDates(@jakarta.annotation.Nullable final java.util.List<String> value) {
        this.dates = value;
    }
    /**
     * Sets the type property value. Which shape this is.
     * @param value Value to set for the type property.
     */
    public void setType(@jakarta.annotation.Nullable final SpecificDatesRecurrenceDataType value) {
        this.type = value;
    }
}
