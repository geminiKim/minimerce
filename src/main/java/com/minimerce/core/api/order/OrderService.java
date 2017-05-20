package com.minimerce.core.api.order;

import com.minimerce.core.api.component.order.OrderFinder;
import com.minimerce.core.api.component.order.OrderMaker;
import com.minimerce.core.api.domain.order.Order;
import com.minimerce.core.api.object.order.FindOrderRequest;
import com.minimerce.core.api.object.order.OrderRequest;
import com.minimerce.core.api.support.exception.NotExistOrderException;
import com.minimerce.core.api.support.exception.UnsaleableProductException;
import com.minimerce.core.api.support.exception.UnsupportedItemTypeException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 20/04/2017.
 */
@Service
public class OrderService {
    private final OrderMaker orderMaker;
    private final OrderFinder orderFinder;

    @Inject
    public OrderService(OrderMaker orderMaker, OrderFinder orderFinder) {
        this.orderMaker = orderMaker;
        this.orderFinder = orderFinder;
    }

    public Order order(Long clientId, OrderRequest request) throws UnsaleableProductException, UnsupportedItemTypeException {
        return orderMaker.make(clientId, request);
    }

    public List<Order> findOrders(Long clientId, Long customerId) throws UnsaleableProductException, UnsupportedItemTypeException, NotExistOrderException {
        return orderFinder.findOrders(clientId, customerId);
    }

    public Order findOrder(Long clientId, FindOrderRequest request) throws UnsaleableProductException, UnsupportedItemTypeException, NotExistOrderException {
        return orderFinder.findOrder(clientId, request);
    }
}
