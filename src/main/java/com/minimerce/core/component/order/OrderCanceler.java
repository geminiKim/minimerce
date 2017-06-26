package com.minimerce.core.component.order;

import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.object.order.cancel.OrderCancelResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by gemini on 25/06/2017.
 */
@Component
public class OrderCanceler {
    public OrderCancelResponse cancel(List<OrderOption> options) {
        return null;
    }
}
