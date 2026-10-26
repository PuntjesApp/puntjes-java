package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class MergeCustomersApiData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * `true` adds the points of the closed account to the kept account; `false` drops them.
     */
    private Boolean addPoints;
    /**
     * Max 255 characters; the same request again answers 200, another is refused.
     */
    private String idempotencyKey;
    /**
     * Id of the closed account; its rows go to the kept account, its points too if `add_points`.
     */
    private Integer source;
    /**
     * Instantiates a new {@link MergeCustomersApiData} and sets the default values.
     */
    public MergeCustomersApiData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link MergeCustomersApiData}
     */
    @jakarta.annotation.Nonnull
    public static MergeCustomersApiData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new MergeCustomersApiData();
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
     * Gets the add_points property value. `true` adds the points of the closed account to the kept account; `false` drops them.
     * @return a {@link Boolean}
     */
    @jakarta.annotation.Nullable
    public Boolean getAddPoints() {
        return this.addPoints;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(3);
        deserializerMap.put("add_points", (n) -> { this.setAddPoints(n.getBooleanValue()); });
        deserializerMap.put("idempotency_key", (n) -> { this.setIdempotencyKey(n.getStringValue()); });
        deserializerMap.put("source", (n) -> { this.setSource(n.getIntegerValue()); });
        return deserializerMap;
    }
    /**
     * Gets the idempotency_key property value. Max 255 characters; the same request again answers 200, another is refused.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }
    /**
     * Gets the source property value. Id of the closed account; its rows go to the kept account, its points too if `add_points`.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getSource() {
        return this.source;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeBooleanValue("add_points", this.getAddPoints());
        writer.writeStringValue("idempotency_key", this.getIdempotencyKey());
        writer.writeIntegerValue("source", this.getSource());
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
     * Sets the add_points property value. `true` adds the points of the closed account to the kept account; `false` drops them.
     * @param value Value to set for the add_points property.
     */
    public void setAddPoints(@jakarta.annotation.Nullable final Boolean value) {
        this.addPoints = value;
    }
    /**
     * Sets the idempotency_key property value. Max 255 characters; the same request again answers 200, another is refused.
     * @param value Value to set for the idempotency_key property.
     */
    public void setIdempotencyKey(@jakarta.annotation.Nullable final String value) {
        this.idempotencyKey = value;
    }
    /**
     * Sets the source property value. Id of the closed account; its rows go to the kept account, its points too if `add_points`.
     * @param value Value to set for the source property.
     */
    public void setSource(@jakarta.annotation.Nullable final Integer value) {
        this.source = value;
    }
}
