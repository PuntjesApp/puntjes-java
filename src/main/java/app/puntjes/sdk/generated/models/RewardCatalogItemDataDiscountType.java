package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

/**
 * `percentage` or `fixed_amount` for a discount, null for a free product.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public enum RewardCatalogItemDataDiscountType implements ValuedEnum {
    Fixed_amount("fixed_amount"),
    Percentage("percentage"),
    OpenapiJsonNullSentinelValue2BF936000FE44250987AE5DDB203E464("openapi-json-null-sentinel-value-2BF93600-0FE4-4250-987A-E5DDB203E464");
    public final String value;
    RewardCatalogItemDataDiscountType(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static RewardCatalogItemDataDiscountType forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "fixed_amount": return Fixed_amount;
            case "percentage": return Percentage;
            case "openapi-json-null-sentinel-value-2BF93600-0FE4-4250-987A-E5DDB203E464": return OpenapiJsonNullSentinelValue2BF936000FE44250987AE5DDB203E464;
            default: return null;
        }
    }
}
