package com.minimerce.builder;

import com.minimerce.core.object.order.OrderRequestDetail;

/**
 * Created by gemini on 09/04/2017.
 */
public final class OrderRequestDetailBuilder {
    private Long dealId = 1L;
    private Long optionId = 1L;
    private int price = 5000;
    private int unitPrice = 5000;
    private int quantity = 1;

    private OrderRequestDetailBuilder() {
    }

    public static OrderRequestDetailBuilder anOrderRequestDetail() {
        return new OrderRequestDetailBuilder();
    }

    public OrderRequestDetailBuilder withDealId(Long dealId) {
        this.dealId = dealId;
        return this;
    }

    public OrderRequestDetailBuilder withOptionId(Long optionId) {
        this.optionId = optionId;
        return this;
    }

    public OrderRequestDetailBuilder withPrice(int price) {
        this.price = price;
        return this;
    }

    public OrderRequestDetailBuilder withUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public OrderRequestDetailBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderRequestDetail build() {
        OrderRequestDetail orderRequestDetail = new OrderRequestDetail();
        orderRequestDetail.setDealId(dealId);
        orderRequestDetail.setOptionId(optionId);
        orderRequestDetail.setPrice(price);
        orderRequestDetail.setUnitPrice(unitPrice);
        orderRequestDetail.setQuantity(quantity);
        return orderRequestDetail;
    }
}
