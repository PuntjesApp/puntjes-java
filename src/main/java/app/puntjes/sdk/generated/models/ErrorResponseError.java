package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class ErrorResponseError implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The machine-readable code to branch on.
     */
    private String code;
    /**
     * Extra context for this failure. A validation error puts each rejected field and its messages here.
     */
    private ErrorResponseErrorDetails details;
    /**
     * What went wrong, in words.
     */
    private String message;
    /**
     * Identifies this request in our logs. Quote it when you report a problem.
     */
    private String requestId;
    /**
     * The HTTP status, repeated in the body.
     */
    private Integer status;
    /**
     * Instantiates a new {@link ErrorResponseError} and sets the default values.
     */
    public ErrorResponseError() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link ErrorResponseError}
     */
    @jakarta.annotation.Nonnull
    public static ErrorResponseError createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new ErrorResponseError();
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
     * Gets the code property value. The machine-readable code to branch on.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getCode() {
        return this.code;
    }
    /**
     * Gets the details property value. Extra context for this failure. A validation error puts each rejected field and its messages here.
     * @return a {@link ErrorResponseErrorDetails}
     */
    @jakarta.annotation.Nullable
    public ErrorResponseErrorDetails getDetails() {
        return this.details;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(5);
        deserializerMap.put("code", (n) -> { this.setCode(n.getStringValue()); });
        deserializerMap.put("details", (n) -> { this.setDetails(n.getObjectValue(ErrorResponseErrorDetails::createFromDiscriminatorValue)); });
        deserializerMap.put("message", (n) -> { this.setMessage(n.getStringValue()); });
        deserializerMap.put("request_id", (n) -> { this.setRequestId(n.getStringValue()); });
        deserializerMap.put("status", (n) -> { this.setStatus(n.getIntegerValue()); });
        return deserializerMap;
    }
    /**
     * Gets the message property value. What went wrong, in words.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getMessage() {
        return this.message;
    }
    /**
     * Gets the request_id property value. Identifies this request in our logs. Quote it when you report a problem.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getRequestId() {
        return this.requestId;
    }
    /**
     * Gets the status property value. The HTTP status, repeated in the body.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getStatus() {
        return this.status;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeStringValue("code", this.getCode());
        writer.writeObjectValue("details", this.getDetails());
        writer.writeStringValue("message", this.getMessage());
        writer.writeStringValue("request_id", this.getRequestId());
        writer.writeIntegerValue("status", this.getStatus());
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
     * Sets the code property value. The machine-readable code to branch on.
     * @param value Value to set for the code property.
     */
    public void setCode(@jakarta.annotation.Nullable final String value) {
        this.code = value;
    }
    /**
     * Sets the details property value. Extra context for this failure. A validation error puts each rejected field and its messages here.
     * @param value Value to set for the details property.
     */
    public void setDetails(@jakarta.annotation.Nullable final ErrorResponseErrorDetails value) {
        this.details = value;
    }
    /**
     * Sets the message property value. What went wrong, in words.
     * @param value Value to set for the message property.
     */
    public void setMessage(@jakarta.annotation.Nullable final String value) {
        this.message = value;
    }
    /**
     * Sets the request_id property value. Identifies this request in our logs. Quote it when you report a problem.
     * @param value Value to set for the request_id property.
     */
    public void setRequestId(@jakarta.annotation.Nullable final String value) {
        this.requestId = value;
    }
    /**
     * Sets the status property value. The HTTP status, repeated in the body.
     * @param value Value to set for the status property.
     */
    public void setStatus(@jakarta.annotation.Nullable final Integer value) {
        this.status = value;
    }
}
