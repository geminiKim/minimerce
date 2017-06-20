package com.minimerce.controller.api;

import com.minimerce.controller.BaseController;
import com.minimerce.core.domain.client.Client;
import com.minimerce.core.domain.order.Order;
import com.minimerce.core.service.api.order.OrderService;
import com.minimerce.core.support.object.response.MinimerceApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by gemini on 25/05/2017.
 */
@RestController
@RequestMapping(value = "/v1/customers")
public class CustomerController extends BaseController {
    private final OrderService orderService;

    @Inject
    public CustomerController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/{customerId}/orders")
    public MinimerceApiResponse findCustomerOrders(@AuthenticationPrincipal Client client, @PathVariable Long customerId, Pageable page)  {
        Page<Order> orders = orderService.findCustomerOrders(client.getId(), customerId, page);
        return MinimerceApiResponse.ok(orders);
    }
}
