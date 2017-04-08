package com.minimerce.controller;

import com.minimerce.domain.order.Order;
import com.minimerce.domain.order.OrderRepository;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(method = RequestMethod.POST)
    public String saveOrder(@RequestBody Order order) {
        order.getDetails().forEach(e -> {
            e.setOrderId(order.getId());
            e.getItems().forEach(i -> i.setDetailId(i.getId()));
        });
        orderRepository.save(order);
        return "OK";
    }
}
