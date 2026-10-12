package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class AdjustWalletApiData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The amount property
     */
    private Integer amount;
    /**
     * The idempotency_key property
     */
    private String idempotencyKey;
    /**
     * The reason property
     */
    private String reason;
    /**
     * Instantiates a new {@link AdjustWalletApiData} and sets the default values.
     */
    public AdjustWalletApiData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link AdjustWalletApiData}
     */
    @jakarta.annotation.Nonnull
    public static AdjustWalletApiData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new AdjustWalletApiData();
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
     * Gets the amount property value. The amount property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getAmount() {
        return this.amount;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(3);
        deserializerMap.put("amount", (n) -> { this.setAmount(n.getIntegerValue()); });
        deserializerMap.put("idempotency_key", (n) -> { this.setIdempotencyKey(n.getStringValue()); });
        deserializerMap.put("reason", (n) -> { this.setReason(n.getStringValue()); });
        return deserializerMap;
    }
    /**
     * Gets the idempotency_key property value. The idempotency_key property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }
    /**
     * Gets the reason property value. The reason property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getReason() {
        return this.reason;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeIntegerValue("amount", this.getAmount());
        writer.writeStringValue("idempotency_key", this.getIdempotencyKey());
        writer.writeStringValue("reason", this.getReason());
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
     * Sets the amount property value. The amount property
     * @param value Value to set for the amount property.
     */
    public void setAmount(@jakarta.annotation.Nullable final Integer value) {
        this.amount = value;
    }
    /**
     * Sets the idempotency_key property value. The idempotency_key property
     * @param value Value to set for the idempotency_key property.
     */
    public void setIdempotencyKey(@jakarta.annotation.Nullable final String value) {
        this.idempotencyKey = value;
    }
    /**
     * Sets the reason property value. The reason property
     * @param value Value to set for the reason property.
     */
    public void setReason(@jakarta.annotation.Nullable final String value) {
        this.reason = value;
    }
}
