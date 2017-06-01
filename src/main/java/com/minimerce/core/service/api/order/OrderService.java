package com.minimerce.core.service.api.order;

import com.minimerce.core.component.item.StockReducer;
import com.minimerce.core.component.order.OrderFinder;
import com.minimerce.core.component.order.OrderInserter;
import com.minimerce.core.component.order.OrderMaker;
import com.minimerce.core.domain.order.Order;
import com.minimerce.core.support.object.order.FindOrderRequest;
import com.minimerce.core.support.object.order.OrderRequest;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 20/04/2017.
 */
@Service
public class OrderService {
    private final OrderMaker orderMaker;
    private final OrderInserter orderInserter;
    private final OrderFinder orderFinder;
    private final StockReducer stockReducer;

    @Inject
    public OrderService(OrderMaker orderMaker, OrderInserter orderInserter, OrderFinder orderFinder, StockReducer stockReducer) {
        this.orderMaker = orderMaker;
        this.orderInserter = orderInserter;
        this.orderFinder = orderFinder;
        this.stockReducer = stockReducer;
    }

    public Order order(Long clientId, OrderRequest request) {
        Order order = orderMaker.make(clientId, request);
        stockReducer.reduce(order);
        return orderInserter.insert(order);
    }

    public Order findOrder(Long clientId, FindOrderRequest request) {
        return orderFinder.findOrder(clientId, request);
    }

    public List<Order> findCustomerOrders(Long clientId, Long customerId) {
        return orderFinder.findOrders(clientId, customerId);
    }
}
