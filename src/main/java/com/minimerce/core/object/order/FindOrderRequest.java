package com.minimerce.core.object.order;

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

    public FindOrderRequest(Long orderId, Long clientOrderId) {
        this.orderId = orderId;
        this.clientOrderId = clientOrderId;
    }

    public boolean isFindByOrderId() {
        return orderId != null && clientOrderId == null;
    }
}
