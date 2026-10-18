package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class VendorBrandingData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The brand_color_accent property
     */
    private String brandColorAccent;
    /**
     * The brand_color_primary property
     */
    private String brandColorPrimary;
    /**
     * The default_branch property
     */
    private BranchReferenceData defaultBranch;
    /**
     * The display_name property
     */
    private String displayName;
    /**
     * The logo_url property
     */
    private String logoUrl;
    /**
     * Instantiates a new {@link VendorBrandingData} and sets the default values.
     */
    public VendorBrandingData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link VendorBrandingData}
     */
    @jakarta.annotation.Nonnull
    public static VendorBrandingData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new VendorBrandingData();
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
     * Gets the brand_color_accent property value. The brand_color_accent property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getBrandColorAccent() {
        return this.brandColorAccent;
    }
    /**
     * Gets the brand_color_primary property value. The brand_color_primary property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getBrandColorPrimary() {
        return this.brandColorPrimary;
    }
    /**
     * Gets the default_branch property value. The default_branch property
     * @return a {@link BranchReferenceData}
     */
    @jakarta.annotation.Nullable
    public BranchReferenceData getDefaultBranch() {
        return this.defaultBranch;
    }
    /**
     * Gets the display_name property value. The display_name property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getDisplayName() {
        return this.displayName;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(5);
        deserializerMap.put("brand_color_accent", (n) -> { this.setBrandColorAccent(n.getStringValue()); });
        deserializerMap.put("brand_color_primary", (n) -> { this.setBrandColorPrimary(n.getStringValue()); });
        deserializerMap.put("default_branch", (n) -> { this.setDefaultBranch(n.getObjectValue(BranchReferenceData::createFromDiscriminatorValue)); });
        deserializerMap.put("display_name", (n) -> { this.setDisplayName(n.getStringValue()); });
        deserializerMap.put("logo_url", (n) -> { this.setLogoUrl(n.getStringValue()); });
        return deserializerMap;
    }
    /**
     * Gets the logo_url property value. The logo_url property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getLogoUrl() {
        return this.logoUrl;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("brand_color_accent", this.getBrandColorAccent());
        writer.writeStringValue("brand_color_primary", this.getBrandColorPrimary());
        writer.writeObjectValue("default_branch", this.getDefaultBranch());
        writer.writeStringValue("display_name", this.getDisplayName());
        writer.writeStringValue("logo_url", this.getLogoUrl());
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
     * Sets the brand_color_accent property value. The brand_color_accent property
     * @param value Value to set for the brand_color_accent property.
     */
    public void setBrandColorAccent(@jakarta.annotation.Nullable final String value) {
        this.brandColorAccent = value;
    }
    /**
     * Sets the brand_color_primary property value. The brand_color_primary property
     * @param value Value to set for the brand_color_primary property.
     */
    public void setBrandColorPrimary(@jakarta.annotation.Nullable final String value) {
        this.brandColorPrimary = value;
    }
    /**
     * Sets the default_branch property value. The default_branch property
     * @param value Value to set for the default_branch property.
     */
    public void setDefaultBranch(@jakarta.annotation.Nullable final BranchReferenceData value) {
        this.defaultBranch = value;
    }
    /**
     * Sets the display_name property value. The display_name property
     * @param value Value to set for the display_name property.
     */
    public void setDisplayName(@jakarta.annotation.Nullable final String value) {
        this.displayName = value;
    }
    /**
     * Sets the logo_url property value. The logo_url property
     * @param value Value to set for the logo_url property.
     */
    public void setLogoUrl(@jakarta.annotation.Nullable final String value) {
        this.logoUrl = value;
    }
}
