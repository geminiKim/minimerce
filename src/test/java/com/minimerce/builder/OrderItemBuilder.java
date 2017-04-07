package com.minimerce.builder;

import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.order.Order;
import com.minimerce.domain.order.detail.OrderDetail;
import com.minimerce.domain.order.item.OrderItem;
import com.minimerce.domain.order.status.CancelStatus;
import com.minimerce.domain.order.status.OrderStatus;
import com.minimerce.domain.type.DealType;

import java.time.LocalDateTime;

/**
 * Created by gemini on 04/04/2017.
 */
public final class OrderItemBuilder {
    private static final OrderDetailBuilder detailBuilder = OrderDetailBuilder.anOrderDetail();
    private static final DealOptionBuilder optionBuilder = DealOptionBuilder.aDealOption();
    private Order order = OrderBuilder.anOrder().build();
    private OrderDetail detail = detailBuilder.build();
    private Deal deal = DealBuilder.aDeal().build();
    private DealOption dealOption = optionBuilder.build();
    private Long id = 1L;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private Long clientId = 1L;
    private Long customerId = 1L;
    private String title = "Test Order Item";
    private DealType type = DealType.STOCK;
    private int salePrice = 1000;
    private int costPrice = 500;
    private OrderStatus status = OrderStatus.NONE;
    private CancelStatus cancelStatus = CancelStatus.NONE;
    private int groupId = 1;

    private OrderItemBuilder() {
    }

    public static OrderItemBuilder anOrderItem() {
        return new OrderItemBuilder();
    }

    public OrderItemBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public OrderItemBuilder withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public OrderItemBuilder withUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public OrderItemBuilder withClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public OrderItemBuilder withCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public OrderItemBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public OrderItemBuilder withType(DealType type) {
        this.type = type;
        return this;
    }

    public OrderItemBuilder withSalePrice(int salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public OrderItemBuilder withCostPrice(int costPrice) {
        this.costPrice = costPrice;
        return this;
    }

    public OrderItemBuilder withStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    public OrderItemBuilder withCancelStatus(CancelStatus cancelStatus) {
        this.cancelStatus = cancelStatus;
        return this;
    }

    public OrderItemBuilder withGroupId(int groupId) {
        this.groupId = groupId;
        return this;
    }

    public OrderItemBuilder withOrder(Order order) {
        this.order = order;
        return this;
    }

    public OrderItemBuilder withDetail(OrderDetail detail) {
        this.detail = detail;
        return this;
    }

    public OrderItemBuilder withDeal(Deal deal) {
        this.deal = deal;
        return this;
    }

    public OrderItemBuilder withDealOption(DealOption dealOption) {
        this.dealOption = dealOption;
        return this;
    }

    public OrderItem build() {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(id);
        orderItem.setCreatedAt(createdAt);
        orderItem.setUpdatedAt(updatedAt);
        orderItem.setClientId(clientId);
        orderItem.setCustomerId(customerId);
        orderItem.setTitle(title);
        orderItem.setType(type);
        orderItem.setSalePrice(salePrice);
        orderItem.setCostPrice(costPrice);
        orderItem.setStatus(status);
        orderItem.setCancelStatus(cancelStatus);
        orderItem.setGroupId(groupId);
        orderItem.setOrder(order);
        orderItem.setDetail(detail);
        orderItem.setDeal(deal);
        orderItem.setDealOption(dealOption);
        return orderItem;
    }
}
