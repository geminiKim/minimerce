package com.minimerce.controller.admin;

import com.minimerce.controller.BaseController;
import com.minimerce.core.admin.deal.DealAdminService;
import com.minimerce.core.admin.deal.DealOptionAdminService;
import com.minimerce.core.admin.deal.DealOptionItemAdminService;
import com.minimerce.core.api.domain.deal.Deal;
import com.minimerce.core.api.domain.deal.option.DealOption;
import com.minimerce.core.api.domain.deal.option.item.DealOptionItem;
import com.minimerce.core.api.support.object.response.ApiResponse;
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
    private final DealOptionAdminService optionService;
    private final DealOptionItemAdminService optionItemService;

    @Inject
    public DealAdminController(DealAdminService dealService, DealOptionAdminService optionService, DealOptionItemAdminService optionItemService) {
        this.dealService = dealService;
        this.optionService = optionService;
        this.optionItemService = optionItemService;
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
    public ApiResponse saveOptions(@PathVariable Long dealId, @RequestBody List<DealOption> options) {
        optionService.save(dealId, options);
        return ApiResponse.ok();
    }
    @PostMapping(value = "/{dealId}/options/{optionId}") @PutMapping(value = "/{dealId}/options/{optionId}")
    public ApiResponse saveOption(@PathVariable Long dealId, @RequestBody DealOption option) {
        optionService.save(dealId, option);
        return ApiResponse.ok();
    }
    @DeleteMapping(value = "/{dealId}/options/{optionId}")
    public ApiResponse deleteOption(@PathVariable Long dealId, @PathVariable Long optionId) {
        optionService.delete(dealId, optionId);
        return ApiResponse.ok();
    }


    @GetMapping(value = "/options/{optionId}/items")
    public ApiResponse findOptionItems(@PathVariable Long optionId, Pageable pageable) {
        return ApiResponse.ok(optionItemService.find(optionId, pageable));
    }
    @GetMapping(value = "/options/{optionId}/items/{itemId}")
    public ApiResponse findOptionItem(@PathVariable Long optionId, @PathVariable Long itemId) {
        return ApiResponse.ok(optionItemService.find(optionId, itemId));
    }
    @PostMapping(value = "/options/{optionId}/items") @PutMapping(value = "/options/{optionId}/items")
    public ApiResponse saveOptionItems(@PathVariable Long optionId, @RequestBody List<DealOptionItem> optionItems) {
        optionItemService.save(optionId, optionItems);
        return ApiResponse.ok();
    }
    @PostMapping(value = "/options/{optionId}/items/{itemId}") @PutMapping(value = "/options/{optionId}/items/{itemId}")
    public ApiResponse saveOptionItem(@PathVariable Long optionId, @RequestBody DealOptionItem optionItem) {
        optionItemService.save(optionId, optionItem);
        return ApiResponse.ok();
    }
    @DeleteMapping(value = "/options/{optionId}/items/{itemId}")
    public ApiResponse deleteOptionItem(@PathVariable Long optionId, @PathVariable Long itemId) {
        optionItemService.delete(optionId, itemId);
        return ApiResponse.ok();
    }
}
