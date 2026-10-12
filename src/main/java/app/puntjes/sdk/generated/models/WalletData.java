package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class WalletData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The balance property
     */
    private Integer balance;
    /**
     * The created_at property
     */
    private String createdAt;
    /**
     * The customer_id property
     */
    private Integer customerId;
    /**
     * The expiring_soon property
     */
    private Integer expiringSoon;
    /**
     * The id property
     */
    private Integer id;
    /**
     * The updated_at property
     */
    private String updatedAt;
    /**
     * Instantiates a new {@link WalletData} and sets the default values.
     */
    public WalletData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link WalletData}
     */
    @jakarta.annotation.Nonnull
    public static WalletData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new WalletData();
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
     * Gets the balance property value. The balance property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getBalance() {
        return this.balance;
    }
    /**
     * Gets the created_at property value. The created_at property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getCreatedAt() {
        return this.createdAt;
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
     * Gets the expiring_soon property value. The expiring_soon property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getExpiringSoon() {
        return this.expiringSoon;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(6);
        deserializerMap.put("balance", (n) -> { this.setBalance(n.getIntegerValue()); });
        deserializerMap.put("created_at", (n) -> { this.setCreatedAt(n.getStringValue()); });
        deserializerMap.put("customer_id", (n) -> { this.setCustomerId(n.getIntegerValue()); });
        deserializerMap.put("expiring_soon", (n) -> { this.setExpiringSoon(n.getIntegerValue()); });
        deserializerMap.put("id", (n) -> { this.setId(n.getIntegerValue()); });
        deserializerMap.put("updated_at", (n) -> { this.setUpdatedAt(n.getStringValue()); });
        return deserializerMap;
    }
    /**
     * Gets the id property value. The id property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getId() {
        return this.id;
    }
    /**
     * Gets the updated_at property value. The updated_at property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getUpdatedAt() {
        return this.updatedAt;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeIntegerValue("balance", this.getBalance());
        writer.writeStringValue("created_at", this.getCreatedAt());
        writer.writeIntegerValue("customer_id", this.getCustomerId());
        writer.writeIntegerValue("expiring_soon", this.getExpiringSoon());
        writer.writeIntegerValue("id", this.getId());
        writer.writeStringValue("updated_at", this.getUpdatedAt());
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
     * Sets the balance property value. The balance property
     * @param value Value to set for the balance property.
     */
    public void setBalance(@jakarta.annotation.Nullable final Integer value) {
        this.balance = value;
    }
    /**
     * Sets the created_at property value. The created_at property
     * @param value Value to set for the created_at property.
     */
    public void setCreatedAt(@jakarta.annotation.Nullable final String value) {
        this.createdAt = value;
    }
    /**
     * Sets the customer_id property value. The customer_id property
     * @param value Value to set for the customer_id property.
     */
    public void setCustomerId(@jakarta.annotation.Nullable final Integer value) {
        this.customerId = value;
    }
    /**
     * Sets the expiring_soon property value. The expiring_soon property
     * @param value Value to set for the expiring_soon property.
     */
    public void setExpiringSoon(@jakarta.annotation.Nullable final Integer value) {
        this.expiringSoon = value;
    }
    /**
     * Sets the id property value. The id property
     * @param value Value to set for the id property.
     */
    public void setId(@jakarta.annotation.Nullable final Integer value) {
        this.id = value;
    }
    /**
     * Sets the updated_at property value. The updated_at property
     * @param value Value to set for the updated_at property.
     */
    public void setUpdatedAt(@jakarta.annotation.Nullable final String value) {
        this.updatedAt = value;
    }
}
