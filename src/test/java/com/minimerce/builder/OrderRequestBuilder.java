package com.minimerce.builder;

import com.minimerce.core.object.order.OrderRequest;
import com.minimerce.core.object.order.OrderRequestDetail;
import org.assertj.core.util.Lists;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by gemini on 09/04/2017.
 */
public final class OrderRequestBuilder {
    private Long clientOrderId = 1L;
    private Long customerId = 1L;
    private int price = 10000;
    private LocalDateTime orderedAt = LocalDateTime.now();
    private List<OrderRequestDetail> details = Lists.newArrayList();

    private OrderRequestBuilder() {
    }

    public static OrderRequestBuilder anOrderRequest() {
        return new OrderRequestBuilder();
    }

    public OrderRequestBuilder withClientOrderId(Long clientOrderId) {
        this.clientOrderId = clientOrderId;
        return this;
    }

    public OrderRequestBuilder withCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public OrderRequestBuilder withPrice(int price) {
        this.price = price;
        return this;
    }

    public OrderRequestBuilder withOrderedAt(LocalDateTime orderedAt) {
        this.orderedAt = orderedAt;
        return this;
    }

    public OrderRequestBuilder withDetails(List<OrderRequestDetail> details) {
        this.details = details;
        return this;
    }

    public OrderRequest build() {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setClientOrderId(clientOrderId);
        orderRequest.setCustomerId(customerId);
        orderRequest.setPrice(price);
        orderRequest.setOrderedAt(orderedAt);
        orderRequest.setDetails(details);
        return orderRequest;
    }
}
