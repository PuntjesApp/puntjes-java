package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.ValuedEnum;
import java.util.Objects;

/**
 * `whole` and `whole_purchase` both mean the whole purchase. Absent reads as `whole`.
 */
@jakarta.annotation.Generated("com.microsoft.kiota")
public enum TransactionCampaignConfigDataScope implements ValuedEnum {
    Whole("whole"),
    Whole_purchase("whole_purchase"),
    Products("products");
    public final String value;
    TransactionCampaignConfigDataScope(final String value) {
        this.value = value;
    }
    @jakarta.annotation.Nonnull
    public String getValue() { return this.value; }
    @jakarta.annotation.Nullable
    public static TransactionCampaignConfigDataScope forValue(@jakarta.annotation.Nonnull final String searchValue) {
        Objects.requireNonNull(searchValue);
        switch(searchValue) {
            case "whole": return Whole;
            case "whole_purchase": return Whole_purchase;
            case "products": return Products;
            default: return null;
        }
    }
}
