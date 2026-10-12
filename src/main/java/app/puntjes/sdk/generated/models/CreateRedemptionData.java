package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class CreateRedemptionData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The branch property
     */
    private String branch;
    /**
     * The idempotency_key property
     */
    private String idempotencyKey;
    /**
     * The identifier property
     */
    private String identifier;
    /**
     * The reward_id property
     */
    private Integer rewardId;
    /**
     * Instantiates a new {@link CreateRedemptionData} and sets the default values.
     */
    public CreateRedemptionData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link CreateRedemptionData}
     */
    @jakarta.annotation.Nonnull
    public static CreateRedemptionData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new CreateRedemptionData();
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
     * Gets the branch property value. The branch property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getBranch() {
        return this.branch;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(4);
        deserializerMap.put("branch", (n) -> { this.setBranch(n.getStringValue()); });
        deserializerMap.put("idempotency_key", (n) -> { this.setIdempotencyKey(n.getStringValue()); });
        deserializerMap.put("identifier", (n) -> { this.setIdentifier(n.getStringValue()); });
        deserializerMap.put("reward_id", (n) -> { this.setRewardId(n.getIntegerValue()); });
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
     * Gets the identifier property value. The identifier property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getIdentifier() {
        return this.identifier;
    }
    /**
     * Gets the reward_id property value. The reward_id property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getRewardId() {
        return this.rewardId;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("branch", this.getBranch());
        writer.writeStringValue("idempotency_key", this.getIdempotencyKey());
        writer.writeStringValue("identifier", this.getIdentifier());
        writer.writeIntegerValue("reward_id", this.getRewardId());
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
     * Sets the branch property value. The branch property
     * @param value Value to set for the branch property.
     */
    public void setBranch(@jakarta.annotation.Nullable final String value) {
        this.branch = value;
    }
    /**
     * Sets the idempotency_key property value. The idempotency_key property
     * @param value Value to set for the idempotency_key property.
     */
    public void setIdempotencyKey(@jakarta.annotation.Nullable final String value) {
        this.idempotencyKey = value;
    }
    /**
     * Sets the identifier property value. The identifier property
     * @param value Value to set for the identifier property.
     */
    public void setIdentifier(@jakarta.annotation.Nullable final String value) {
        this.identifier = value;
    }
    /**
     * Sets the reward_id property value. The reward_id property
     * @param value Value to set for the reward_id property.
     */
    public void setRewardId(@jakarta.annotation.Nullable final Integer value) {
        this.rewardId = value;
    }
}
