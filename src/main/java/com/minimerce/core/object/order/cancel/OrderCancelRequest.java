package com.minimerce.core.object.order.cancel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by gemini on 23/06/2017.
 */
@Getter
@Setter
public class OrderCancelRequest {
    private Long orderId;
    private List<Long> orderOptionId;
}
