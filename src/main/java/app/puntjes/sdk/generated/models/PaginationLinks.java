package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class PaginationLinks implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The first property
     */
    private String first;
    /**
     * The last property
     */
    private String last;
    /**
     * The next property
     */
    private String next;
    /**
     * The prev property
     */
    private String prev;
    /**
     * Instantiates a new {@link PaginationLinks} and sets the default values.
     */
    public PaginationLinks() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link PaginationLinks}
     */
    @jakarta.annotation.Nonnull
    public static PaginationLinks createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new PaginationLinks();
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
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(4);
        deserializerMap.put("first", (n) -> { this.setFirst(n.getStringValue()); });
        deserializerMap.put("last", (n) -> { this.setLast(n.getStringValue()); });
        deserializerMap.put("next", (n) -> { this.setNext(n.getStringValue()); });
        deserializerMap.put("prev", (n) -> { this.setPrev(n.getStringValue()); });
        return deserializerMap;
    }
    /**
     * Gets the first property value. The first property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getFirst() {
        return this.first;
    }
    /**
     * Gets the last property value. The last property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getLast() {
        return this.last;
    }
    /**
     * Gets the next property value. The next property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getNext() {
        return this.next;
    }
    /**
     * Gets the prev property value. The prev property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getPrev() {
        return this.prev;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("first", this.getFirst());
        writer.writeStringValue("last", this.getLast());
        writer.writeStringValue("next", this.getNext());
        writer.writeStringValue("prev", this.getPrev());
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
     * Sets the first property value. The first property
     * @param value Value to set for the first property.
     */
    public void setFirst(@jakarta.annotation.Nullable final String value) {
        this.first = value;
    }
    /**
     * Sets the last property value. The last property
     * @param value Value to set for the last property.
     */
    public void setLast(@jakarta.annotation.Nullable final String value) {
        this.last = value;
    }
    /**
     * Sets the next property value. The next property
     * @param value Value to set for the next property.
     */
    public void setNext(@jakarta.annotation.Nullable final String value) {
        this.next = value;
    }
    /**
     * Sets the prev property value. The prev property
     * @param value Value to set for the prev property.
     */
    public void setPrev(@jakarta.annotation.Nullable final String value) {
        this.prev = value;
    }
}
