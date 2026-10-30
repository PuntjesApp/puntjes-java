package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class PartnerApiClientData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The branch property
     */
    private BranchReferenceData branch;
    /**
     * The `client_id` for `POST /oauth/token`.
     */
    private String clientId;
    /**
     * The `client_secret` for `POST /oauth/token`.
     */
    private String clientSecret;
    /**
     * The vendor that allowed the connection.
     */
    private PartnerApiClientDataVendor vendor;
    /**
     * Instantiates a new {@link PartnerApiClientData} and sets the default values.
     */
    public PartnerApiClientData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link PartnerApiClientData}
     */
    @jakarta.annotation.Nonnull
    public static PartnerApiClientData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new PartnerApiClientData();
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
     * Gets the branch property value. The branch property
     * @return a {@link BranchReferenceData}
     */
    @jakarta.annotation.Nullable
    public BranchReferenceData getBranch() {
        return this.branch;
    }
    /**
     * Gets the client_id property value. The `client_id` for `POST /oauth/token`.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getClientId() {
        return this.clientId;
    }
    /**
     * Gets the client_secret property value. The `client_secret` for `POST /oauth/token`.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getClientSecret() {
        return this.clientSecret;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(4);
        deserializerMap.put("branch", (n) -> { this.setBranch(n.getObjectValue(BranchReferenceData::createFromDiscriminatorValue)); });
        deserializerMap.put("client_id", (n) -> { this.setClientId(n.getStringValue()); });
        deserializerMap.put("client_secret", (n) -> { this.setClientSecret(n.getStringValue()); });
        deserializerMap.put("vendor", (n) -> { this.setVendor(n.getObjectValue(PartnerApiClientDataVendor::createFromDiscriminatorValue)); });
        return deserializerMap;
    }
    /**
     * Gets the vendor property value. The vendor that allowed the connection.
     * @return a {@link PartnerApiClientDataVendor}
     */
    @jakarta.annotation.Nullable
    public PartnerApiClientDataVendor getVendor() {
        return this.vendor;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeObjectValue("branch", this.getBranch());
        writer.writeStringValue("client_id", this.getClientId());
        writer.writeStringValue("client_secret", this.getClientSecret());
        writer.writeObjectValue("vendor", this.getVendor());
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
     * Sets the branch property value. The branch property
     * @param value Value to set for the branch property.
     */
    public void setBranch(@jakarta.annotation.Nullable final BranchReferenceData value) {
        this.branch = value;
    }
    /**
     * Sets the client_id property value. The `client_id` for `POST /oauth/token`.
     * @param value Value to set for the client_id property.
     */
    public void setClientId(@jakarta.annotation.Nullable final String value) {
        this.clientId = value;
    }
    /**
     * Sets the client_secret property value. The `client_secret` for `POST /oauth/token`.
     * @param value Value to set for the client_secret property.
     */
    public void setClientSecret(@jakarta.annotation.Nullable final String value) {
        this.clientSecret = value;
    }
    /**
     * Sets the vendor property value. The vendor that allowed the connection.
     * @param value Value to set for the vendor property.
     */
    public void setVendor(@jakarta.annotation.Nullable final PartnerApiClientDataVendor value) {
        this.vendor = value;
    }
}
