package com.minimerce.builder;

import com.minimerce.core.object.order.cancel.OrderCancelResponseDetail;
import com.minimerce.core.support.response.ApiResult;
import com.minimerce.core.support.response.ResultCode;

/**
 * Created by gemini on 25/06/2017.
 */
public final class OrderCancelResponseDetailBuilder {
    private Long orderOptionId = 1L;
    private ApiResult result = ResultCode.SUCCESS;

    private OrderCancelResponseDetailBuilder() {
    }

    public static OrderCancelResponseDetailBuilder anOrderCancelResponseDetail() {
        return new OrderCancelResponseDetailBuilder();
    }

    public OrderCancelResponseDetailBuilder withOrderOptionId(Long orderOptionId) {
        this.orderOptionId = orderOptionId;
        return this;
    }

    public OrderCancelResponseDetailBuilder withResult(ApiResult result) {
        this.result = result;
        return this;
    }

    public OrderCancelResponseDetail build() {
        OrderCancelResponseDetail orderCancelResponseDetail = new OrderCancelResponseDetail();
        orderCancelResponseDetail.setOrderOptionId(orderOptionId);
        orderCancelResponseDetail.setResult(result);
        return orderCancelResponseDetail;
    }
}
