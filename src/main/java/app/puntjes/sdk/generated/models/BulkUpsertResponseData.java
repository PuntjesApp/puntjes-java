package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class BulkUpsertResponseData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The results property
     */
    private java.util.List<BulkUpsertResultData> results;
    /**
     * The summary property
     */
    private BulkUpsertSummaryData summary;
    /**
     * Instantiates a new {@link BulkUpsertResponseData} and sets the default values.
     */
    public BulkUpsertResponseData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link BulkUpsertResponseData}
     */
    @jakarta.annotation.Nonnull
    public static BulkUpsertResponseData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new BulkUpsertResponseData();
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
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(2);
        deserializerMap.put("results", (n) -> { this.setResults(n.getCollectionOfObjectValues(BulkUpsertResultData::createFromDiscriminatorValue)); });
        deserializerMap.put("summary", (n) -> { this.setSummary(n.getObjectValue(BulkUpsertSummaryData::createFromDiscriminatorValue)); });
        return deserializerMap;
    }
    /**
     * Gets the results property value. The results property
     * @return a {@link java.util.List<BulkUpsertResultData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<BulkUpsertResultData> getResults() {
        return this.results;
    }
    /**
     * Gets the summary property value. The summary property
     * @return a {@link BulkUpsertSummaryData}
     */
    @jakarta.annotation.Nullable
    public BulkUpsertSummaryData getSummary() {
        return this.summary;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeCollectionOfObjectValues("results", this.getResults());
        writer.writeObjectValue("summary", this.getSummary());
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
     * Sets the results property value. The results property
     * @param value Value to set for the results property.
     */
    public void setResults(@jakarta.annotation.Nullable final java.util.List<BulkUpsertResultData> value) {
        this.results = value;
    }
    /**
     * Sets the summary property value. The summary property
     * @param value Value to set for the summary property.
     */
    public void setSummary(@jakarta.annotation.Nullable final BulkUpsertSummaryData value) {
        this.summary = value;
    }
}
