package com.minimerce.builder;

import com.minimerce.core.support.object.order.FindOrderRequest;

/**
 * Created by gemini on 20/04/2017.
 */
public final class FindOrderRequestBuilder {
    private Long orderId = null;
    private Long clientOrderId = null;

    private FindOrderRequestBuilder() {
    }

    public static FindOrderRequestBuilder aFindOrderRequest() {
        return new FindOrderRequestBuilder();
    }

    public FindOrderRequestBuilder withOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public FindOrderRequestBuilder withClientOrderId(Long clientOrderId) {
        this.clientOrderId = clientOrderId;
        return this;
    }

    public FindOrderRequest build() {
        return new FindOrderRequest(orderId, clientOrderId);
    }
}
