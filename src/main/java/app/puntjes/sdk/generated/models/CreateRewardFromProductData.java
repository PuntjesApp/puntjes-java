package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class CreateRewardFromProductData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The available_from property
     */
    private String availableFrom;
    /**
     * The available_until property
     */
    private String availableUntil;
    /**
     * The code_valid_for_hours property
     */
    private Integer codeValidForHours;
    /**
     * The description property
     */
    private String description;
    /**
     * The idempotency_key property
     */
    private String idempotencyKey;
    /**
     * The max_redemptions_per_customer property
     */
    private Integer maxRedemptionsPerCustomer;
    /**
     * The name property
     */
    private String name;
    /**
     * The payment_amount property
     */
    private Integer paymentAmount;
    /**
     * The point_cost property
     */
    private Integer pointCost;
    /**
     * The status property
     */
    private CreateRewardFromProductDataStatus status;
    /**
     * The total_stock property
     */
    private Integer totalStock;
    /**
     * Instantiates a new {@link CreateRewardFromProductData} and sets the default values.
     */
    public CreateRewardFromProductData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link CreateRewardFromProductData}
     */
    @jakarta.annotation.Nonnull
    public static CreateRewardFromProductData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new CreateRewardFromProductData();
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
     * Gets the available_from property value. The available_from property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getAvailableFrom() {
        return this.availableFrom;
    }
    /**
     * Gets the available_until property value. The available_until property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getAvailableUntil() {
        return this.availableUntil;
    }
    /**
     * Gets the code_valid_for_hours property value. The code_valid_for_hours property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getCodeValidForHours() {
        return this.codeValidForHours;
    }
    /**
     * Gets the description property value. The description property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getDescription() {
        return this.description;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(11);
        deserializerMap.put("available_from", (n) -> { this.setAvailableFrom(n.getStringValue()); });
        deserializerMap.put("available_until", (n) -> { this.setAvailableUntil(n.getStringValue()); });
        deserializerMap.put("code_valid_for_hours", (n) -> { this.setCodeValidForHours(n.getIntegerValue()); });
        deserializerMap.put("description", (n) -> { this.setDescription(n.getStringValue()); });
        deserializerMap.put("idempotency_key", (n) -> { this.setIdempotencyKey(n.getStringValue()); });
        deserializerMap.put("max_redemptions_per_customer", (n) -> { this.setMaxRedemptionsPerCustomer(n.getIntegerValue()); });
        deserializerMap.put("name", (n) -> { this.setName(n.getStringValue()); });
        deserializerMap.put("payment_amount", (n) -> { this.setPaymentAmount(n.getIntegerValue()); });
        deserializerMap.put("point_cost", (n) -> { this.setPointCost(n.getIntegerValue()); });
        deserializerMap.put("status", (n) -> { this.setStatus(n.getEnumValue(CreateRewardFromProductDataStatus::forValue)); });
        deserializerMap.put("total_stock", (n) -> { this.setTotalStock(n.getIntegerValue()); });
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
     * Gets the max_redemptions_per_customer property value. The max_redemptions_per_customer property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getMaxRedemptionsPerCustomer() {
        return this.maxRedemptionsPerCustomer;
    }
    /**
     * Gets the name property value. The name property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getName() {
        return this.name;
    }
    /**
     * Gets the payment_amount property value. The payment_amount property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getPaymentAmount() {
        return this.paymentAmount;
    }
    /**
     * Gets the point_cost property value. The point_cost property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getPointCost() {
        return this.pointCost;
    }
    /**
     * Gets the status property value. The status property
     * @return a {@link CreateRewardFromProductDataStatus}
     */
    @jakarta.annotation.Nullable
    public CreateRewardFromProductDataStatus getStatus() {
        return this.status;
    }
    /**
     * Gets the total_stock property value. The total_stock property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getTotalStock() {
        return this.totalStock;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("available_from", this.getAvailableFrom());
        writer.writeStringValue("available_until", this.getAvailableUntil());
        writer.writeIntegerValue("code_valid_for_hours", this.getCodeValidForHours());
        writer.writeStringValue("description", this.getDescription());
        writer.writeStringValue("idempotency_key", this.getIdempotencyKey());
        writer.writeIntegerValue("max_redemptions_per_customer", this.getMaxRedemptionsPerCustomer());
        writer.writeStringValue("name", this.getName());
        writer.writeIntegerValue("payment_amount", this.getPaymentAmount());
        writer.writeIntegerValue("point_cost", this.getPointCost());
        writer.writeEnumValue("status", this.getStatus());
        writer.writeIntegerValue("total_stock", this.getTotalStock());
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
     * Sets the available_from property value. The available_from property
     * @param value Value to set for the available_from property.
     */
    public void setAvailableFrom(@jakarta.annotation.Nullable final String value) {
        this.availableFrom = value;
    }
    /**
     * Sets the available_until property value. The available_until property
     * @param value Value to set for the available_until property.
     */
    public void setAvailableUntil(@jakarta.annotation.Nullable final String value) {
        this.availableUntil = value;
    }
    /**
     * Sets the code_valid_for_hours property value. The code_valid_for_hours property
     * @param value Value to set for the code_valid_for_hours property.
     */
    public void setCodeValidForHours(@jakarta.annotation.Nullable final Integer value) {
        this.codeValidForHours = value;
    }
    /**
     * Sets the description property value. The description property
     * @param value Value to set for the description property.
     */
    public void setDescription(@jakarta.annotation.Nullable final String value) {
        this.description = value;
    }
    /**
     * Sets the idempotency_key property value. The idempotency_key property
     * @param value Value to set for the idempotency_key property.
     */
    public void setIdempotencyKey(@jakarta.annotation.Nullable final String value) {
        this.idempotencyKey = value;
    }
    /**
     * Sets the max_redemptions_per_customer property value. The max_redemptions_per_customer property
     * @param value Value to set for the max_redemptions_per_customer property.
     */
    public void setMaxRedemptionsPerCustomer(@jakarta.annotation.Nullable final Integer value) {
        this.maxRedemptionsPerCustomer = value;
    }
    /**
     * Sets the name property value. The name property
     * @param value Value to set for the name property.
     */
    public void setName(@jakarta.annotation.Nullable final String value) {
        this.name = value;
    }
    /**
     * Sets the payment_amount property value. The payment_amount property
     * @param value Value to set for the payment_amount property.
     */
    public void setPaymentAmount(@jakarta.annotation.Nullable final Integer value) {
        this.paymentAmount = value;
    }
    /**
     * Sets the point_cost property value. The point_cost property
     * @param value Value to set for the point_cost property.
     */
    public void setPointCost(@jakarta.annotation.Nullable final Integer value) {
        this.pointCost = value;
    }
    /**
     * Sets the status property value. The status property
     * @param value Value to set for the status property.
     */
    public void setStatus(@jakarta.annotation.Nullable final CreateRewardFromProductDataStatus value) {
        this.status = value;
    }
    /**
     * Sets the total_stock property value. The total_stock property
     * @param value Value to set for the total_stock property.
     */
    public void setTotalStock(@jakarta.annotation.Nullable final Integer value) {
        this.totalStock = value;
    }
}
