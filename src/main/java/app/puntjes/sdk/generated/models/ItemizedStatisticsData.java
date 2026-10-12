package app.puntjes.sdk.generated.models;

import com.microsoft.kiota.serialization.AdditionalDataHolder;
import com.microsoft.kiota.serialization.Parsable;
import com.microsoft.kiota.serialization.ParseNode;
import com.microsoft.kiota.serialization.SerializationWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@jakarta.annotation.Generated("com.microsoft.kiota")
public class ItemizedStatisticsData implements AdditionalDataHolder, Parsable {
    /**
     * Stores additional data not described in the OpenAPI description found when deserializing. Can be used for serialization as well.
     */
    private Map<String, Object> additionalData;
    /**
     * The average_items_per_order property
     */
    private Double averageItemsPerOrder;
    /**
     * The categories property
     */
    private java.util.List<CategoryRevenueData> categories;
    /**
     * The orders property
     */
    private Integer orders;
    /**
     * The other_no_item_detail_cents property
     */
    private Integer otherNoItemDetailCents;
    /**
     * The revenue_cents property
     */
    private Integer revenueCents;
    /**
     * The top_products property
     */
    private java.util.List<TopProductData> topProducts;
    /**
     * Instantiates a new {@link ItemizedStatisticsData} and sets the default values.
     */
    public ItemizedStatisticsData() {
        this.setAdditionalData(new HashMap<>());
    }
    /**
     * Creates a new instance of the appropriate class based on discriminator value
     * @param parseNode The parse node to use to read the discriminator value and create the object
     * @return a {@link ItemizedStatisticsData}
     */
    @jakarta.annotation.Nonnull
    public static ItemizedStatisticsData createFromDiscriminatorValue(@jakarta.annotation.Nonnull final ParseNode parseNode) {
        Objects.requireNonNull(parseNode);
        return new ItemizedStatisticsData();
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
     * Gets the average_items_per_order property value. The average_items_per_order property
     * @return a {@link Double}
     */
    @jakarta.annotation.Nullable
    public Double getAverageItemsPerOrder() {
        return this.averageItemsPerOrder;
    }
    /**
     * Gets the categories property value. The categories property
     * @return a {@link java.util.List<CategoryRevenueData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<CategoryRevenueData> getCategories() {
        return this.categories;
    }
    /**
     * The deserialization information for the current model
     * @return a {@link Map<String, java.util.function.Consumer<ParseNode>>}
     */
    @jakarta.annotation.Nonnull
    public Map<String, java.util.function.Consumer<ParseNode>> getFieldDeserializers() {
        final HashMap<String, java.util.function.Consumer<ParseNode>> deserializerMap = new HashMap<String, java.util.function.Consumer<ParseNode>>(6);
        deserializerMap.put("average_items_per_order", (n) -> { this.setAverageItemsPerOrder(n.getDoubleValue()); });
        deserializerMap.put("categories", (n) -> { this.setCategories(n.getCollectionOfObjectValues(CategoryRevenueData::createFromDiscriminatorValue)); });
        deserializerMap.put("orders", (n) -> { this.setOrders(n.getIntegerValue()); });
        deserializerMap.put("other_no_item_detail_cents", (n) -> { this.setOtherNoItemDetailCents(n.getIntegerValue()); });
        deserializerMap.put("revenue_cents", (n) -> { this.setRevenueCents(n.getIntegerValue()); });
        deserializerMap.put("top_products", (n) -> { this.setTopProducts(n.getCollectionOfObjectValues(TopProductData::createFromDiscriminatorValue)); });
        return deserializerMap;
    }
    /**
     * Gets the orders property value. The orders property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getOrders() {
        return this.orders;
    }
    /**
     * Gets the other_no_item_detail_cents property value. The other_no_item_detail_cents property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getOtherNoItemDetailCents() {
        return this.otherNoItemDetailCents;
    }
    /**
     * Gets the revenue_cents property value. The revenue_cents property
     * @return a {@link Integer}
     */
    @jakarta.annotation.Nullable
    public Integer getRevenueCents() {
        return this.revenueCents;
    }
    /**
     * Gets the top_products property value. The top_products property
     * @return a {@link java.util.List<TopProductData>}
     */
    @jakarta.annotation.Nullable
    public java.util.List<TopProductData> getTopProducts() {
        return this.topProducts;
    }
    /**
     * Serializes information the current object
     * @param writer Serialization writer to use to serialize this model
     */
    public void serialize(@jakarta.annotation.Nonnull final SerializationWriter writer) {
        Objects.requireNonNull(writer);
        writer.writeDoubleValue("average_items_per_order", this.getAverageItemsPerOrder());
        writer.writeCollectionOfObjectValues("categories", this.getCategories());
        writer.writeIntegerValue("orders", this.getOrders());
        writer.writeIntegerValue("other_no_item_detail_cents", this.getOtherNoItemDetailCents());
        writer.writeIntegerValue("revenue_cents", this.getRevenueCents());
        writer.writeCollectionOfObjectValues("top_products", this.getTopProducts());
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
     * Sets the average_items_per_order property value. The average_items_per_order property
     * @param value Value to set for the average_items_per_order property.
     */
    public void setAverageItemsPerOrder(@jakarta.annotation.Nullable final Double value) {
        this.averageItemsPerOrder = value;
    }
    /**
     * Sets the categories property value. The categories property
     * @param value Value to set for the categories property.
     */
    public void setCategories(@jakarta.annotation.Nullable final java.util.List<CategoryRevenueData> value) {
        this.categories = value;
    }
    /**
     * Sets the orders property value. The orders property
     * @param value Value to set for the orders property.
     */
    public void setOrders(@jakarta.annotation.Nullable final Integer value) {
        this.orders = value;
    }
    /**
     * Sets the other_no_item_detail_cents property value. The other_no_item_detail_cents property
     * @param value Value to set for the other_no_item_detail_cents property.
     */
    public void setOtherNoItemDetailCents(@jakarta.annotation.Nullable final Integer value) {
        this.otherNoItemDetailCents = value;
    }
    /**
     * Sets the revenue_cents property value. The revenue_cents property
     * @param value Value to set for the revenue_cents property.
     */
    public void setRevenueCents(@jakarta.annotation.Nullable final Integer value) {
        this.revenueCents = value;
    }
    /**
     * Sets the top_products property value. The top_products property
     * @param value Value to set for the top_products property.
     */
    public void setTopProducts(@jakarta.annotation.Nullable final java.util.List<TopProductData> value) {
        this.topProducts = value;
    }
}
