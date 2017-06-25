package com.minimerce.core.object.order.cancel;

import com.minimerce.core.support.response.ApiResult;

import java.util.List;

/**
 * Created by gemini on 23/06/2017.
 */
public class OrderCancelResponse {
    private Long orderId;
    private ApiResult result;
    private List<OrderCancelReponseDetail> details;
}
