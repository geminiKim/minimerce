package com.minimerce.core.component.order;

import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.object.order.cancel.OrderCancelResponse;
import com.minimerce.core.object.order.status.CancelStatus;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by gemini on 25/06/2017.
 */
@Component
public class OrderCanceler {
    public OrderCancelResponse cancel(List<OrderOption> options) {
        for (OrderOption option : options) {
            option.setCancelStatus(CancelStatus.CANCEL);
        }
        return null;
    }
}
