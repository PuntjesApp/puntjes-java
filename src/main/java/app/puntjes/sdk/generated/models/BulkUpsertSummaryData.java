package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class BulkUpsertSummaryData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The created property
     */
    private Integer created;
    /**
     * The failed property
     */
    private Integer failed;
    /**
     * The total property
     */
    private Integer total;
    /**
     * The updated property
     */
    private Integer updated;
    /**
     * Instantiates a new {@link BulkUpsertSummaryData} and sets the default values.
     */
    public BulkUpsertSummaryData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link BulkUpsertSummaryData}
     */
    @jakarta.annotation.Nonnull
    public static BulkUpsertSummaryData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new BulkUpsertSummaryData();
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
     * Gets the created property value. The created property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getCreated() {
        return this.created;
    }
    /**
     * Gets the failed property value. The failed property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getFailed() {
        return this.failed;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(4);
        deserializerMap.put("created", (n) -> { this.setCreated(n.getIntegerValue()); });
        deserializerMap.put("failed", (n) -> { this.setFailed(n.getIntegerValue()); });
        deserializerMap.put("total", (n) -> { this.setTotal(n.getIntegerValue()); });
        deserializerMap.put("updated", (n) -> { this.setUpdated(n.getIntegerValue()); });
        return deserializerMap;
    }
    /**
     * Gets the total property value. The total property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getTotal() {
        return this.total;
    }
    /**
     * Gets the updated property value. The updated property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getUpdated() {
        return this.updated;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeIntegerValue("created", this.getCreated());
        writer.writeIntegerValue("failed", this.getFailed());
        writer.writeIntegerValue("total", this.getTotal());
        writer.writeIntegerValue("updated", this.getUpdated());
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
     * Sets the created property value. The created property
     * @param value Value to set for the created property.
     */
    public void setCreated(@jakarta.annotation.Nullable final Integer value) {
        this.created = value;
    }
    /**
     * Sets the failed property value. The failed property
     * @param value Value to set for the failed property.
     */
    public void setFailed(@jakarta.annotation.Nullable final Integer value) {
        this.failed = value;
    }
    /**
     * Sets the total property value. The total property
     * @param value Value to set for the total property.
     */
    public void setTotal(@jakarta.annotation.Nullable final Integer value) {
        this.total = value;
    }
    /**
     * Sets the updated property value. The updated property
     * @param value Value to set for the updated property.
     */
    public void setUpdated(@jakarta.annotation.Nullable final Integer value) {
        this.updated = value;
    }
}
