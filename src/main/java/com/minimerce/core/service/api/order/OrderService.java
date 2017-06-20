package com.minimerce.core.service.api.order;

import com.minimerce.core.component.order.OrderFinder;
import com.minimerce.core.component.order.OrderInserter;
import com.minimerce.core.component.order.OrderMaker;
import com.minimerce.core.component.stock.StockProcessor;
import com.minimerce.core.domain.order.Order;
import com.minimerce.core.support.object.order.FindOrderRequest;
import com.minimerce.core.support.object.order.OrderRequest;
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

    public Order order(Long clientId, OrderRequest request) {
        Order order = orderMaker.make(clientId, request);
        stockProcessor.reduce(request);
        return orderInserter.insert(order);
    }

    public Order findOrder(Long clientId, FindOrderRequest request) {
        return orderFinder.findOrder(clientId, request);
    }

    public Page<Order> findCustomerOrders(Long clientId, Long customerId, Pageable page) {
        return orderFinder.findOrders(clientId, customerId, page);
    }
}
