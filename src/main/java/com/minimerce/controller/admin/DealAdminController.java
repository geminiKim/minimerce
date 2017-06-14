package com.minimerce.controller.admin;

import com.minimerce.controller.BaseController;
import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.option.Option;
import com.minimerce.core.service.admin.deal.DealAdminService;
import com.minimerce.core.service.admin.deal.OptionAdminService;
import com.minimerce.core.support.object.response.ApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 30/05/2017.
 */
@RestController
@RequestMapping(value = "/admin/v1")
public class DealAdminController extends BaseController {
    private final DealAdminService dealService;
    private final OptionAdminService optionService;

    @Inject
    public DealAdminController(DealAdminService dealService, OptionAdminService optionService) {
        this.dealService = dealService;
        this.optionService = optionService;
    }

    @GetMapping(value = "/deals")
    public ApiResponse findDeals(Pageable pageable) {
        return ApiResponse.ok(dealService.find(pageable));
    }
    @GetMapping(value = "deals/{dealId}")
    public ApiResponse findDeal(@PathVariable Long dealId) {
        return ApiResponse.ok(dealService.find(dealId));
    }
    @PostMapping(value = "/deals") @PutMapping(value = "/deals")
    public ApiResponse saveDeals(@RequestBody List<Deal> deals) {
        dealService.save(deals);
        return ApiResponse.ok();
    }
    @PostMapping(value = "/deals/{dealId}") @PutMapping(value = "/deals/{dealId}")
    public ApiResponse saveDeal(@RequestBody Deal deal) {
        dealService.save(deal);
        return ApiResponse.ok();
    }
    @DeleteMapping(value = "/deals/{dealId}")
    public ApiResponse deleteDeal(@PathVariable Long dealId) {
        dealService.delete(dealId);
        return ApiResponse.ok();
    }


    @GetMapping(value = "/{dealId}/options")
    public ApiResponse findOptions(@PathVariable Long dealId, Pageable pageable) {
        return ApiResponse.ok(optionService.find(dealId, pageable));
    }
    @GetMapping(value = "/{dealId}/options/{optionId}")
    public ApiResponse findOption(@PathVariable Long dealId, @PathVariable Long optionId) {
        return ApiResponse.ok(optionService.find(dealId, optionId));
    }
    @PostMapping(value = "/{dealId}/options") @PutMapping(value = "/{dealId}/options")
    public ApiResponse saveOptions(@PathVariable Long dealId, @RequestBody List<Option> options) {
        optionService.save(dealId, options);
        return ApiResponse.ok();
    }
    @PostMapping(value = "/{dealId}/options/{optionId}") @PutMapping(value = "/{dealId}/options/{optionId}")
    public ApiResponse saveOption(@PathVariable Long dealId, @RequestBody Option option) {
        optionService.save(dealId, option);
        return ApiResponse.ok();
    }
    @DeleteMapping(value = "/{dealId}/options/{optionId}")
    public ApiResponse deleteOption(@PathVariable Long dealId, @PathVariable Long optionId) {
        optionService.delete(dealId, optionId);
        return ApiResponse.ok();
    }
}
