package com.minimerce.builder;

import com.google.common.collect.Lists;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.order.Order;
import com.minimerce.domain.order.item.OrderItem;
import com.minimerce.domain.order.option.OrderOption;
import com.minimerce.object.order.CancelStatus;
import com.minimerce.object.order.OrderStatus;
import com.minimerce.object.type.DealType;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by gemini on 04/04/2017.
 */
public final class OrderOptionBuilder {
    private Long id = 1L;
    private Long clientId = 1L;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private String title = "Test Order Detail";
    private int price = 5000;
    private OrderStatus status = OrderStatus.ORDERED;
    private CancelStatus cancelStatus = CancelStatus.NOT_CANCEL;
    private List<OrderItem> items = Lists.newArrayList();
    private Order order = new Order();
    private Deal deal = new Deal();
    private DealOption dealOption = new DealOption();
    private DealType type = DealType.USABLE;

    private OrderOptionBuilder() {
    }

    public static OrderOptionBuilder anOrderOption() {
        return new OrderOptionBuilder();
    }

    public OrderOptionBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public OrderOptionBuilder withClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public OrderOptionBuilder withCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public OrderOptionBuilder withUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public OrderOptionBuilder withOrder(Order order) {
        this.order = order;
        return this;
    }

    public OrderOptionBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public OrderOptionBuilder withPrice(int price) {
        this.price = price;
        return this;
    }

    public OrderOptionBuilder withStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    public OrderOptionBuilder withCancelStatus(CancelStatus cancelStatus) {
        this.cancelStatus = cancelStatus;
        return this;
    }

    public OrderOptionBuilder withDeal(Deal deal) {
        this.deal = deal;
        return this;
    }

    public OrderOptionBuilder withDealOption(DealOption dealOption) {
        this.dealOption = dealOption;
        return this;
    }

    public OrderOptionBuilder withItems(List<OrderItem> items) {
        this.items = items;
        return this;
    }

    public OrderOptionBuilder withType(DealType type) {
        this.type = type;
        return this;
    }

    public OrderOption build() {
        OrderOption orderDetail = new OrderOption();
        orderDetail.setId(id);
        orderDetail.setClientId(clientId);
        orderDetail.setCreatedAt(createdAt);
        orderDetail.setUpdatedAt(updatedAt);
        orderDetail.setTitle(title);
        orderDetail.setPrice(price);
        orderDetail.setStatus(status);
        orderDetail.setCancelStatus(cancelStatus);
        orderDetail.setDeal(deal);
        orderDetail.setDealOption(dealOption);
        orderDetail.addItems(items);
        orderDetail.setOrder(order);
        orderDetail.setType(type);
        return orderDetail;
    }
}
