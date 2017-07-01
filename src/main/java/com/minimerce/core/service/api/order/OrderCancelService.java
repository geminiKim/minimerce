package com.minimerce.core.service.api.order;

import com.minimerce.core.component.order.OrderCanceler;
import com.minimerce.core.component.order.OrderFinder;
import com.minimerce.core.component.order.OrderStatusValidator;
import com.minimerce.core.domain.client.Client;
import com.minimerce.core.domain.order.Order;
import com.minimerce.core.object.order.FindOrderRequest;
import com.minimerce.core.object.order.cancel.OrderCancelRequest;
import org.springframework.stereotype.Service;

/**
 * Created by gemini on 20/06/2017.
 */
@Service
public class OrderCancelService {
    private final OrderFinder orderFinder;
    private final OrderStatusValidator orderStatusValidator;
    private final OrderCanceler orderCanceler;

    public OrderCancelService(OrderFinder orderFinder, OrderStatusValidator orderStatusValidator, OrderCanceler orderCanceler) {

        this.orderFinder = orderFinder;
        this.orderStatusValidator = orderStatusValidator;
        this.orderCanceler = orderCanceler;
    }

    public void cancel(Client client, OrderCancelRequest request) {
        Order order = orderFinder.findOrder(client.getId(), FindOrderRequest.of(request.getOrderId()));
        orderStatusValidator.validate(order.getOptions());
        orderCanceler.cancel(order.getOptions());
    }
}
