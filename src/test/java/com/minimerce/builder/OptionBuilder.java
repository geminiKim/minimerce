package com.minimerce.builder;

import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.DealStatus;
import com.minimerce.core.domain.deal.option.Option;
import com.minimerce.core.support.object.type.CancelType;
import com.minimerce.core.support.object.type.ProductType;
import com.minimerce.core.support.util.Yn;

import java.time.LocalDateTime;

/**
 * Created by gemini on 04/04/2017.
 */
public final class OptionBuilder {
    private Long id = 1L;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private String name = "Test Deal Option";
    private String description = "Test Deal Option Description";
    private ProductType type = ProductType.USABLE;
    private DealStatus status = DealStatus.SALE;
    private Yn display = Yn.Y;
    private int displayPrice = 15000;
    private String priceUnit = "원";
    private CancelType cancelType = CancelType.APPROVE;
    private String informationJson = "{}";
    private String imageJson = "{}";
    private String thumbnailJson = "{}";
    private int sort = 0;
    private Deal deal = new Deal();
    private Yn deleted = Yn.N;

    private OptionBuilder() {
    }

    public static OptionBuilder anOption() {
        return new OptionBuilder();
    }

    public OptionBuilder withDeal(Deal deal) {
        this.deal = deal;
        return this;
    }

    public OptionBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public OptionBuilder withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public OptionBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public OptionBuilder withUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public OptionBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public OptionBuilder withType(ProductType type) {
        this.type = type;
        return this;
    }

    public OptionBuilder withStatus(DealStatus status) {
        this.status = status;
        return this;
    }

    public OptionBuilder withDisplay(Yn display) {
        this.display = display;
        return this;
    }

    public OptionBuilder withDisplayPrice(int displayPrice) {
        this.displayPrice = displayPrice;
        return this;
    }

    public OptionBuilder withPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
        return this;
    }

    public OptionBuilder withCancelType(CancelType cancelType) {
        this.cancelType = cancelType;
        return this;
    }

    public OptionBuilder withInformationJson(String informationJson) {
        this.informationJson = informationJson;
        return this;
    }

    public OptionBuilder withImageJson(String imageJson) {
        this.imageJson = imageJson;
        return this;
    }

    public OptionBuilder withThumbnailJson(String thumbnailJson) {
        this.thumbnailJson = thumbnailJson;
        return this;
    }

    public OptionBuilder withSort(int sort) {
        this.sort = sort;
        return this;
    }

    public OptionBuilder withDeleted(Yn deleted) {
        this.deleted = deleted;
        return this;
    }

    public Option build() {
        Option option = new Option();
        option.setId(id);
        option.setCreatedAt(createdAt);
        option.setName(name);
        option.setUpdatedAt(updatedAt);
        option.setDescription(description);
        option.setType(type);
        option.setStatus(status);
        option.setDisplay(display);
        option.setPriceUnit(priceUnit);
        option.setCancelType(cancelType);
        option.setInformationJson(informationJson);
        option.setImageJson(imageJson);
        option.setThumbnailJson(thumbnailJson);
        option.setDeleted(deleted);
        deal.addOption(option);
        return option;
    }
}
