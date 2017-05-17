package com.minimerce.controller;

import com.minimerce.domain.client.Client;
import com.minimerce.domain.order.Order;
import com.minimerce.object.order.FindOrderRequest;
import com.minimerce.object.order.OrderRequest;
import com.minimerce.service.order.OrderService;
import com.minimerce.support.exception.MinimerceException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by gemini on 28/04/2017.
 */
@RestController
@RequestMapping(value = "/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @Inject
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order order(@AuthenticationPrincipal Client client, OrderRequest request) throws MinimerceException {
        return orderService.order(client.getId(), request);
    }
    @GetMapping
    public Order findOrder(@AuthenticationPrincipal Client client, @RequestParam(required = false) long orderId, @RequestParam(required = false) long clientOrderId) throws MinimerceException {
        return orderService.findOrder(client.getId(), new FindOrderRequest(orderId, clientOrderId));
    }
}
