package com.minimerce.core.component.order.option.validator;

import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.object.order.status.CancelStatus;
import com.minimerce.core.object.order.status.OrderStatus;
import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.response.ErrorCode;
import org.springframework.stereotype.Component;

/**
 * Created by gemini on 27/06/2017.
 */
@Component
public class UsableOrderStatusValidator {
    public void validate(OrderOption option) {
        if(OrderStatus.USED == option.getStatus()) throw new MinimerceException(ErrorCode.ALREADY_USE_COMPLETED_ORDER);
        if(CancelStatus.CANCEL == option.getCancelStatus()) throw new MinimerceException(ErrorCode.ALREADY_CANCELED_ORDER);
    }
}
