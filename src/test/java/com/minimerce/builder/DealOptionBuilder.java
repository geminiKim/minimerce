package com.minimerce.builder;

import com.google.common.collect.Lists;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.DealStatus;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.deal.option.item.DealOptionItem;
import com.minimerce.domain.type.CancelType;
import com.minimerce.domain.type.DealType;
import com.minimerce.support.util.Yn;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by gemini on 04/04/2017.
 */
public final class DealOptionBuilder {
    private Long id = 1L;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private Long clientId = 1L;
    private String name = "Test Deal Option";
    private String description = "Test Deal Option Description";
    private DealType type = DealType.USABLE;
    private DealStatus status = DealStatus.SALE;
    private Yn display = Yn.Y;
    private int salePrice = 10000;
    private int displayPrice = 15000;
    private String priceUnit = "원";
    private CancelType cancelType = CancelType.APPROVE;
    private String informationJson = "{}";
    private String imageJson = "{}";
    private String thumbnailJson = "{}";
    private int sort = 0;
    private Deal deal = new Deal();
    private List<DealOptionItem> items = Lists.newArrayList();


    private DealOptionBuilder() {
    }

    public static DealOptionBuilder aDealOption() {
        return new DealOptionBuilder();
    }

    public DealOptionBuilder withDeal(Deal deal) {
        this.deal = deal;
        return this;
    }

    public DealOptionBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public DealOptionBuilder withClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public DealOptionBuilder withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public DealOptionBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public DealOptionBuilder withUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public DealOptionBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public DealOptionBuilder withType(DealType type) {
        this.type = type;
        return this;
    }

    public DealOptionBuilder withStatus(DealStatus status) {
        this.status = status;
        return this;
    }

    public DealOptionBuilder withDisplay(Yn display) {
        this.display = display;
        return this;
    }

    public DealOptionBuilder withSalePrice(int salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public DealOptionBuilder withDisplayPrice(int displayPrice) {
        this.displayPrice = displayPrice;
        return this;
    }

    public DealOptionBuilder withPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
        return this;
    }

    public DealOptionBuilder withCancelType(CancelType cancelType) {
        this.cancelType = cancelType;
        return this;
    }

    public DealOptionBuilder withInformationJson(String informationJson) {
        this.informationJson = informationJson;
        return this;
    }

    public DealOptionBuilder withImageJson(String imageJson) {
        this.imageJson = imageJson;
        return this;
    }

    public DealOptionBuilder withThumbnailJson(String thumbnailJson) {
        this.thumbnailJson = thumbnailJson;
        return this;
    }

    public DealOptionBuilder withSort(int sort) {
        this.sort = sort;
        return this;
    }

    public DealOptionBuilder withItems(List<DealOptionItem> items) {
        this.items = items;
        return this;
    }

    public DealOption build() {
        DealOption dealOption = new DealOption();
        dealOption.setId(id);
        dealOption.setClientId(clientId);
        dealOption.setCreatedAt(createdAt);
        dealOption.setName(name);
        dealOption.setUpdatedAt(updatedAt);
        dealOption.setDescription(description);
        dealOption.setType(type);
        dealOption.setStatus(status);
        dealOption.setDisplay(display);
        dealOption.setSalePrice(salePrice);
        dealOption.setDisplayPrice(displayPrice);
        dealOption.setPriceUnit(priceUnit);
        dealOption.setCancelType(cancelType);
        dealOption.setInformationJson(informationJson);
        dealOption.setImageJson(imageJson);
        dealOption.setThumbnailJson(thumbnailJson);
        dealOption.setSort(sort);
        dealOption.setDeal(deal);
        dealOption.addItems(items);
        return dealOption;
    }
}
