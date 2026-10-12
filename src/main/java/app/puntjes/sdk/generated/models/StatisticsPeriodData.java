package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class StatisticsPeriodData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The from property
     */
    private String from;
    /**
     * The granularity property
     */
    private String granularity;
    /**
     * The preset property
     */
    private String preset;
    /**
     * The timezone property
     */
    private String timezone;
    /**
     * The to property
     */
    private String to;
    /**
     * Instantiates a new {@link StatisticsPeriodData} and sets the default values.
     */
    public StatisticsPeriodData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link StatisticsPeriodData}
     */
    @jakarta.annotation.Nonnull
    public static StatisticsPeriodData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new StatisticsPeriodData();
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
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(5);
        deserializerMap.put("from", (n) -> { this.setFrom(n.getStringValue()); });
        deserializerMap.put("granularity", (n) -> { this.setGranularity(n.getStringValue()); });
        deserializerMap.put("preset", (n) -> { this.setPreset(n.getStringValue()); });
        deserializerMap.put("timezone", (n) -> { this.setTimezone(n.getStringValue()); });
        deserializerMap.put("to", (n) -> { this.setTo(n.getStringValue()); });
        return deserializerMap;
    }
    /**
     * Gets the from property value. The from property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getFrom() {
        return this.from;
    }
    /**
     * Gets the granularity property value. The granularity property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getGranularity() {
        return this.granularity;
    }
    /**
     * Gets the preset property value. The preset property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getPreset() {
        return this.preset;
    }
    /**
     * Gets the timezone property value. The timezone property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getTimezone() {
        return this.timezone;
    }
    /**
     * Gets the to property value. The to property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getTo() {
        return this.to;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("from", this.getFrom());
        writer.writeStringValue("granularity", this.getGranularity());
        writer.writeStringValue("preset", this.getPreset());
        writer.writeStringValue("timezone", this.getTimezone());
        writer.writeStringValue("to", this.getTo());
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
     * Sets the from property value. The from property
     * @param value Value to set for the from property.
     */
    public void setFrom(@jakarta.annotation.Nullable final String value) {
        this.from = value;
    }
    /**
     * Sets the granularity property value. The granularity property
     * @param value Value to set for the granularity property.
     */
    public void setGranularity(@jakarta.annotation.Nullable final String value) {
        this.granularity = value;
    }
    /**
     * Sets the preset property value. The preset property
     * @param value Value to set for the preset property.
     */
    public void setPreset(@jakarta.annotation.Nullable final String value) {
        this.preset = value;
    }
    /**
     * Sets the timezone property value. The timezone property
     * @param value Value to set for the timezone property.
     */
    public void setTimezone(@jakarta.annotation.Nullable final String value) {
        this.timezone = value;
    }
    /**
     * Sets the to property value. The to property
     * @param value Value to set for the to property.
     */
    public void setTo(@jakarta.annotation.Nullable final String value) {
        this.to = value;
    }
}
