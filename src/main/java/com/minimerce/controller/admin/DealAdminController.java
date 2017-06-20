package com.minimerce.controller.admin;

import com.minimerce.controller.BaseController;
import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.option.Option;
import com.minimerce.core.service.admin.deal.DealAdminService;
import com.minimerce.core.service.admin.deal.OptionAdminService;
import com.minimerce.core.support.object.response.MinimerceApiResponse;
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
    public MinimerceApiResponse findDeals(Pageable pageable) {
        return MinimerceApiResponse.ok(dealService.find(pageable));
    }
    @GetMapping(value = "deals/{dealId}")
    public MinimerceApiResponse findDeal(@PathVariable Long dealId) {
        return MinimerceApiResponse.ok(dealService.find(dealId));
    }
    @PostMapping(value = "/deals") @PutMapping(value = "/deals")
    public MinimerceApiResponse saveDeals(@RequestBody List<Deal> deals) {
        dealService.save(deals);
        return MinimerceApiResponse.ok();
    }
    @PostMapping(value = "/deals/{dealId}") @PutMapping(value = "/deals/{dealId}")
    public MinimerceApiResponse saveDeal(@RequestBody Deal deal) {
        dealService.save(deal);
        return MinimerceApiResponse.ok();
    }
    @DeleteMapping(value = "/deals/{dealId}")
    public MinimerceApiResponse deleteDeal(@PathVariable Long dealId) {
        dealService.delete(dealId);
        return MinimerceApiResponse.ok();
    }


    @GetMapping(value = "/{dealId}/options")
    public MinimerceApiResponse findOptions(@PathVariable Long dealId, Pageable pageable) {
        return MinimerceApiResponse.ok(optionService.find(dealId, pageable));
    }
    @GetMapping(value = "/{dealId}/options/{optionId}")
    public MinimerceApiResponse findOption(@PathVariable Long dealId, @PathVariable Long optionId) {
        return MinimerceApiResponse.ok(optionService.find(dealId, optionId));
    }
    @PostMapping(value = "/{dealId}/options") @PutMapping(value = "/{dealId}/options")
    public MinimerceApiResponse saveOptions(@PathVariable Long dealId, @RequestBody List<Option> options) {
        optionService.save(dealId, options);
        return MinimerceApiResponse.ok();
    }
    @PostMapping(value = "/{dealId}/options/{optionId}") @PutMapping(value = "/{dealId}/options/{optionId}")
    public MinimerceApiResponse saveOption(@PathVariable Long dealId, @RequestBody Option option) {
        optionService.save(dealId, option);
        return MinimerceApiResponse.ok();
    }
    @DeleteMapping(value = "/{dealId}/options/{optionId}")
    public MinimerceApiResponse deleteOption(@PathVariable Long dealId, @PathVariable Long optionId) {
        optionService.delete(dealId, optionId);
        return MinimerceApiResponse.ok();
    }
}
