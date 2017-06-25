package com.minimerce.core.object.order.cancel;

import com.minimerce.core.support.response.ApiResult;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by gemini on 23/06/2017.
 */
@Getter
@Setter
public class OrderCancelResponse {
    private Long orderId;
    private ApiResult result;
    private List<OrderCancelResponseDetail> details;
}
