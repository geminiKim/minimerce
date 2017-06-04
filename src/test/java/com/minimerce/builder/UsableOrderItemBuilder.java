package com.minimerce.builder;

import com.minimerce.core.domain.item.usable.UsableItem;
import com.minimerce.core.domain.order.item.usable.UsableOrderItem;
import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.support.object.order.CancelStatus;
import com.minimerce.core.support.object.order.OrderStatus;
import com.minimerce.core.support.object.type.ProductType;

import java.time.LocalDateTime;

/**
 * Created by gemini on 30/05/2017.
 */
public final class UsableOrderItemBuilder {
    private UsableItem item = new UsableItem();
    private OrderOption option = new OrderOption();
    private Long id = 1L;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private Long clientId = 1L;
    private int usableCount = 1;
    private String title = "Test Usable Order Item";
    private int usedCount = 0;
    private LocalDateTime availableStartAt = LocalDateTime.now();
    private LocalDateTime availableEndAt = LocalDateTime.now();
    private ProductType type = ProductType.USABLE;
    private OrderStatus status = OrderStatus.ORDERED;
    private CancelStatus cancelStatus = CancelStatus.NOT_CANCEL;
    private int salePrice = 5000;
    private int costPrice = 4000;

    private UsableOrderItemBuilder() {
    }

    public static UsableOrderItemBuilder anUsableOrderItem() {
        return new UsableOrderItemBuilder();
    }

    public UsableOrderItemBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public UsableOrderItemBuilder withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public UsableOrderItemBuilder withUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public UsableOrderItemBuilder withClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public UsableOrderItemBuilder withItem(UsableItem item) {
        this.item = item;
        return this;
    }

    public UsableOrderItemBuilder withUsableCount(int usableCount) {
        this.usableCount = usableCount;
        return this;
    }

    public UsableOrderItemBuilder withOption(OrderOption option) {
        this.option = option;
        return this;
    }

    public UsableOrderItemBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public UsableOrderItemBuilder withUsedCount(int usedCount) {
        this.usedCount = usedCount;
        return this;
    }

    public UsableOrderItemBuilder withAvailableStartAt(LocalDateTime availableStartAt) {
        this.availableStartAt = availableStartAt;
        return this;
    }

    public UsableOrderItemBuilder withAvailableEndAt(LocalDateTime availableEndAt) {
        this.availableEndAt = availableEndAt;
        return this;
    }

    public UsableOrderItemBuilder withType(ProductType type) {
        this.type = type;
        return this;
    }

    public UsableOrderItemBuilder withStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    public UsableOrderItemBuilder withCancelStatus(CancelStatus cancelStatus) {
        this.cancelStatus = cancelStatus;
        return this;
    }

    public UsableOrderItemBuilder withSalePrice(int salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public UsableOrderItemBuilder withCostPrice(int costPrice) {
        this.costPrice = costPrice;
        return this;
    }

    public UsableOrderItem build() {
        UsableOrderItem usableOrderItem = new UsableOrderItem();
        usableOrderItem.setId(id);
        usableOrderItem.setCreatedAt(createdAt);
        usableOrderItem.setUpdatedAt(updatedAt);
        usableOrderItem.setClientId(clientId);
        usableOrderItem.setItem(item);
        usableOrderItem.setUsableCount(usableCount);
        usableOrderItem.setTitle(title);
        usableOrderItem.setUsedCount(usedCount);
        usableOrderItem.setAvailableStartAt(availableStartAt);
        usableOrderItem.setAvailableEndAt(availableEndAt);
        usableOrderItem.setType(type);
        usableOrderItem.setStatus(status);
        usableOrderItem.setCancelStatus(cancelStatus);
        usableOrderItem.setSalePrice(salePrice);
        usableOrderItem.setCostPrice(costPrice);
        option.addItem(usableOrderItem);
        return usableOrderItem;
    }
}
