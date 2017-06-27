package com.minimerce.builder;

import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.option.usable.UsableOption;
import com.minimerce.core.domain.order.Order;
import com.minimerce.core.domain.order.option.usable.UsableOrderOption;
import com.minimerce.core.object.deal.type.ProductType;
import com.minimerce.core.object.order.status.CancelStatus;
import com.minimerce.core.object.order.status.OrderStatus;

import java.time.LocalDateTime;

/**
 * Created by gemini on 27/06/2017.
 */
public final class UsableOrderOptionBuilder {
    protected Long id = 1L;
    protected LocalDateTime createdAt = LocalDateTime.now();
    protected LocalDateTime updatedAt = LocalDateTime.now();
    private Long clientId = 1L;
    private UsableOption option = new UsableOption();
    private Order order = new Order();
    private int usedCount = 0;
    private int usableCount = 1;
    private Deal deal = new Deal();
    private String title = "test-usable-order-option";
    private LocalDateTime availableStartAt = LocalDateTime.now();
    private LocalDateTime availableEndAt = LocalDateTime.now();
    private ProductType type = ProductType.USABLE;
    private OrderStatus status = OrderStatus.ORDERED;
    private CancelStatus cancelStatus = CancelStatus.NOT_CANCEL;
    private int salePrice = 10000;
    private int costPrice = 5000;

    private UsableOrderOptionBuilder() {
    }

    public static UsableOrderOptionBuilder anUsableOrderOption() {
        return new UsableOrderOptionBuilder();
    }

    public UsableOrderOptionBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public UsableOrderOptionBuilder withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public UsableOrderOptionBuilder withUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public UsableOrderOptionBuilder withClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public UsableOrderOptionBuilder withOption(UsableOption option) {
        this.option = option;
        return this;
    }

    public UsableOrderOptionBuilder withOrder(Order order) {
        this.order = order;
        return this;
    }

    public UsableOrderOptionBuilder withUsedCount(int usedCount) {
        this.usedCount = usedCount;
        return this;
    }

    public UsableOrderOptionBuilder withUsableCount(int usableCount) {
        this.usableCount = usableCount;
        return this;
    }

    public UsableOrderOptionBuilder withDeal(Deal deal) {
        this.deal = deal;
        return this;
    }

    public UsableOrderOptionBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public UsableOrderOptionBuilder withAvailableStartAt(LocalDateTime availableStartAt) {
        this.availableStartAt = availableStartAt;
        return this;
    }

    public UsableOrderOptionBuilder withAvailableEndAt(LocalDateTime availableEndAt) {
        this.availableEndAt = availableEndAt;
        return this;
    }

    public UsableOrderOptionBuilder withType(ProductType type) {
        this.type = type;
        return this;
    }

    public UsableOrderOptionBuilder withStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    public UsableOrderOptionBuilder withCancelStatus(CancelStatus cancelStatus) {
        this.cancelStatus = cancelStatus;
        return this;
    }

    public UsableOrderOptionBuilder withSalePrice(int salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public UsableOrderOptionBuilder withCostPrice(int costPrice) {
        this.costPrice = costPrice;
        return this;
    }

    public UsableOrderOption build() {
        UsableOrderOption usableOrderOption = new UsableOrderOption();
        usableOrderOption.setId(id);
        usableOrderOption.setCreatedAt(createdAt);
        usableOrderOption.setUpdatedAt(updatedAt);
        usableOrderOption.setClientId(clientId);
        usableOrderOption.setOption(option);
        usableOrderOption.setOrder(order);
        usableOrderOption.setUsedCount(usedCount);
        usableOrderOption.setUsableCount(usableCount);
        usableOrderOption.setDeal(deal);
        usableOrderOption.setTitle(title);
        usableOrderOption.setAvailableStartAt(availableStartAt);
        usableOrderOption.setAvailableEndAt(availableEndAt);
        usableOrderOption.setType(type);
        usableOrderOption.setStatus(status);
        usableOrderOption.setCancelStatus(cancelStatus);
        usableOrderOption.setSalePrice(salePrice);
        usableOrderOption.setCostPrice(costPrice);
        return usableOrderOption;
    }
}
