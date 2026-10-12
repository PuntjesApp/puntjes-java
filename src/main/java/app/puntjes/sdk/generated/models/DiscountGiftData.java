package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.ComposedTypeWrapper;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class DiscountGiftData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * How much comes off. Its `type` says which shape this is.
     */
    private DiscountGiftDataDiscount discount;
    /**
     * A line the customer reads with the gift.
     */
    private String message;
    /**
     * Always `discount` for this shape.
     */
    private DiscountGiftDataType type;
    /**
     * How many days the customer has to use it.
     */
    private Integer validityDays;
    /**
     * Instantiates a new {@link DiscountGiftData} and sets the default values.
     */
    public DiscountGiftData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link DiscountGiftData}
     */
    @jakarta.annotation.Nonnull
    public static DiscountGiftData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new DiscountGiftData();
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
     * Gets the discount property value. How much comes off. Its `type` says which shape this is.
     * @return a {@link DiscountGiftDataDiscount}
     */
    @jakarta.annotation.Nullable
    public DiscountGiftDataDiscount getDiscount() {
        return this.discount;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(4);
        deserializerMap.put("discount", (n) -> { this.setDiscount(n.getObjectValue(DiscountGiftDataDiscount::createFromDiscriminatorValue)); });
        deserializerMap.put("message", (n) -> { this.setMessage(n.getStringValue()); });
        deserializerMap.put("type", (n) -> { this.setType(n.getEnumValue(DiscountGiftDataType::forValue)); });
        deserializerMap.put("validity_days", (n) -> { this.setValidityDays(n.getIntegerValue()); });
        return deserializerMap;
    }
    /**
     * Gets the message property value. A line the customer reads with the gift.
     * @return a {@link String}
     */
    @jakarta.annotation.Nullable
    public String getMessage() {
        return this.message;
    }
    /**
     * Gets the type property value. Always `discount` for this shape.
     * @return a {@link DiscountGiftDataType}
     */
    @jakarta.annotation.Nullable
    public DiscountGiftDataType getType() {
        return this.type;
    }
    /**
     * Gets the validity_days property value. How many days the customer has to use it.
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getValidityDays() {
        return this.validityDays;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeObjectValue("discount", this.getDiscount());
        writer.writeStringValue("message", this.getMessage());
        writer.writeEnumValue("type", this.getType());
        writer.writeIntegerValue("validity_days", this.getValidityDays());
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
     * Sets the discount property value. How much comes off. Its `type` says which shape this is.
     * @param value Value to set for the discount property.
     */
    public void setDiscount(@jakarta.annotation.Nullable final DiscountGiftDataDiscount value) {
        this.discount = value;
    }
    /**
     * Sets the message property value. A line the customer reads with the gift.
     * @param value Value to set for the message property.
     */
    public void setMessage(@jakarta.annotation.Nullable final String value) {
        this.message = value;
    }
    /**
     * Sets the type property value. Always `discount` for this shape.
     * @param value Value to set for the type property.
     */
    public void setType(@jakarta.annotation.Nullable final DiscountGiftDataType value) {
        this.type = value;
    }
    /**
     * Sets the validity_days property value. How many days the customer has to use it.
     * @param value Value to set for the validity_days property.
     */
    public void setValidityDays(@jakarta.annotation.Nullable final Integer value) {
        this.validityDays = value;
    }
    /**
     * Composed type wrapper for classes {@link FixedDiscountData}, {@link PercentageDiscountData}
     */
    @jakarta.annotation.Generated("com.microsoft.kiota")
    public static class DiscountGiftDataDiscount implements ComposedTypeWrapper, Parsable {
        /**
         * Composed type representation for type {@link FixedDiscountData}
         */
        private FixedDiscountData fixedDiscountData;
        /**
         * Composed type representation for type {@link PercentageDiscountData}
         */
        private PercentageDiscountData percentageDiscountData;
        /**
         * Creates a new instance of the appropriate class based on discriminator value
         * @param parseNode The parse node to use to read the discriminator value and create the object
         * @return a {@link DiscountGiftDataDiscount}
         */
        @jakarta.annotation.Nonnull
        public static DiscountGiftDataDiscount createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
            Objects.requireNonNull(parseNode);
            final DiscountGiftDataDiscount result = new DiscountGiftDataDiscount();
            final ParseNode mappingValueNode = parseNode.getChildNode("type");
            if (mappingValueNode != null) {
                final String mappingValue = mappingValueNode.getStringValue();
                if ("fixed".equalsIgnoreCase(mappingValue)) {
                    result.setFixedDiscountData(new FixedDiscountData());
                } else if ("percentage".equalsIgnoreCase(mappingValue)) {
                    result.setPercentageDiscountData(new PercentageDiscountData());
                }
            }
            return result;
        }
        /**
         * The deserialization information for the current model
         * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
         */
        @jakarta.annotation.Nonnull
        public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
            if (this.getFixedDiscountData() != null) {
                return this.getFixedDiscountData().getFieldDeserializers();
            } else if (this.getPercentageDiscountData() != null) {
                return this.getPercentageDiscountData().getFieldDeserializers();
            }
            return new HashMap<String, java.util.function.Consumer<ParseNode>>();
        }
        /**
         * Gets the FixedDiscountData property value. Composed type representation for type {@link FixedDiscountData}
         * @return a {@link FixedDiscountData}
         */
        @jakarta.annotation.Nullable
        public FixedDiscountData getFixedDiscountData() {
            return this.fixedDiscountData;
        }
        /**
         * Gets the PercentageDiscountData property value. Composed type representation for type {@link PercentageDiscountData}
         * @return a {@link PercentageDiscountData}
         */
        @jakarta.annotation.Nullable
        public PercentageDiscountData getPercentageDiscountData() {
            return this.percentageDiscountData;
        }
        /**
         * Serializes information the current object
         * @param writer Serialization writer to use to serialize this model
         */
        public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
            Objects.requireNonNull(writer);
            if (this.getFixedDiscountData() != null) {
                writer.writeObjectValue(null, this.getFixedDiscountData());
            } else if (this.getPercentageDiscountData() != null) {
                writer.writeObjectValue(null, this.getPercentageDiscountData());
            }
        }
        /**
         * Sets the FixedDiscountData property value. Composed type representation for type {@link FixedDiscountData}
         * @param value Value to set for the FixedDiscountData property.
         */
        public void setFixedDiscountData(@jakarta.annotation.Nullable final FixedDiscountData value) {
            this.fixedDiscountData = value;
        }
        /**
         * Sets the PercentageDiscountData property value. Composed type representation for type {@link PercentageDiscountData}
         * @param value Value to set for the PercentageDiscountData property.
         */
        public void setPercentageDiscountData(@jakarta.annotation.Nullable final PercentageDiscountData value) {
            this.percentageDiscountData = value;
        }
    }
}
