package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class SendLoyaltyCardResultData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The channel property
     */
    private String channel;
    /**
     * The customer_id property
     */
    private Integer customerId;
    /**
     * The queued property
     */
    private Boolean queued;
    /**
     * Instantiates a new {@link SendLoyaltyCardResultData} and sets the default values.
     */
    public SendLoyaltyCardResultData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link SendLoyaltyCardResultData}
     */
    @jakarta.annotation.Nonnull
    public static SendLoyaltyCardResultData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new SendLoyaltyCardResultData();
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
     * Gets the channel property value. The channel property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getChannel() {
        return this.channel;
    }
    /**
     * Gets the customer_id property value. The customer_id property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getCustomerId() {
        return this.customerId;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(3);
        deserializerMap.put("channel", (n) -> { this.setChannel(n.getStringValue()); });
        deserializerMap.put("customer_id", (n) -> { this.setCustomerId(n.getIntegerValue()); });
        deserializerMap.put("queued", (n) -> { this.setQueued(n.getBooleanValue()); });
        return deserializerMap;
    }
    /**
     * Gets the queued property value. The queued property
     * @return a {@link Boolean}
     */
    @jakarta.annotation.Nullable
    public Boolean getQueued() {
        return this.queued;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("channel", this.getChannel());
        writer.writeIntegerValue("customer_id", this.getCustomerId());
        writer.writeBooleanValue("queued", this.getQueued());
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
     * Sets the channel property value. The channel property
     * @param value Value to set for the channel property.
     */
    public void setChannel(@jakarta.annotation.Nullable final String value) {
        this.channel = value;
    }
    /**
     * Sets the customer_id property value. The customer_id property
     * @param value Value to set for the customer_id property.
     */
    public void setCustomerId(@jakarta.annotation.Nullable final Integer value) {
        this.customerId = value;
    }
    /**
     * Sets the queued property value. The queued property
     * @param value Value to set for the queued property.
     */
    public void setQueued(@jakarta.annotation.Nullable final Boolean value) {
        this.queued = value;
    }
}
