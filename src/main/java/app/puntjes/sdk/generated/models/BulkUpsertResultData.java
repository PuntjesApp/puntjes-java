package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class BulkUpsertResultData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * Each rejected field and its messages. Absent when the item succeeded.
     */
    private BulkUpsertResultDataErrors errors;
    /**
     * The external_id property
     */
    private String externalId;
    /**
     * The index property
     */
    private Integer index;
    /**
     * The product property
     */
    private ProductData product;
    /**
     * The status property
     */
    private String status;
    /**
     * Instantiates a new {@link BulkUpsertResultData} and sets the default values.
     */
    public BulkUpsertResultData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link BulkUpsertResultData}
     */
    @jakarta.annotation.Nonnull
    public static BulkUpsertResultData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new BulkUpsertResultData();
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
     * Gets the errors property value. Each rejected field and its messages. Absent when the item succeeded.
     * @return a {@link BulkUpsertResultDataErrors}
     */
    @jakarta.annotation.Nullable
    public BulkUpsertResultDataErrors getErrors() {
        return this.errors;
    }
    /**
     * Gets the external_id property value. The external_id property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getExternalId() {
        return this.externalId;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(5);
        deserializerMap.put("errors", (n) -> { this.setErrors(n.getObjectValue(BulkUpsertResultDataErrors::createFromDiscriminatorValue)); });
        deserializerMap.put("external_id", (n) -> { this.setExternalId(n.getStringValue()); });
        deserializerMap.put("index", (n) -> { this.setIndex(n.getIntegerValue()); });
        deserializerMap.put("product", (n) -> { this.setProduct(n.getObjectValue(ProductData::createFromDiscriminatorValue)); });
        deserializerMap.put("status", (n) -> { this.setStatus(n.getStringValue()); });
        return deserializerMap;
    }
    /**
     * Gets the index property value. The index property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getIndex() {
        return this.index;
    }
    /**
     * Gets the product property value. The product property
     * @return a {@link ProductData}
     */
    @jakarta.annotation.Nullable
    public ProductData getProduct() {
        return this.product;
    }
    /**
     * Gets the status property value. The status property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getStatus() {
        return this.status;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeObjectValue("errors", this.getErrors());
        writer.writeStringValue("external_id", this.getExternalId());
        writer.writeIntegerValue("index", this.getIndex());
        writer.writeObjectValue("product", this.getProduct());
        writer.writeStringValue("status", this.getStatus());
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
     * Sets the errors property value. Each rejected field and its messages. Absent when the item succeeded.
     * @param value Value to set for the errors property.
     */
    public void setErrors(@jakarta.annotation.Nullable final BulkUpsertResultDataErrors value) {
        this.errors = value;
    }
    /**
     * Sets the external_id property value. The external_id property
     * @param value Value to set for the external_id property.
     */
    public void setExternalId(@jakarta.annotation.Nullable final String value) {
        this.externalId = value;
    }
    /**
     * Sets the index property value. The index property
     * @param value Value to set for the index property.
     */
    public void setIndex(@jakarta.annotation.Nullable final Integer value) {
        this.index = value;
    }
    /**
     * Sets the product property value. The product property
     * @param value Value to set for the product property.
     */
    public void setProduct(@jakarta.annotation.Nullable final ProductData value) {
        this.product = value;
    }
    /**
     * Sets the status property value. The status property
     * @param value Value to set for the status property.
     */
    public void setStatus(@jakarta.annotation.Nullable final String value) {
        this.status = value;
    }
}
