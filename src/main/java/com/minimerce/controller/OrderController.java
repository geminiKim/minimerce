package com.minimerce.controller;

import com.minimerce.domain.order.Order;
import com.minimerce.domain.order.OrderRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by gemini on 28/03/2017.
 */
@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    private final OrderRepository orderRepository;

    @Inject
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public Order findOrder(@PathVariable Long orderId) {
        return orderRepository.findOne(orderId);
    }
}
