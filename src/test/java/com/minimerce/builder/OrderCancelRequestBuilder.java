package com.minimerce.builder;

import com.minimerce.core.object.order.cancel.OrderCancelRequest;
import org.assertj.core.util.Lists;

import java.util.List;

/**
 * Created by gemini on 23/06/2017.
 */
public final class OrderCancelRequestBuilder {
    private Long orderId = 1L;
    private List<Long> orderOptionId = Lists.newArrayList();

    private OrderCancelRequestBuilder() {
    }

    public static OrderCancelRequestBuilder anOrderCancelRequest() {
        return new OrderCancelRequestBuilder();
    }

    public OrderCancelRequestBuilder withOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public OrderCancelRequestBuilder withOrderOptionId(List<Long> orderOptionId) {
        this.orderOptionId = orderOptionId;
        return this;
    }

    public OrderCancelRequestBuilder but() {
        return anOrderCancelRequest().withOrderId(orderId).withOrderOptionId(orderOptionId);
    }

    public OrderCancelRequest build() {
        OrderCancelRequest orderCancelRequest = new OrderCancelRequest();
        orderCancelRequest.setOrderId(orderId);
        orderCancelRequest.setOrderOptionId(orderOptionId);
        return orderCancelRequest;
    }
}
