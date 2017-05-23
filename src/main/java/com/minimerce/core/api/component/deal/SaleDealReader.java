package com.minimerce.core.api.component.deal;

import com.minimerce.core.api.domain.deal.Deal;
import com.minimerce.core.api.domain.deal.DealRepository;
import com.minimerce.core.api.domain.deal.DealStatus;
import com.minimerce.core.api.domain.deal.option.DealOption;
import com.minimerce.core.api.domain.deal.option.DealOptionRepository;
import com.minimerce.core.api.support.exception.MinimerceException;
import com.minimerce.core.api.support.object.response.ErrorCode;
import com.minimerce.core.api.support.util.Yn;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by gemini on 11/04/2017.
 */
@Component
public class SaleDealReader {
    private final DealRepository dealRepository;
    private final DealOptionRepository dealOptionRepository;

    @Inject
    public SaleDealReader(DealRepository dealRepository, DealOptionRepository dealOptionRepository) {
        this.dealRepository = dealRepository;
        this.dealOptionRepository = dealOptionRepository;
    }

    public Deal findBySaleDeal(Long dealId) {
        Deal deal = dealRepository.findOne(dealId);
        if(null == deal) throw new MinimerceException(ErrorCode.NOT_FOUND_DEAL);
        if(DealStatus.SALE != deal.getStatus()) throw new MinimerceException(ErrorCode.NOT_SALE_DEAL);
        if(Yn.N == deal.getDisplay()) throw new MinimerceException(ErrorCode.NOT_DISPLAYED_DEAL);
        return deal;
    }

    public DealOption findBySaleDealOption(Long optionId) {
        DealOption option = dealOptionRepository.findOne(optionId);
        if(null == option) throw new MinimerceException(ErrorCode.NOT_FOUND_DEAL);
        if(DealStatus.SALE != option.getStatus()) throw new MinimerceException(ErrorCode.NOT_SALE_DEAL);
        if(Yn.N == option.getDisplay()) throw new MinimerceException(ErrorCode.NOT_DISPLAYED_DEAL);
        return option;
    }
}
