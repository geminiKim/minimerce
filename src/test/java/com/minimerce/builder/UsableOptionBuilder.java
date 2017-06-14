package com.minimerce.builder;

import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.DealStatus;
import com.minimerce.core.domain.deal.option.usable.UsableOption;
import com.minimerce.core.support.object.type.CancelType;
import com.minimerce.core.support.object.type.ProductType;
import com.minimerce.core.support.util.Yn;

import java.time.LocalDateTime;

/**
 * Created by gemini on 13/06/2017.
 */
public final class UsableOptionBuilder {
    public Deal deal = new Deal();
    protected Long id = 1L;
    protected LocalDateTime createdAt = LocalDateTime.now();
    protected LocalDateTime updatedAt = LocalDateTime.now();
    private int normalPrice = 15000;
    private int salePrice = 10000;
    private int costPrice = 5000;
    private int stock = 1;
    private int usableCount = 1;
    private LocalDateTime saleStartAt = LocalDateTime.now();
    private LocalDateTime saleEndAt = LocalDateTime.now();
    private LocalDateTime availableStartAt = LocalDateTime.now();
    private LocalDateTime availableEndAt = LocalDateTime.now();
    private String name = "test-usable-option";
    private String description = "test-usable-option-description";
    private ProductType type = ProductType.USABLE;
    private DealStatus status = DealStatus.SALE;
    private CancelType cancelType = CancelType.APPROVE;
    private String priceUnit = "$";
    private String informationJson = "{}";
    private String imageJson = "{}";
    private String thumbnailJson = "{}";
    private Yn display = Yn.Y;
    private Yn deleted = Yn.N;

    private UsableOptionBuilder() {
    }

    public static UsableOptionBuilder anUsableOption() {
        return new UsableOptionBuilder();
    }

    public UsableOptionBuilder withNormalPrice(int normalPrice) {
        this.normalPrice = normalPrice;
        return this;
    }

    public UsableOptionBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public UsableOptionBuilder withSalePrice(int salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public UsableOptionBuilder withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public UsableOptionBuilder withCostPrice(int costPrice) {
        this.costPrice = costPrice;
        return this;
    }

    public UsableOptionBuilder withUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public UsableOptionBuilder withStock(int stock) {
        this.stock = stock;
        return this;
    }

    public UsableOptionBuilder withUsableCount(int usableCount) {
        this.usableCount = usableCount;
        return this;
    }

    public UsableOptionBuilder withSaleStartAt(LocalDateTime saleStartAt) {
        this.saleStartAt = saleStartAt;
        return this;
    }

    public UsableOptionBuilder withSaleEndAt(LocalDateTime saleEndAt) {
        this.saleEndAt = saleEndAt;
        return this;
    }

    public UsableOptionBuilder withAvailableStartAt(LocalDateTime availableStartAt) {
        this.availableStartAt = availableStartAt;
        return this;
    }

    public UsableOptionBuilder withAvailableEndAt(LocalDateTime availableEndAt) {
        this.availableEndAt = availableEndAt;
        return this;
    }

    public UsableOptionBuilder withDeal(Deal deal) {
        this.deal = deal;
        return this;
    }

    public UsableOptionBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UsableOptionBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public UsableOptionBuilder withType(ProductType type) {
        this.type = type;
        return this;
    }

    public UsableOptionBuilder withStatus(DealStatus status) {
        this.status = status;
        return this;
    }

    public UsableOptionBuilder withCancelType(CancelType cancelType) {
        this.cancelType = cancelType;
        return this;
    }

    public UsableOptionBuilder withPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
        return this;
    }

    public UsableOptionBuilder withInformationJson(String informationJson) {
        this.informationJson = informationJson;
        return this;
    }

    public UsableOptionBuilder withImageJson(String imageJson) {
        this.imageJson = imageJson;
        return this;
    }

    public UsableOptionBuilder withThumbnailJson(String thumbnailJson) {
        this.thumbnailJson = thumbnailJson;
        return this;
    }

    public UsableOptionBuilder withDisplay(Yn display) {
        this.display = display;
        return this;
    }

    public UsableOptionBuilder withDeleted(Yn deleted) {
        this.deleted = deleted;
        return this;
    }

    public UsableOption build() {
        UsableOption usableOption = new UsableOption();
        usableOption.setNormalPrice(normalPrice);
        usableOption.setId(id);
        usableOption.setSalePrice(salePrice);
        usableOption.setCreatedAt(createdAt);
        usableOption.setCostPrice(costPrice);
        usableOption.setUpdatedAt(updatedAt);
        usableOption.setStock(stock);
        usableOption.setUsableCount(usableCount);
        usableOption.setSaleStartAt(saleStartAt);
        usableOption.setSaleEndAt(saleEndAt);
        usableOption.setAvailableStartAt(availableStartAt);
        usableOption.setAvailableEndAt(availableEndAt);
        usableOption.setDeal(deal);
        usableOption.setName(name);
        usableOption.setDescription(description);
        usableOption.setType(type);
        usableOption.setStatus(status);
        usableOption.setCancelType(cancelType);
        usableOption.setPriceUnit(priceUnit);
        usableOption.setInformationJson(informationJson);
        usableOption.setImageJson(imageJson);
        usableOption.setThumbnailJson(thumbnailJson);
        usableOption.setDisplay(display);
        usableOption.setDeleted(deleted);
        return usableOption;
    }
}
