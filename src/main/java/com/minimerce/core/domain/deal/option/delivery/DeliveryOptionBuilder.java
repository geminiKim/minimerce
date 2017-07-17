package com.minimerce.core.domain.deal.option.delivery;

import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.DealStatus;
import com.minimerce.core.object.deal.type.ProductType;
import com.minimerce.core.object.order.type.CancelType;
import com.minimerce.core.support.util.Yn;

import java.time.LocalDateTime;

/**
 * Created by gemini on 18/07/2017.
 */
public final class DeliveryOptionBuilder {
    protected Long id = 1L;
    protected LocalDateTime createdAt = LocalDateTime.now();
    protected LocalDateTime updatedAt = LocalDateTime.now();
    private int normalPrice = 15000;
    private int salePrice = 10000;
    private int costPrice = 5000;
    private int stock = 1;
    private LocalDateTime saleStartAt = LocalDateTime.now();
    private LocalDateTime saleEndAt = LocalDateTime.now();
    private Deal deal = new Deal();
    private String name = "test-delivery-option";
    private String description = "test-delivery-option-description";
    private ProductType type = ProductType.DELIVERY;
    private DealStatus status = DealStatus.SALE;
    private CancelType cancelType = CancelType.APPROVE;
    private String priceUnit = "$";
    private String informationJson = "{}";
    private String imageJson = "{}";
    private String thumbnailJson = "{}";
    private Yn display = Yn.Y;
    private Yn deleted = Yn.N;

    private DeliveryOptionBuilder() {
    }

    public static DeliveryOptionBuilder aDeliveryOption() {
        return new DeliveryOptionBuilder();
    }

    public DeliveryOptionBuilder withNormalPrice(int normalPrice) {
        this.normalPrice = normalPrice;
        return this;
    }

    public DeliveryOptionBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public DeliveryOptionBuilder withSalePrice(int salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public DeliveryOptionBuilder withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public DeliveryOptionBuilder withCostPrice(int costPrice) {
        this.costPrice = costPrice;
        return this;
    }

    public DeliveryOptionBuilder withUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public DeliveryOptionBuilder withStock(int stock) {
        this.stock = stock;
        return this;
    }

    public DeliveryOptionBuilder withSaleStartAt(LocalDateTime saleStartAt) {
        this.saleStartAt = saleStartAt;
        return this;
    }

    public DeliveryOptionBuilder withSaleEndAt(LocalDateTime saleEndAt) {
        this.saleEndAt = saleEndAt;
        return this;
    }

    public DeliveryOptionBuilder withDeal(Deal deal) {
        this.deal = deal;
        return this;
    }

    public DeliveryOptionBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public DeliveryOptionBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public DeliveryOptionBuilder withType(ProductType type) {
        this.type = type;
        return this;
    }

    public DeliveryOptionBuilder withStatus(DealStatus status) {
        this.status = status;
        return this;
    }

    public DeliveryOptionBuilder withCancelType(CancelType cancelType) {
        this.cancelType = cancelType;
        return this;
    }

    public DeliveryOptionBuilder withPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
        return this;
    }

    public DeliveryOptionBuilder withInformationJson(String informationJson) {
        this.informationJson = informationJson;
        return this;
    }

    public DeliveryOptionBuilder withImageJson(String imageJson) {
        this.imageJson = imageJson;
        return this;
    }

    public DeliveryOptionBuilder withThumbnailJson(String thumbnailJson) {
        this.thumbnailJson = thumbnailJson;
        return this;
    }

    public DeliveryOptionBuilder withDisplay(Yn display) {
        this.display = display;
        return this;
    }

    public DeliveryOptionBuilder withDeleted(Yn deleted) {
        this.deleted = deleted;
        return this;
    }

    public DeliveryOption build() {
        DeliveryOption deliveryOption = new DeliveryOption();
        deliveryOption.setNormalPrice(normalPrice);
        deliveryOption.setId(id);
        deliveryOption.setSalePrice(salePrice);
        deliveryOption.setCreatedAt(createdAt);
        deliveryOption.setCostPrice(costPrice);
        deliveryOption.setUpdatedAt(updatedAt);
        deliveryOption.setStock(stock);
        deliveryOption.setSaleStartAt(saleStartAt);
        deliveryOption.setSaleEndAt(saleEndAt);
        deliveryOption.setDeal(deal);
        deliveryOption.setName(name);
        deliveryOption.setDescription(description);
        deliveryOption.setType(type);
        deliveryOption.setStatus(status);
        deliveryOption.setCancelType(cancelType);
        deliveryOption.setPriceUnit(priceUnit);
        deliveryOption.setInformationJson(informationJson);
        deliveryOption.setImageJson(imageJson);
        deliveryOption.setThumbnailJson(thumbnailJson);
        deliveryOption.setDisplay(display);
        deliveryOption.setDeleted(deleted);
        return deliveryOption;
    }
}
