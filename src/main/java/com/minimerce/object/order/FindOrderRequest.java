package com.minimerce.object.order;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by gemini on 20/04/2017.
 */
@Getter
@Setter
public class FindOrderRequest {
    private Long orderId;
    private Long clientOrderId;

    public boolean isFindByOrderId() {
        return orderId != null && clientOrderId == null;
    }
    public boolean isFindByClientOrderId() {
        return orderId == null && clientOrderId != null;
    }
}
