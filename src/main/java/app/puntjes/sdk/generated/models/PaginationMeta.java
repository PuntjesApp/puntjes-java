package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class PaginationMeta implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The current_page property
     */
    private Integer currentPage;
    /**
     * The last_page property
     */
    private Integer lastPage;
    /**
     * The per_page property
     */
    private Integer perPage;
    /**
     * The total property
     */
    private Integer total;
    /**
     * Instantiates a new {@link PaginationMeta} and sets the default values.
     */
    public PaginationMeta() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link PaginationMeta}
     */
    @jakarta.annotation.Nonnull
    public static PaginationMeta createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new PaginationMeta();
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
     * Gets the current_page property value. The current_page property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getCurrentPage() {
        return this.currentPage;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(4);
        deserializerMap.put("current_page", (n) -> { this.setCurrentPage(n.getIntegerValue()); });
        deserializerMap.put("last_page", (n) -> { this.setLastPage(n.getIntegerValue()); });
        deserializerMap.put("per_page", (n) -> { this.setPerPage(n.getIntegerValue()); });
        deserializerMap.put("total", (n) -> { this.setTotal(n.getIntegerValue()); });
        return deserializerMap;
    }
    /**
     * Gets the last_page property value. The last_page property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getLastPage() {
        return this.lastPage;
    }
    /**
     * Gets the per_page property value. The per_page property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getPerPage() {
        return this.perPage;
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
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeIntegerValue("current_page", this.getCurrentPage());
        writer.writeIntegerValue("last_page", this.getLastPage());
        writer.writeIntegerValue("per_page", this.getPerPage());
        writer.writeIntegerValue("total", this.getTotal());
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
     * Sets the current_page property value. The current_page property
     * @param value Value to set for the current_page property.
     */
    public void setCurrentPage(@jakarta.annotation.Nullable final Integer value) {
        this.currentPage = value;
    }
    /**
     * Sets the last_page property value. The last_page property
     * @param value Value to set for the last_page property.
     */
    public void setLastPage(@jakarta.annotation.Nullable final Integer value) {
        this.lastPage = value;
    }
    /**
     * Sets the per_page property value. The per_page property
     * @param value Value to set for the per_page property.
     */
    public void setPerPage(@jakarta.annotation.Nullable final Integer value) {
        this.perPage = value;
    }
    /**
     * Sets the total property value. The total property
     * @param value Value to set for the total property.
     */
    public void setTotal(@jakarta.annotation.Nullable final Integer value) {
        this.total = value;
    }
}
