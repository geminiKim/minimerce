package com.minimerce.builder;

import com.google.common.collect.Lists;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.order.Order;
import com.minimerce.domain.order.detail.OrderDetail;
import com.minimerce.domain.order.item.OrderItem;
import com.minimerce.domain.order.status.CancelStatus;
import com.minimerce.domain.order.status.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by gemini on 04/04/2017.
 */
public final class OrderDetailBuilder {
    private Long id = 1L;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private Long clientId = 1L;
    private Long clientDetailId = 1L;
    private Long customerId = 1L;
    private String title = "Test Order Detail";
    private int price = 5000;
    private OrderStatus status = OrderStatus.NONE;
    private CancelStatus cancelStatus = CancelStatus.NONE;
    private List<OrderItem> items = Lists.newArrayList();
    private Order order = new Order();
    private Deal deal = new Deal();
    private DealOption dealOption = new DealOption();

    private OrderDetailBuilder() {
    }

    public static OrderDetailBuilder anOrderDetail() {
        return new OrderDetailBuilder();
    }

    public OrderDetailBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public OrderDetailBuilder withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public OrderDetailBuilder withUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public OrderDetailBuilder withClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public OrderDetailBuilder withOrder(Order order) {
        this.order = order;
        return this;
    }

    public OrderDetailBuilder withClientDetailId(Long clientDetailId) {
        this.clientDetailId = clientDetailId;
        return this;
    }

    public OrderDetailBuilder withCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public OrderDetailBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public OrderDetailBuilder withPrice(int price) {
        this.price = price;
        return this;
    }

    public OrderDetailBuilder withStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    public OrderDetailBuilder withCancelStatus(CancelStatus cancelStatus) {
        this.cancelStatus = cancelStatus;
        return this;
    }

    public OrderDetailBuilder withDeal(Deal deal) {
        this.deal = deal;
        return this;
    }

    public OrderDetailBuilder withDealOption(DealOption dealOption) {
        this.dealOption = dealOption;
        return this;
    }

    public OrderDetailBuilder withItems(List<OrderItem> items) {
        this.items = items;
        return this;
    }

    public OrderDetail build() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(id);
        orderDetail.setCreatedAt(createdAt);
        orderDetail.setUpdatedAt(updatedAt);
        orderDetail.setClientId(clientId);
        orderDetail.setClientDetailId(clientDetailId);
        orderDetail.setCustomerId(customerId);
        orderDetail.setTitle(title);
        orderDetail.setPrice(price);
        orderDetail.setStatus(status);
        orderDetail.setCancelStatus(cancelStatus);
        orderDetail.setDeal(deal);
        orderDetail.setDealOption(dealOption);
        orderDetail.addItems(items);
        orderDetail.setOrder(order);
        return orderDetail;
    }
}
