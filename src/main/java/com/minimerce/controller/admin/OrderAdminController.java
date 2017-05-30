package com.minimerce.controller.admin;

import com.minimerce.controller.BaseController;
import com.minimerce.core.admin.order.UsableOrderAdminService;
import com.minimerce.core.api.support.object.response.ApiResponse;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by gemini on 30/05/2017.
 */
@RestController
@RequestMapping(value = "/admin/v1/orders")
public class OrderAdminController extends BaseController {
    private final UsableOrderAdminService usableOrderService;

    @Inject
    public OrderAdminController(UsableOrderAdminService usableOrderService) {
        this.usableOrderService = usableOrderService;
    }

    @PutMapping(value = "/usable/{orderItemId}/consume")
    public ApiResponse consumeUsableOrder(@PathVariable Long orderItemId)  {
        usableOrderService.consume(orderItemId);
        return ApiResponse.ok();
    }
    @PutMapping(value = "/usable/{orderItemId}/restore")
    public ApiResponse restoreUsableOrder(@PathVariable Long orderItemId)  {
        usableOrderService.restore(orderItemId);
        return ApiResponse.ok();
    }

}
