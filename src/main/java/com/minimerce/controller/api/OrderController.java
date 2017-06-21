package com.minimerce.controller.api;

import com.minimerce.controller.BaseController;
import com.minimerce.core.domain.client.Client;
import com.minimerce.core.domain.deal.option.usable.UsableOption;
import com.minimerce.core.domain.order.Order;
import com.minimerce.core.service.api.order.OrderService;
import com.minimerce.core.support.object.order.FindOrderRequest;
import com.minimerce.core.support.object.order.OrderRequest;
import com.minimerce.core.support.object.response.MinimerceApiResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by gemini on 28/04/2017.
 */
@RestController
@RequestMapping(value = "/v1/orders")
public class OrderController extends BaseController {
    private final OrderService orderService;

    @Inject
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation(value = "new Order Request", tags = "Orders" , notes = "You can place a new Order.")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "data", response = Order.class),
            @ApiResponse(code = 1, message = "data->options (If you ordered the UsableOption.", response = UsableOption.class)
    })
    @PostMapping
    public MinimerceApiResponse order(@AuthenticationPrincipal Client client, @RequestBody OrderRequest request) {
        Order order = orderService.order(client.getId(), request);
        return MinimerceApiResponse.ok(order);
    }

    @ApiOperation(value = "Find Order", tags = "Orders" , notes = "You can use orderId or clientOrderId to view Order.")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "data", response = Order.class),
            @ApiResponse(code = 1, message = "data->options (If you ordered the UsableOption.", response = UsableOption.class)
    })
    @GetMapping
    public MinimerceApiResponse findOrder(@AuthenticationPrincipal Client client,
                                          @RequestParam(required = false) Long orderId,
                                          @RequestParam(required = false) Long clientOrderId)  {
        Order order = orderService.findOrder(client.getId(), new FindOrderRequest(orderId, clientOrderId));
        return MinimerceApiResponse.ok(order);
    }
}
