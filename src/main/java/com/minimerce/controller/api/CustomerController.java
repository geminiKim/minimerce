package com.minimerce.controller.api;

import com.minimerce.controller.BaseController;
import com.minimerce.core.domain.client.Client;
import com.minimerce.core.domain.deal.option.usable.UsableOption;
import com.minimerce.core.domain.order.Order;
import com.minimerce.core.object.response.MinimerceApiResponse;
import com.minimerce.core.service.api.order.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Find Orders By CustomerId", tags = "Customers" , notes = "You can use CustomerId to view customer order history.")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "pageable", response = Page.class),
            @ApiResponse(code = 1, message = "data->content", response = Order.class),
            @ApiResponse(code = 2, message = "data->content->options (If you ordered the UsableOption.", response = UsableOption.class)
    })
    @GetMapping(value = "/{customerId}/orders")
    public MinimerceApiResponse findCustomerOrders(@AuthenticationPrincipal Client client, @PathVariable Long customerId, Pageable page)  {
        Page<Order> orders = orderService.findCustomerOrders(client, customerId, page);
        return MinimerceApiResponse.ok(orders);
    }
}
