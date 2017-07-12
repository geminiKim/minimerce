package com.minimerce.controller.api;

import com.minimerce.controller.BaseController;
import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.DealStatus;
import com.minimerce.core.domain.deal.option.usable.UsableOption;
import com.minimerce.core.object.deal.FindDealRequest;
import com.minimerce.core.service.api.deal.DealService;
import com.minimerce.core.support.response.MinimerceApiResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by gemini on 13/07/2017.
 */
@RestController
@RequestMapping(value = "/v1/deals")
public class DealController extends BaseController {
    private final DealService dealService;

    @Inject
    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @ApiOperation(value = "Find Deals", tags = "Deals" , notes = "You can use find Deal List")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "data", response = Deal.class),
            @ApiResponse(code = 1, message = "data->options (If deal type the UsableOption.)", response = UsableOption.class)
    })
    @GetMapping
    public MinimerceApiResponse findDeals(@RequestParam(required = false) DealStatus status,
                                          Pageable page)  {
        Page<Deal> deals = dealService.findDeals(new FindDealRequest(status), page);
        return MinimerceApiResponse.ok(deals);
    }

    @ApiOperation(value = "Find Deal", tags = "Deals" , notes = "You can use find Deal Detail")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "data", response = Deal.class),
            @ApiResponse(code = 1, message = "data->options (If deal type the UsableOption.)", response = UsableOption.class)
    })
    @GetMapping(value = "/{dealId}")
    public MinimerceApiResponse findDeal(long dealId)  {
        Deal deal = dealService.findDeal(dealId);
        return MinimerceApiResponse.ok(deal);
    }
}
