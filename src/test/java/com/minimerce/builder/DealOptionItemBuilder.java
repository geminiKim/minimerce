package com.minimerce.builder;

import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.deal.option.item.DealOptionItem;
import com.minimerce.domain.type.DealType;

import java.time.LocalDateTime;

/**
 * Created by gemini on 12/04/2017.
 */
public final class DealOptionItemBuilder {
    public DealOption option;
    protected Long id;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
    private Long clientId;
    private DealType type;
    private Long itemId;

    private DealOptionItemBuilder() {
    }

    public static DealOptionItemBuilder aDealOptionItem() {
        return new DealOptionItemBuilder();
    }

    public DealOptionItemBuilder withClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public DealOptionItemBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public DealOptionItemBuilder withOption(DealOption option) {
        this.option = option;
        return this;
    }

    public DealOptionItemBuilder withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public DealOptionItemBuilder withUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public DealOptionItemBuilder withType(DealType type) {
        this.type = type;
        return this;
    }

    public DealOptionItemBuilder withItemId(Long itemId) {
        this.itemId = itemId;
        return this;
    }

    public DealOptionItem build() {
        DealOptionItem dealOptionItem = new DealOptionItem();
        dealOptionItem.setClientId(clientId);
        dealOptionItem.setId(id);
        dealOptionItem.setOption(option);
        dealOptionItem.setCreatedAt(createdAt);
        dealOptionItem.setUpdatedAt(updatedAt);
        dealOptionItem.setType(type);
        dealOptionItem.setItemId(itemId);
        return dealOptionItem;
    }
}
