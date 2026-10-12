package app.puntjes.sdk.generated.customers.item.redemptions;

import app.puntjes.sdk.generated.models.PaginationLinks;
import app.puntjes.sdk.generated.models.PaginationMeta;
import app.puntjes.sdk.generated.models.RedemptionLookupData;
import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class RedemptionsGetResponseData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The data property
     */
    private java.util.List<RedemptionLookupData> data;
    /**
     * The links property
     */
    private PaginationLinks links;
    /**
     * The meta property
     */
    private PaginationMeta meta;
    /**
     * Instantiates a new {@link RedemptionsGetResponseData} and sets the default values.
     */
    public RedemptionsGetResponseData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link RedemptionsGetResponseData}
     */
    @jakarta.annotation.Nonnull
    public static RedemptionsGetResponseData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new RedemptionsGetResponseData();
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
     * Gets the data property value. The data property
     * @return a {@link java.util.List<RedemptionLookupData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<RedemptionLookupData> getData() {
        return this.data;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(3);
        deserializerMap.put("data", (n) -> { this.setData(n.getCollectionOfObjectValues(RedemptionLookupData::createFromDiscriminatorValue)); });
        deserializerMap.put("links", (n) -> { this.setLinks(n.getObjectValue(PaginationLinks::createFromDiscriminatorValue)); });
        deserializerMap.put("meta", (n) -> { this.setMeta(n.getObjectValue(PaginationMeta::createFromDiscriminatorValue)); });
        return deserializerMap;
    }
    /**
     * Gets the links property value. The links property
     * @return a {@link PaginationLinks}
     */
    @jakarta.annotation.Nullable
    public PaginationLinks getLinks() {
        return this.links;
    }
    /**
     * Gets the meta property value. The meta property
     * @return a {@link PaginationMeta}
     */
    @jakarta.annotation.Nullable
    public PaginationMeta getMeta() {
        return this.meta;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeCollectionOfObjectValues("data", this.getData());
        writer.writeObjectValue("links", this.getLinks());
        writer.writeObjectValue("meta", this.getMeta());
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
     * Sets the data property value. The data property
     * @param value Value to set for the data property.
     */
    public void setData(@jakarta.annotation.Nullable final java.util.List<RedemptionLookupData> value) {
        this.data = value;
    }
    /**
     * Sets the links property value. The links property
     * @param value Value to set for the links property.
     */
    public void setLinks(@jakarta.annotation.Nullable final PaginationLinks value) {
        this.links = value;
    }
    /**
     * Sets the meta property value. The meta property
     * @param value Value to set for the meta property.
     */
    public void setMeta(@jakarta.annotation.Nullable final PaginationMeta value) {
        this.meta = value;
    }
}
