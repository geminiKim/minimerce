package com.minimerce.core.service.api.order;

import com.minimerce.core.component.order.OrderFinder;
import com.minimerce.core.component.order.OrderInserter;
import com.minimerce.core.component.order.OrderMaker;
import com.minimerce.core.component.stock.StockProcessor;
import com.minimerce.core.domain.client.Client;
import com.minimerce.core.domain.order.Order;
import com.minimerce.core.object.order.FindOrderRequest;
import com.minimerce.core.object.order.OrderRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by gemini on 20/04/2017.
 */
@Service
public class OrderService {
    private final OrderMaker orderMaker;
    private final OrderInserter orderInserter;
    private final OrderFinder orderFinder;
    private final StockProcessor stockProcessor;

    @Inject
    public OrderService(OrderMaker orderMaker, OrderInserter orderInserter, OrderFinder orderFinder, StockProcessor stockProcessor) {
        this.orderMaker = orderMaker;
        this.orderInserter = orderInserter;
        this.orderFinder = orderFinder;
        this.stockProcessor = stockProcessor;
    }

    public Order order(Client client, OrderRequest request) {
        Order order = orderMaker.make(client.getId(), request);
        stockProcessor.reduce(order.getOptions());
        return orderInserter.insert(order);
    }

    public Order findOrder(Client client, FindOrderRequest request) {
        return orderFinder.findOrder(client.getId(), request);
    }

    public Page<Order> findCustomerOrders(Client client, Long customerId, Pageable page) {
        return orderFinder.findOrders(client.getId(), customerId, page);
    }
}
