package com.minimerce.controller;

import com.minimerce.core.api.domain.client.Client;
import com.minimerce.core.api.domain.order.Order;
import com.minimerce.core.api.object.order.FindOrderRequest;
import com.minimerce.core.api.object.order.OrderRequest;
import com.minimerce.core.api.order.OrderService;
import com.minimerce.core.api.support.exception.MinimerceException;
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
    public Order findOrder(@AuthenticationPrincipal Client client, @RequestParam(required = false) Long orderId, @RequestParam(required = false) Long clientOrderId) throws MinimerceException {
        return orderService.findOrder(client.getId(), new FindOrderRequest(orderId, clientOrderId));
    }
}
