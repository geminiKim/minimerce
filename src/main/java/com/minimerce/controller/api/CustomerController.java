package com.minimerce.controller.api;

import com.minimerce.controller.BaseController;
import com.minimerce.core.api.domain.client.Client;
import com.minimerce.core.api.domain.order.Order;
import com.minimerce.core.api.service.order.OrderService;
import com.minimerce.core.api.support.object.response.ApiResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

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
    public ApiResponse findCustomerOrders(@AuthenticationPrincipal Client client, @PathVariable Long customerId)  {
        List<Order> orders = orderService.findCustomerOrders(client.getId(), customerId);
        return ApiResponse.ok(orders);
    }
}
