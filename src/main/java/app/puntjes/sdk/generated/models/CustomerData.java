package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class CustomerData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The anonymized_at property
     */
    private String anonymizedAt;
    /**
     * The created_at property
     */
    private String createdAt;
    /**
     * The customer_since property
     */
    private String customerSince;
    /**
     * The date_of_birth property
     */
    private String dateOfBirth;
    /**
     * The deactivated_at property
     */
    private String deactivatedAt;
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
     * The customer&apos;s groups, sorted by name, then by external_id.
     */
    private java.util.List<CustomerGroupReferenceData> groups;
    /**
     * The id property
     */
    private Integer id;
    /**
     * The identifiers property
     */
    private java.util.List<CustomerIdentifierData> identifiers;
    /**
     * The last_name property
     */
    private String lastName;
    /**
     * The locale property
     */
    private String locale;
    /**
     * The loyalty_card_code property
     */
    private String loyaltyCardCode;
    /**
     * The marketingConsent property
     */
    private Boolean marketingConsent;
    /**
     * The marketingConsentGrantedAt property
     */
    private String marketingConsentGrantedAt;
    /**
     * The marketingConsentGrantedSource property
     */
    private String marketingConsentGrantedSource;
    /**
     * The marketingConsentRecordedBy property
     */
    private String marketingConsentRecordedBy;
    /**
     * The marketingConsentRecordedByClientId property
     */
    private String marketingConsentRecordedByClientId;
    /**
     * The marketingConsentStatementVersion property
     */
    private String marketingConsentStatementVersion;
    /**
     * The marketingConsentWithdrawnAt property
     */
    private String marketingConsentWithdrawnAt;
    /**
     * The marketingConsentWithdrawnSource property
     */
    private String marketingConsentWithdrawnSource;
    /**
     * The phone property
     */
    private String phone;
    /**
     * The status property
     */
    private CustomerStatusData status;
    /**
     * The updated_at property
     */
    private String updatedAt;
    /**
     * Instantiates a new {@link CustomerData} and sets the default values.
     */
    public CustomerData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link CustomerData}
     */
    @jakarta.annotation.Nonnull
    public static CustomerData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new CustomerData();
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
     * Gets the anonymized_at property value. The anonymized_at property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getAnonymizedAt() {
        return this.anonymizedAt;
    }
    /**
     * Gets the created_at property value. The created_at property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getCreatedAt() {
        return this.createdAt;
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
     * Gets the deactivated_at property value. The deactivated_at property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getDeactivatedAt() {
        return this.deactivatedAt;
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
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(25);
        deserializerMap.put("anonymized_at", (n) -> { this.setAnonymizedAt(n.getStringValue()); });
        deserializerMap.put("created_at", (n) -> { this.setCreatedAt(n.getStringValue()); });
        deserializerMap.put("customer_since", (n) -> { this.setCustomerSince(n.getStringValue()); });
        deserializerMap.put("date_of_birth", (n) -> { this.setDateOfBirth(n.getStringValue()); });
        deserializerMap.put("deactivated_at", (n) -> { this.setDeactivatedAt(n.getStringValue()); });
        deserializerMap.put("email", (n) -> { this.setEmail(n.getStringValue()); });
        deserializerMap.put("external_id", (n) -> { this.setExternalId(n.getStringValue()); });
        deserializerMap.put("first_name", (n) -> { this.setFirstName(n.getStringValue()); });
        deserializerMap.put("groups", (n) -> { this.setGroups(n.getCollectionOfObjectValues(CustomerGroupReferenceData::createFromDiscriminatorValue)); });
        deserializerMap.put("id", (n) -> { this.setId(n.getIntegerValue()); });
        deserializerMap.put("identifiers", (n) -> { this.setIdentifiers(n.getCollectionOfObjectValues(CustomerIdentifierData::createFromDiscriminatorValue)); });
        deserializerMap.put("last_name", (n) -> { this.setLastName(n.getStringValue()); });
        deserializerMap.put("locale", (n) -> { this.setLocale(n.getStringValue()); });
        deserializerMap.put("loyalty_card_code", (n) -> { this.setLoyaltyCardCode(n.getStringValue()); });
        deserializerMap.put("marketingConsent", (n) -> { this.setMarketingConsent(n.getBooleanValue()); });
        deserializerMap.put("marketingConsentGrantedAt", (n) -> { this.setMarketingConsentGrantedAt(n.getStringValue()); });
        deserializerMap.put("marketingConsentGrantedSource", (n) -> { this.setMarketingConsentGrantedSource(n.getStringValue()); });
        deserializerMap.put("marketingConsentRecordedBy", (n) -> { this.setMarketingConsentRecordedBy(n.getStringValue()); });
        deserializerMap.put("marketingConsentRecordedByClientId", (n) -> { this.setMarketingConsentRecordedByClientId(n.getStringValue()); });
        deserializerMap.put("marketingConsentStatementVersion", (n) -> { this.setMarketingConsentStatementVersion(n.getStringValue()); });
        deserializerMap.put("marketingConsentWithdrawnAt", (n) -> { this.setMarketingConsentWithdrawnAt(n.getStringValue()); });
        deserializerMap.put("marketingConsentWithdrawnSource", (n) -> { this.setMarketingConsentWithdrawnSource(n.getStringValue()); });
        deserializerMap.put("phone", (n) -> { this.setPhone(n.getStringValue()); });
        deserializerMap.put("status", (n) -> { this.setStatus(n.getObjectValue(CustomerStatusData::createFromDiscriminatorValue)); });
        deserializerMap.put("updated_at", (n) -> { this.setUpdatedAt(n.getStringValue()); });
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
     * Gets the groups property value. The customer&apos;s groups, sorted by name, then by external_id.
     * @return a {@link java.util.List<CustomerGroupReferenceData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<CustomerGroupReferenceData> getGroups() {
        return this.groups;
    }
    /**
     * Gets the id property value. The id property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getId() {
        return this.id;
    }
    /**
     * Gets the identifiers property value. The identifiers property
     * @return a {@link java.util.List<CustomerIdentifierData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<CustomerIdentifierData> getIdentifiers() {
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
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getLocale() {
        return this.locale;
    }
    /**
     * Gets the loyalty_card_code property value. The loyalty_card_code property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getLoyaltyCardCode() {
        return this.loyaltyCardCode;
    }
    /**
     * Gets the marketingConsent property value. The marketingConsent property
     * @return a {@link Boolean}
     */
    @jakarta.annotation.Nullable
    public Boolean getMarketingConsent() {
        return this.marketingConsent;
    }
    /**
     * Gets the marketingConsentGrantedAt property value. The marketingConsentGrantedAt property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getMarketingConsentGrantedAt() {
        return this.marketingConsentGrantedAt;
    }
    /**
     * Gets the marketingConsentGrantedSource property value. The marketingConsentGrantedSource property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getMarketingConsentGrantedSource() {
        return this.marketingConsentGrantedSource;
    }
    /**
     * Gets the marketingConsentRecordedBy property value. The marketingConsentRecordedBy property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getMarketingConsentRecordedBy() {
        return this.marketingConsentRecordedBy;
    }
    /**
     * Gets the marketingConsentRecordedByClientId property value. The marketingConsentRecordedByClientId property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getMarketingConsentRecordedByClientId() {
        return this.marketingConsentRecordedByClientId;
    }
    /**
     * Gets the marketingConsentStatementVersion property value. The marketingConsentStatementVersion property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getMarketingConsentStatementVersion() {
        return this.marketingConsentStatementVersion;
    }
    /**
     * Gets the marketingConsentWithdrawnAt property value. The marketingConsentWithdrawnAt property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getMarketingConsentWithdrawnAt() {
        return this.marketingConsentWithdrawnAt;
    }
    /**
     * Gets the marketingConsentWithdrawnSource property value. The marketingConsentWithdrawnSource property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getMarketingConsentWithdrawnSource() {
        return this.marketingConsentWithdrawnSource;
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
     * Gets the status property value. The status property
     * @return a {@link CustomerStatusData}
     */
    @jakarta.annotation.Nullable
    public CustomerStatusData getStatus() {
        return this.status;
    }
    /**
     * Gets the updated_at property value. The updated_at property
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getUpdatedAt() {
        return this.updatedAt;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("anonymized_at", this.getAnonymizedAt());
        writer.writeStringValue("created_at", this.getCreatedAt());
        writer.writeStringValue("customer_since", this.getCustomerSince());
        writer.writeStringValue("date_of_birth", this.getDateOfBirth());
        writer.writeStringValue("deactivated_at", this.getDeactivatedAt());
        writer.writeStringValue("email", this.getEmail());
        writer.writeStringValue("external_id", this.getExternalId());
        writer.writeStringValue("first_name", this.getFirstName());
        writer.writeCollectionOfObjectValues("groups", this.getGroups());
        writer.writeIntegerValue("id", this.getId());
        writer.writeCollectionOfObjectValues("identifiers", this.getIdentifiers());
        writer.writeStringValue("last_name", this.getLastName());
        writer.writeStringValue("locale", this.getLocale());
        writer.writeStringValue("loyalty_card_code", this.getLoyaltyCardCode());
        writer.writeBooleanValue("marketingConsent", this.getMarketingConsent());
        writer.writeStringValue("marketingConsentGrantedAt", this.getMarketingConsentGrantedAt());
        writer.writeStringValue("marketingConsentGrantedSource", this.getMarketingConsentGrantedSource());
        writer.writeStringValue("marketingConsentRecordedBy", this.getMarketingConsentRecordedBy());
        writer.writeStringValue("marketingConsentRecordedByClientId", this.getMarketingConsentRecordedByClientId());
        writer.writeStringValue("marketingConsentStatementVersion", this.getMarketingConsentStatementVersion());
        writer.writeStringValue("marketingConsentWithdrawnAt", this.getMarketingConsentWithdrawnAt());
        writer.writeStringValue("marketingConsentWithdrawnSource", this.getMarketingConsentWithdrawnSource());
        writer.writeStringValue("phone", this.getPhone());
        writer.writeObjectValue("status", this.getStatus());
        writer.writeStringValue("updated_at", this.getUpdatedAt());
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
     * Sets the anonymized_at property value. The anonymized_at property
     * @param value Value to set for the anonymized_at property.
     */
    public void setAnonymizedAt(@jakarta.annotation.Nullable final String value) {
        this.anonymizedAt = value;
    }
    /**
     * Sets the created_at property value. The created_at property
     * @param value Value to set for the created_at property.
     */
    public void setCreatedAt(@jakarta.annotation.Nullable final String value) {
        this.createdAt = value;
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
     * Sets the deactivated_at property value. The deactivated_at property
     * @param value Value to set for the deactivated_at property.
     */
    public void setDeactivatedAt(@jakarta.annotation.Nullable final String value) {
        this.deactivatedAt = value;
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
     * Sets the groups property value. The customer&apos;s groups, sorted by name, then by external_id.
     * @param value Value to set for the groups property.
     */
    public void setGroups(@jakarta.annotation.Nullable final java.util.List<CustomerGroupReferenceData> value) {
        this.groups = value;
    }
    /**
     * Sets the id property value. The id property
     * @param value Value to set for the id property.
     */
    public void setId(@jakarta.annotation.Nullable final Integer value) {
        this.id = value;
    }
    /**
     * Sets the identifiers property value. The identifiers property
     * @param value Value to set for the identifiers property.
     */
    public void setIdentifiers(@jakarta.annotation.Nullable final java.util.List<CustomerIdentifierData> value) {
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
    public void setLocale(@jakarta.annotation.Nullable final String value) {
        this.locale = value;
    }
    /**
     * Sets the loyalty_card_code property value. The loyalty_card_code property
     * @param value Value to set for the loyalty_card_code property.
     */
    public void setLoyaltyCardCode(@jakarta.annotation.Nullable final String value) {
        this.loyaltyCardCode = value;
    }
    /**
     * Sets the marketingConsent property value. The marketingConsent property
     * @param value Value to set for the marketingConsent property.
     */
    public void setMarketingConsent(@jakarta.annotation.Nullable final Boolean value) {
        this.marketingConsent = value;
    }
    /**
     * Sets the marketingConsentGrantedAt property value. The marketingConsentGrantedAt property
     * @param value Value to set for the marketingConsentGrantedAt property.
     */
    public void setMarketingConsentGrantedAt(@jakarta.annotation.Nullable final String value) {
        this.marketingConsentGrantedAt = value;
    }
    /**
     * Sets the marketingConsentGrantedSource property value. The marketingConsentGrantedSource property
     * @param value Value to set for the marketingConsentGrantedSource property.
     */
    public void setMarketingConsentGrantedSource(@jakarta.annotation.Nullable final String value) {
        this.marketingConsentGrantedSource = value;
    }
    /**
     * Sets the marketingConsentRecordedBy property value. The marketingConsentRecordedBy property
     * @param value Value to set for the marketingConsentRecordedBy property.
     */
    public void setMarketingConsentRecordedBy(@jakarta.annotation.Nullable final String value) {
        this.marketingConsentRecordedBy = value;
    }
    /**
     * Sets the marketingConsentRecordedByClientId property value. The marketingConsentRecordedByClientId property
     * @param value Value to set for the marketingConsentRecordedByClientId property.
     */
    public void setMarketingConsentRecordedByClientId(@jakarta.annotation.Nullable final String value) {
        this.marketingConsentRecordedByClientId = value;
    }
    /**
     * Sets the marketingConsentStatementVersion property value. The marketingConsentStatementVersion property
     * @param value Value to set for the marketingConsentStatementVersion property.
     */
    public void setMarketingConsentStatementVersion(@jakarta.annotation.Nullable final String value) {
        this.marketingConsentStatementVersion = value;
    }
    /**
     * Sets the marketingConsentWithdrawnAt property value. The marketingConsentWithdrawnAt property
     * @param value Value to set for the marketingConsentWithdrawnAt property.
     */
    public void setMarketingConsentWithdrawnAt(@jakarta.annotation.Nullable final String value) {
        this.marketingConsentWithdrawnAt = value;
    }
    /**
     * Sets the marketingConsentWithdrawnSource property value. The marketingConsentWithdrawnSource property
     * @param value Value to set for the marketingConsentWithdrawnSource property.
     */
    public void setMarketingConsentWithdrawnSource(@jakarta.annotation.Nullable final String value) {
        this.marketingConsentWithdrawnSource = value;
    }
    /**
     * Sets the phone property value. The phone property
     * @param value Value to set for the phone property.
     */
    public void setPhone(@jakarta.annotation.Nullable final String value) {
        this.phone = value;
    }
    /**
     * Sets the status property value. The status property
     * @param value Value to set for the status property.
     */
    public void setStatus(@jakarta.annotation.Nullable final CustomerStatusData value) {
        this.status = value;
    }
    /**
     * Sets the updated_at property value. The updated_at property
     * @param value Value to set for the updated_at property.
     */
    public void setUpdatedAt(@jakarta.annotation.Nullable final String value) {
        this.updatedAt = value;
    }
}
