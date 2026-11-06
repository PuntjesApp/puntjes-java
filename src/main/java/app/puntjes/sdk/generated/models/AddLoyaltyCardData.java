package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class AddLoyaltyCardData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The code of a card without a customer on your card list. The setting for new codes does not apply.
     */
    private String code;
    /**
     * The code of the card the customer gives back. Only an active card of this customer is switched off.
     */
    private String replaces;
    /**
     * Instantiates a new {@link AddLoyaltyCardData} and sets the default values.
     */
    public AddLoyaltyCardData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link AddLoyaltyCardData}
     */
    @jakarta.annotation.Nonnull
    public static AddLoyaltyCardData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new AddLoyaltyCardData();
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
     * Gets the code property value. The code of a card without a customer on your card list. The setting for new codes does not apply.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getCode() {
        return this.code;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(2);
        deserializerMap.put("code", (n) -> { this.setCode(n.getStringValue()); });
        deserializerMap.put("replaces", (n) -> { this.setReplaces(n.getStringValue()); });
        return deserializerMap;
    }
    /**
     * Gets the replaces property value. The code of the card the customer gives back. Only an active card of this customer is switched off.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getReplaces() {
        return this.replaces;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("code", this.getCode());
        writer.writeStringValue("replaces", this.getReplaces());
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
     * Sets the code property value. The code of a card without a customer on your card list. The setting for new codes does not apply.
     * @param value Value to set for the code property.
     */
    public void setCode(@jakarta.annotation.Nullable final String value) {
        this.code = value;
    }
    /**
     * Sets the replaces property value. The code of the card the customer gives back. Only an active card of this customer is switched off.
     * @param value Value to set for the replaces property.
     */
    public void setReplaces(@jakarta.annotation.Nullable final String value) {
        this.replaces = value;
    }
}
