package com.minimerce.builder;

import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.order.Order;
import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.object.order.CancelStatus;
import com.minimerce.core.object.order.OrderStatus;
import com.minimerce.core.object.type.ProductType;

import java.time.LocalDateTime;

/**
 * Created by gemini on 04/04/2017.
 */
public final class OrderOptionBuilder {
    private Long id = 1L;
    private Long clientId = 1L;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private String title = "Test Order Detail";
    private int salePrice = 5000;
    private int costPrice = 300;
    private OrderStatus status = OrderStatus.ORDERED;
    private CancelStatus cancelStatus = CancelStatus.NOT_CANCEL;
    private Order order = new Order();
    private Deal deal = new Deal();
    private ProductType type = ProductType.USABLE;

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

    public OrderOptionBuilder withSalePrice(int salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public OrderOptionBuilder withCostPrice(int costPrice) {
        this.costPrice = costPrice;
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

    public OrderOptionBuilder withType(ProductType type) {
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
        orderDetail.setSalePrice(salePrice);
        orderDetail.setCostPrice(costPrice);
        orderDetail.setStatus(status);
        orderDetail.setCancelStatus(cancelStatus);
        orderDetail.setDeal(deal);
        orderDetail.setType(type);
        order.addOption(orderDetail);
        return orderDetail;
    }
}
