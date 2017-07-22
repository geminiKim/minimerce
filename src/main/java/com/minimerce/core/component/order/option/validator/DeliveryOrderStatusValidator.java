package com.minimerce.core.component.order.option.validator;

import com.minimerce.core.domain.order.option.delivery.DeliveryOrderOption;
import com.minimerce.core.object.order.status.CancelStatus;
import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.response.ErrorCode;
import org.springframework.stereotype.Component;

/**
 * Created by gemini on 21/07/2017.
 */
@Component
public class DeliveryOrderStatusValidator {
    public void validate(DeliveryOrderOption option) {
        if(option.getDeliveryStatus().isDeliveryStarted()) throw new MinimerceException(ErrorCode.DELIVERY_STARTED_ORDER);
        if(option.getDeliveryStatus().isDeliveryFinished()) throw new MinimerceException(ErrorCode.DELIVERY_FINISHED_ORDER);
        if(CancelStatus.CANCEL == option.getCancelStatus()) throw new MinimerceException(ErrorCode.ALREADY_CANCELED_ORDER);
    }
}
