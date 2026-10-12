package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class DateRangeRecurrenceData implements AdditionalDataHolder, Parsable {
    /**
     * The first day it runs, as `MM-DD`.
     */
    private String activeFrom;
    /**
     * The last day it runs, as `MM-DD`. Earlier than `active_from` wraps over new year.
     */
    private String activeUntil;
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * Which shape this is.
     */
    private DateRangeRecurrenceDataType type;
    /**
     * Instantiates a new {@link DateRangeRecurrenceData} and sets the default values.
     */
    public DateRangeRecurrenceData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link DateRangeRecurrenceData}
     */
    @jakarta.annotation.Nonnull
    public static DateRangeRecurrenceData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new DateRangeRecurrenceData();
    }
    /**
     * Gets the active_from property value. The first day it runs, as `MM-DD`.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getActiveFrom() {
        return this.activeFrom;
    }
    /**
     * Gets the active_until property value. The last day it runs, as `MM-DD`. Earlier than `active_from` wraps over new year.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getActiveUntil() {
        return this.activeUntil;
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
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(3);
        deserializerMap.put("active_from", (n) -> { this.setActiveFrom(n.getStringValue()); });
        deserializerMap.put("active_until", (n) -> { this.setActiveUntil(n.getStringValue()); });
        deserializerMap.put("type", (n) -> { this.setType(n.getEnumValue(DateRangeRecurrenceDataType::forValue)); });
        return deserializerMap;
    }
    /**
     * Gets the type property value. Which shape this is.
     * @return a {@link DateRangeRecurrenceDataType}
     */
    @jakarta.annotation.Nullable
    public DateRangeRecurrenceDataType getType() {
        return this.type;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("active_from", this.getActiveFrom());
        writer.writeStringValue("active_until", this.getActiveUntil());
        writer.writeEnumValue("type", this.getType());
        writer.writeAdditionalData(this.getAdditionalData());
    }
    /**
     * Sets the active_from property value. The first day it runs, as `MM-DD`.
     * @param value Value to set for the active_from property.
     */
    public void setActiveFrom(@jakarta.annotation.Nullable final String value) {
        this.activeFrom = value;
    }
    /**
     * Sets the active_until property value. The last day it runs, as `MM-DD`. Earlier than `active_from` wraps over new year.
     * @param value Value to set for the active_until property.
     */
    public void setActiveUntil(@jakarta.annotation.Nullable final String value) {
        this.activeUntil = value;
    }
    /**
     * Sets the AdditionalData property value. Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     * @param value Value to set for the AdditionalData property.
     */
    public void setAdditionalData(@jakarta.annotation.Nullable final Map<String, Object> value) {
        this.additionalData = value;
    }
    /**
     * Sets the type property value. Which shape this is.
     * @param value Value to set for the type property.
     */
    public void setType(@jakarta.annotation.Nullable final DateRangeRecurrenceDataType value) {
        this.type = value;
    }
}
