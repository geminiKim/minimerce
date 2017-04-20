package com.minimerce.service.order;

import com.minimerce.component.order.OrderFinder;
import com.minimerce.component.order.OrderMaker;
import com.minimerce.domain.order.Order;
import com.minimerce.object.order.FindOrderRequest;
import com.minimerce.object.order.OrderRequest;
import com.minimerce.support.exception.NotExistOrderException;
import com.minimerce.support.exception.UnsaleableProductException;
import com.minimerce.support.exception.UnsupportedItemTypeException;
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
