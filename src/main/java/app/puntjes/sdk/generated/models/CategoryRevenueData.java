package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class CategoryRevenueData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The category property
     */
    private String category;
    /**
     * The isOther property
     */
    private Boolean isOther;
    /**
     * The revenue property
     */
    private Integer revenue;
    /**
     * The units property
     */
    private Integer units;
    /**
     * Instantiates a new {@link CategoryRevenueData} and sets the default values.
     */
    public CategoryRevenueData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link CategoryRevenueData}
     */
    @jakarta.annotation.Nonnull
    public static CategoryRevenueData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new CategoryRevenueData();
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
     * Gets the category property value. The category property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getCategory() {
        return this.category;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(4);
        deserializerMap.put("category", (n) -> { this.setCategory(n.getStringValue()); });
        deserializerMap.put("isOther", (n) -> { this.setIsOther(n.getBooleanValue()); });
        deserializerMap.put("revenue", (n) -> { this.setRevenue(n.getIntegerValue()); });
        deserializerMap.put("units", (n) -> { this.setUnits(n.getIntegerValue()); });
        return deserializerMap;
    }
    /**
     * Gets the isOther property value. The isOther property
     * @return a {@link Boolean}
     */
    @jakarta.annotation.Nullable
    public Boolean getIsOther() {
        return this.isOther;
    }
    /**
     * Gets the revenue property value. The revenue property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getRevenue() {
        return this.revenue;
    }
    /**
     * Gets the units property value. The units property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getUnits() {
        return this.units;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("category", this.getCategory());
        writer.writeBooleanValue("isOther", this.getIsOther());
        writer.writeIntegerValue("revenue", this.getRevenue());
        writer.writeIntegerValue("units", this.getUnits());
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
     * Sets the category property value. The category property
     * @param value Value to set for the category property.
     */
    public void setCategory(@jakarta.annotation.Nullable final String value) {
        this.category = value;
    }
    /**
     * Sets the isOther property value. The isOther property
     * @param value Value to set for the isOther property.
     */
    public void setIsOther(@jakarta.annotation.Nullable final Boolean value) {
        this.isOther = value;
    }
    /**
     * Sets the revenue property value. The revenue property
     * @param value Value to set for the revenue property.
     */
    public void setRevenue(@jakarta.annotation.Nullable final Integer value) {
        this.revenue = value;
    }
    /**
     * Sets the units property value. The units property
     * @param value Value to set for the units property.
     */
    public void setUnits(@jakarta.annotation.Nullable final Integer value) {
        this.units = value;
    }
}
