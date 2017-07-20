package com.minimerce.core.domain.order.option.delivery;

/**
 * Created by gemini on 17/07/2017.
 */
public enum DeliveryStatus {
    WAIT, PREPARE, SENDING, FINISH;

    public boolean isDeliveryPrepare() {
        return this == WAIT || this == PREPARE;
    }
    public boolean isDeliveryStarted() {
        return this == SENDING;
    }

    public boolean isDeliveryFinished() {
        return this == FINISH;
    }
}
