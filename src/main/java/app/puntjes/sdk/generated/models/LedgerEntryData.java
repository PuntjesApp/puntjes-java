package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class LedgerEntryData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The amount property
     */
    private Integer amount;
    /**
     * The causer_id property
     */
    private String causerId;
    /**
     * The causer_type property
     */
    private String causerType;
    /**
     * The created_at property
     */
    private String createdAt;
    /**
     * The id property
     */
    private Integer id;
    /**
     * The reason property
     */
    private String reason;
    /**
     * The running_balance property
     */
    private Integer runningBalance;
    /**
     * The type property
     */
    private String type;
    /**
     * The wallet_id property
     */
    private Integer walletId;
    /**
     * Instantiates a new {@link LedgerEntryData} and sets the default values.
     */
    public LedgerEntryData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link LedgerEntryData}
     */
    @jakarta.annotation.Nonnull
    public static LedgerEntryData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new LedgerEntryData();
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
     * Gets the causer_id property value. The causer_id property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getCauserId() {
        return this.causerId;
    }
    /**
     * Gets the causer_type property value. The causer_type property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getCauserType() {
        return this.causerType;
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
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(9);
        deserializerMap.put("amount", (n) -> { this.setAmount(n.getIntegerValue()); });
        deserializerMap.put("causer_id", (n) -> { this.setCauserId(n.getStringValue()); });
        deserializerMap.put("causer_type", (n) -> { this.setCauserType(n.getStringValue()); });
        deserializerMap.put("created_at", (n) -> { this.setCreatedAt(n.getStringValue()); });
        deserializerMap.put("id", (n) -> { this.setId(n.getIntegerValue()); });
        deserializerMap.put("reason", (n) -> { this.setReason(n.getStringValue()); });
        deserializerMap.put("running_balance", (n) -> { this.setRunningBalance(n.getIntegerValue()); });
        deserializerMap.put("type", (n) -> { this.setType(n.getStringValue()); });
        deserializerMap.put("wallet_id", (n) -> { this.setWalletId(n.getIntegerValue()); });
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
     * Gets the reason property value. The reason property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getReason() {
        return this.reason;
    }
    /**
     * Gets the running_balance property value. The running_balance property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getRunningBalance() {
        return this.runningBalance;
    }
    /**
     * Gets the type property value. The type property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getType() {
        return this.type;
    }
    /**
     * Gets the wallet_id property value. The wallet_id property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getWalletId() {
        return this.walletId;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeIntegerValue("amount", this.getAmount());
        writer.writeStringValue("causer_id", this.getCauserId());
        writer.writeStringValue("causer_type", this.getCauserType());
        writer.writeStringValue("created_at", this.getCreatedAt());
        writer.writeIntegerValue("id", this.getId());
        writer.writeStringValue("reason", this.getReason());
        writer.writeIntegerValue("running_balance", this.getRunningBalance());
        writer.writeStringValue("type", this.getType());
        writer.writeIntegerValue("wallet_id", this.getWalletId());
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
     * Sets the causer_id property value. The causer_id property
     * @param value Value to set for the causer_id property.
     */
    public void setCauserId(@jakarta.annotation.Nullable final String value) {
        this.causerId = value;
    }
    /**
     * Sets the causer_type property value. The causer_type property
     * @param value Value to set for the causer_type property.
     */
    public void setCauserType(@jakarta.annotation.Nullable final String value) {
        this.causerType = value;
    }
    /**
     * Sets the created_at property value. The created_at property
     * @param value Value to set for the created_at property.
     */
    public void setCreatedAt(@jakarta.annotation.Nullable final String value) {
        this.createdAt = value;
    }
    /**
     * Sets the id property value. The id property
     * @param value Value to set for the id property.
     */
    public void setId(@jakarta.annotation.Nullable final Integer value) {
        this.id = value;
    }
    /**
     * Sets the reason property value. The reason property
     * @param value Value to set for the reason property.
     */
    public void setReason(@jakarta.annotation.Nullable final String value) {
        this.reason = value;
    }
    /**
     * Sets the running_balance property value. The running_balance property
     * @param value Value to set for the running_balance property.
     */
    public void setRunningBalance(@jakarta.annotation.Nullable final Integer value) {
        this.runningBalance = value;
    }
    /**
     * Sets the type property value. The type property
     * @param value Value to set for the type property.
     */
    public void setType(@jakarta.annotation.Nullable final String value) {
        this.type = value;
    }
    /**
     * Sets the wallet_id property value. The wallet_id property
     * @param value Value to set for the wallet_id property.
     */
    public void setWalletId(@jakarta.annotation.Nullable final Integer value) {
        this.walletId = value;
    }
}
