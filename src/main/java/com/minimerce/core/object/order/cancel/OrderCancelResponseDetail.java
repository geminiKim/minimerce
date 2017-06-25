package com.minimerce.core.object.order.cancel;

import com.minimerce.core.support.response.ApiResult;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by gemini on 25/06/2017.
 */
@Getter
@Setter
public class OrderCancelResponseDetail {
    private Long orderOptionId;
    private ApiResult result;
}
