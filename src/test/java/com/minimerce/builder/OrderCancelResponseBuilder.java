package com.minimerce.builder;

import com.minimerce.core.object.order.cancel.OrderCancelResponse;
import com.minimerce.core.object.order.cancel.OrderCancelResponseDetail;
import com.minimerce.core.support.response.ApiResult;
import com.minimerce.core.support.response.ResultCode;

import java.util.List;

/**
 * Created by gemini on 25/06/2017.
 */
public final class OrderCancelResponseBuilder {
    private Long orderId = 1L;
    private ApiResult result = ResultCode.SUCCESS;
    private List<OrderCancelResponseDetail> details = null;

    private OrderCancelResponseBuilder() {
    }

    public static OrderCancelResponseBuilder anOrderCancelResponse() {
        return new OrderCancelResponseBuilder();
    }

    public OrderCancelResponseBuilder withOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public OrderCancelResponseBuilder withResult(ApiResult result) {
        this.result = result;
        return this;
    }

    public OrderCancelResponseBuilder withDetails(List<OrderCancelResponseDetail> details) {
        this.details = details;
        return this;
    }

    public OrderCancelResponse build() {
        OrderCancelResponse orderCancelResponse = new OrderCancelResponse();
        orderCancelResponse.setOrderId(orderId);
        orderCancelResponse.setResult(result);
        orderCancelResponse.setDetails(details);
        return orderCancelResponse;
    }
}
