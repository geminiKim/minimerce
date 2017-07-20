package com.minimerce;

import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.option.delivery.DeliveryOption;
import com.minimerce.core.domain.order.Order;
import com.minimerce.core.domain.order.option.delivery.DeliveryOrderOption;
import com.minimerce.core.domain.order.option.delivery.DeliveryStatus;
import com.minimerce.core.object.deal.type.ProductType;
import com.minimerce.core.object.order.status.CancelStatus;
import com.minimerce.core.object.order.status.OrderStatus;

import java.time.LocalDateTime;

public final class DeliveryOrderOptionBuilder {
    protected Long id = 1L;
    protected LocalDateTime createdAt = LocalDateTime.now();
    protected LocalDateTime updatedAt = LocalDateTime.now();
    private DeliveryOption option = new DeliveryOption();
    private DeliveryStatus deliveryStatus = DeliveryStatus.WAIT;
    private Long clientId = 1L;
    private Order order = new Order();
    private Deal deal = new Deal();
    private String title = "test-delivery-order-option";
    private ProductType type = ProductType.DELIVERY;
    private OrderStatus status = OrderStatus.ORDERED;
    private CancelStatus cancelStatus = CancelStatus.NOT_CANCEL;
    private int salePrice = 10000;
    private int costPrice = 5000;

    private DeliveryOrderOptionBuilder() {
    }

    public static DeliveryOrderOptionBuilder aDeliveryOrderOption() {
        return new DeliveryOrderOptionBuilder();
    }

    public DeliveryOrderOptionBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public DeliveryOrderOptionBuilder withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public DeliveryOrderOptionBuilder withOption(DeliveryOption option) {
        this.option = option;
        return this;
    }

    public DeliveryOrderOptionBuilder withUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public DeliveryOrderOptionBuilder withDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
        return this;
    }

    public DeliveryOrderOptionBuilder withClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public DeliveryOrderOptionBuilder withOrder(Order order) {
        this.order = order;
        return this;
    }

    public DeliveryOrderOptionBuilder withDeal(Deal deal) {
        this.deal = deal;
        return this;
    }

    public DeliveryOrderOptionBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public DeliveryOrderOptionBuilder withType(ProductType type) {
        this.type = type;
        return this;
    }

    public DeliveryOrderOptionBuilder withStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    public DeliveryOrderOptionBuilder withCancelStatus(CancelStatus cancelStatus) {
        this.cancelStatus = cancelStatus;
        return this;
    }

    public DeliveryOrderOptionBuilder withSalePrice(int salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public DeliveryOrderOptionBuilder withCostPrice(int costPrice) {
        this.costPrice = costPrice;
        return this;
    }

    public DeliveryOrderOption build() {
        DeliveryOrderOption deliveryOrderOption = new DeliveryOrderOption();
        deliveryOrderOption.setId(id);
        deliveryOrderOption.setCreatedAt(createdAt);
        deliveryOrderOption.setOption(option);
        deliveryOrderOption.setUpdatedAt(updatedAt);
        deliveryOrderOption.setDeliveryStatus(deliveryStatus);
        deliveryOrderOption.setClientId(clientId);
        deliveryOrderOption.setOrder(order);
        deliveryOrderOption.setDeal(deal);
        deliveryOrderOption.setTitle(title);
        deliveryOrderOption.setType(type);
        deliveryOrderOption.setStatus(status);
        deliveryOrderOption.setCancelStatus(cancelStatus);
        deliveryOrderOption.setSalePrice(salePrice);
        deliveryOrderOption.setCostPrice(costPrice);
        return deliveryOrderOption;
    }
}
