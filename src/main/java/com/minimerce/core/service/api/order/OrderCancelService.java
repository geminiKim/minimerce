package com.minimerce.core.service.api.order;

import com.minimerce.core.component.order.OrderCanceler;
import com.minimerce.core.component.order.OrderFinder;
import com.minimerce.core.component.order.option.validator.OrderStatusValidator;
import com.minimerce.core.component.stock.StockProcessor;
import com.minimerce.core.domain.client.Client;
import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.object.order.cancel.OrderCancelRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gemini on 20/06/2017.
 */
@Service
public class OrderCancelService {
    private final OrderFinder orderFinder;
    private final OrderStatusValidator orderStatusValidator;
    private final StockProcessor stockProcessor;
    private final OrderCanceler orderCanceler;

    public OrderCancelService(OrderFinder orderFinder, OrderStatusValidator orderStatusValidator, StockProcessor stockProcessor, OrderCanceler orderCanceler) {
        this.orderFinder = orderFinder;
        this.orderStatusValidator = orderStatusValidator;
        this.stockProcessor = stockProcessor;
        this.orderCanceler = orderCanceler;
    }

    public void cancel(Client client, OrderCancelRequest request) {
        List<OrderOption> options = orderFinder.findCancelOptions(client.getId(), request);
        orderStatusValidator.validate(options);
        stockProcessor.restore(options);
        orderCanceler.cancel(options);
    }
}
