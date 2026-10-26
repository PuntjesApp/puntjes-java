package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class CreateCustomerData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The customer_since property
     */
    private String customerSince;
    /**
     * The date_of_birth property
     */
    private String dateOfBirth;
    /**
     * The email property
     */
    private String email;
    /**
     * The external_id property
     */
    private String externalId;
    /**
     * The first_name property
     */
    private String firstName;
    /**
     * The groups property
     */
    private java.util.List<CustomerGroupReferenceData> groups;
    /**
     * The identifiers property
     */
    private java.util.List<CreateIdentifierData> identifiers;
    /**
     * The last_name property
     */
    private String lastName;
    /**
     * The locale property
     */
    private CreateCustomerDataLocale locale;
    /**
     * The marketing_consent property
     */
    private Boolean marketingConsent;
    /**
     * The marketing_consent_statement_version property
     */
    private String marketingConsentStatementVersion;
    /**
     * The phone property
     */
    private String phone;
    /**
     * Instantiates a new {@link CreateCustomerData} and sets the default values.
     */
    public CreateCustomerData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link CreateCustomerData}
     */
    @jakarta.annotation.Nonnull
    public static CreateCustomerData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new CreateCustomerData();
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
     * Gets the customer_since property value. The customer_since property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getCustomerSince() {
        return this.customerSince;
    }
    /**
     * Gets the date_of_birth property value. The date_of_birth property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }
    /**
     * Gets the email property value. The email property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getEmail() {
        return this.email;
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
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(12);
        deserializerMap.put("customer_since", (n) -> { this.setCustomerSince(n.getStringValue()); });
        deserializerMap.put("date_of_birth", (n) -> { this.setDateOfBirth(n.getStringValue()); });
        deserializerMap.put("email", (n) -> { this.setEmail(n.getStringValue()); });
        deserializerMap.put("external_id", (n) -> { this.setExternalId(n.getStringValue()); });
        deserializerMap.put("first_name", (n) -> { this.setFirstName(n.getStringValue()); });
        deserializerMap.put("groups", (n) -> { this.setGroups(n.getCollectionOfObjectValues(CustomerGroupReferenceData::createFromDiscriminatorValue)); });
        deserializerMap.put("identifiers", (n) -> { this.setIdentifiers(n.getCollectionOfObjectValues(CreateIdentifierData::createFromDiscriminatorValue)); });
        deserializerMap.put("last_name", (n) -> { this.setLastName(n.getStringValue()); });
        deserializerMap.put("locale", (n) -> { this.setLocale(n.getEnumValue(CreateCustomerDataLocale::forValue)); });
        deserializerMap.put("marketing_consent", (n) -> { this.setMarketingConsent(n.getBooleanValue()); });
        deserializerMap.put("marketing_consent_statement_version", (n) -> { this.setMarketingConsentStatementVersion(n.getStringValue()); });
        deserializerMap.put("phone", (n) -> { this.setPhone(n.getStringValue()); });
        return deserializerMap;
    }
    /**
     * Gets the first_name property value. The first_name property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getFirstName() {
        return this.firstName;
    }
    /**
     * Gets the groups property value. The groups property
     * @return a {@link java.util.List<CustomerGroupReferenceData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<CustomerGroupReferenceData> getGroups() {
        return this.groups;
    }
    /**
     * Gets the identifiers property value. The identifiers property
     * @return a {@link java.util.List<CreateIdentifierData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<CreateIdentifierData> getIdentifiers() {
        return this.identifiers;
    }
    /**
     * Gets the last_name property value. The last_name property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getLastName() {
        return this.lastName;
    }
    /**
     * Gets the locale property value. The locale property
     * @return a {@link CreateCustomerDataLocale}
     */
    @jakarta.annotation.Nullable
    public CreateCustomerDataLocale getLocale() {
        return this.locale;
    }
    /**
     * Gets the marketing_consent property value. The marketing_consent property
     * @return a {@link Boolean}
     */
    @jakarta.annotation.Nullable
    public Boolean getMarketingConsent() {
        return this.marketingConsent;
    }
    /**
     * Gets the marketing_consent_statement_version property value. The marketing_consent_statement_version property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getMarketingConsentStatementVersion() {
        return this.marketingConsentStatementVersion;
    }
    /**
     * Gets the phone property value. The phone property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getPhone() {
        return this.phone;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("customer_since", this.getCustomerSince());
        writer.writeStringValue("date_of_birth", this.getDateOfBirth());
        writer.writeStringValue("email", this.getEmail());
        writer.writeStringValue("external_id", this.getExternalId());
        writer.writeStringValue("first_name", this.getFirstName());
        writer.writeCollectionOfObjectValues("groups", this.getGroups());
        writer.writeCollectionOfObjectValues("identifiers", this.getIdentifiers());
        writer.writeStringValue("last_name", this.getLastName());
        writer.writeEnumValue("locale", this.getLocale());
        writer.writeBooleanValue("marketing_consent", this.getMarketingConsent());
        writer.writeStringValue("marketing_consent_statement_version", this.getMarketingConsentStatementVersion());
        writer.writeStringValue("phone", this.getPhone());
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
     * Sets the customer_since property value. The customer_since property
     * @param value Value to set for the customer_since property.
     */
    public void setCustomerSince(@jakarta.annotation.Nullable final String value) {
        this.customerSince = value;
    }
    /**
     * Sets the date_of_birth property value. The date_of_birth property
     * @param value Value to set for the date_of_birth property.
     */
    public void setDateOfBirth(@jakarta.annotation.Nullable final String value) {
        this.dateOfBirth = value;
    }
    /**
     * Sets the email property value. The email property
     * @param value Value to set for the email property.
     */
    public void setEmail(@jakarta.annotation.Nullable final String value) {
        this.email = value;
    }
    /**
     * Sets the external_id property value. The external_id property
     * @param value Value to set for the external_id property.
     */
    public void setExternalId(@jakarta.annotation.Nullable final String value) {
        this.externalId = value;
    }
    /**
     * Sets the first_name property value. The first_name property
     * @param value Value to set for the first_name property.
     */
    public void setFirstName(@jakarta.annotation.Nullable final String value) {
        this.firstName = value;
    }
    /**
     * Sets the groups property value. The groups property
     * @param value Value to set for the groups property.
     */
    public void setGroups(@jakarta.annotation.Nullable final java.util.List<CustomerGroupReferenceData> value) {
        this.groups = value;
    }
    /**
     * Sets the identifiers property value. The identifiers property
     * @param value Value to set for the identifiers property.
     */
    public void setIdentifiers(@jakarta.annotation.Nullable final java.util.List<CreateIdentifierData> value) {
        this.identifiers = value;
    }
    /**
     * Sets the last_name property value. The last_name property
     * @param value Value to set for the last_name property.
     */
    public void setLastName(@jakarta.annotation.Nullable final String value) {
        this.lastName = value;
    }
    /**
     * Sets the locale property value. The locale property
     * @param value Value to set for the locale property.
     */
    public void setLocale(@jakarta.annotation.Nullable final CreateCustomerDataLocale value) {
        this.locale = value;
    }
    /**
     * Sets the marketing_consent property value. The marketing_consent property
     * @param value Value to set for the marketing_consent property.
     */
    public void setMarketingConsent(@jakarta.annotation.Nullable final Boolean value) {
        this.marketingConsent = value;
    }
    /**
     * Sets the marketing_consent_statement_version property value. The marketing_consent_statement_version property
     * @param value Value to set for the marketing_consent_statement_version property.
     */
    public void setMarketingConsentStatementVersion(@jakarta.annotation.Nullable final String value) {
        this.marketingConsentStatementVersion = value;
    }
    /**
     * Sets the phone property value. The phone property
     * @param value Value to set for the phone property.
     */
    public void setPhone(@jakarta.annotation.Nullable final String value) {
        this.phone = value;
    }
}
