package com.minimerce.builder;

import com.google.common.collect.Lists;
import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.DealStatus;
import com.minimerce.core.domain.deal.option.DealOption;
import com.minimerce.core.support.object.type.ProductType;
import com.minimerce.core.support.util.Yn;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by gemini on 04/04/2017.
 */
public final class DealBuilder {
    private Long id = 1L;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private String name = "Test Deal";
    private String description = "Test Deal Description";
    private ProductType type = ProductType.USABLE;
    private Yn display = Yn.Y;
    private DealStatus status = DealStatus.SALE;
    private LocalDateTime saleStartAt = LocalDateTime.now();
    private LocalDateTime saleEndAt = LocalDateTime.now();
    private String informationJson = "{}";
    private String imageJson = "{}";
    private String thumbnailJson = "{}";
    private int price = 10000;
    private int displayPrice = 15000;
    private String priceUnit = "원";
    private List<DealOption> options = Lists.newArrayList();
    private Yn deleted = Yn.N;

    private DealBuilder() {
    }

    public static DealBuilder aDeal() {
        return new DealBuilder();
    }

    public DealBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public DealBuilder withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public DealBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public DealBuilder withUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public DealBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public DealBuilder withType(ProductType type) {
        this.type = type;
        return this;
    }

    public DealBuilder withDisplay(Yn display) {
        this.display = display;
        return this;
    }

    public DealBuilder withStatus(DealStatus status) {
        this.status = status;
        return this;
    }

    public DealBuilder withSaleStartAt(LocalDateTime saleStartAt) {
        this.saleStartAt = saleStartAt;
        return this;
    }

    public DealBuilder withSaleEndAt(LocalDateTime saleEndAt) {
        this.saleEndAt = saleEndAt;
        return this;
    }

    public DealBuilder withInformationJson(String informationJson) {
        this.informationJson = informationJson;
        return this;
    }

    public DealBuilder withImageJson(String imageJson) {
        this.imageJson = imageJson;
        return this;
    }

    public DealBuilder withThumbnailJson(String thumbnailJson) {
        this.thumbnailJson = thumbnailJson;
        return this;
    }

    public DealBuilder withPrice(int salePrice) {
        this.price = salePrice;
        return this;
    }

    public DealBuilder withDisplayPrice(int displayPrice) {
        this.displayPrice = displayPrice;
        return this;
    }

    public DealBuilder withPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
        return this;
    }

    public DealBuilder withOptions(List<DealOption> options) {
        this.options = options;
        return this;
    }

    public DealBuilder withDeleted(Yn deleted) {
        this.deleted = deleted;
        return this;
    }

    public Deal build() {
        Deal deal = new Deal();
        deal.setId(id);
        deal.setCreatedAt(createdAt);
        deal.setName(name);
        deal.setUpdatedAt(updatedAt);
        deal.setDescription(description);
        deal.setType(type);
        deal.setDisplay(display);
        deal.setStatus(status);
        deal.setSaleStartAt(saleStartAt);
        deal.setSaleEndAt(saleEndAt);
        deal.setInformationJson(informationJson);
        deal.setImageJson(imageJson);
        deal.setThumbnailJson(thumbnailJson);
        deal.setPrice(price);
        deal.setDisplayPrice(displayPrice);
        deal.setPriceUnit(priceUnit);
        deal.addOptions(options);
        deal.setDeleted(deleted);
        return deal;
    }
}
