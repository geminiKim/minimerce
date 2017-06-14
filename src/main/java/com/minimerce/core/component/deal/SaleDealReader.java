package com.minimerce.core.component.deal;

import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.DealRepository;
import com.minimerce.core.domain.deal.DealStatus;
import com.minimerce.core.domain.deal.option.Option;
import com.minimerce.core.domain.deal.option.OptionRepository;
import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.object.response.ErrorCode;
import com.minimerce.core.support.util.Yn;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by gemini on 11/04/2017.
 */
@Component
public class SaleDealReader {
    private final DealRepository dealRepository;
    private final OptionRepository optionRepository;

    @Inject
    public SaleDealReader(DealRepository dealRepository, OptionRepository optionRepository) {
        this.dealRepository = dealRepository;
        this.optionRepository = optionRepository;
    }

    public Deal findBySaleDeal(Long dealId) {
        Deal deal = dealRepository.findOne(dealId);
        if(null == deal) throw new MinimerceException(ErrorCode.NOT_FOUND_DEAL);
        if(DealStatus.SALE != deal.getStatus()) throw new MinimerceException(ErrorCode.NOT_SALE_DEAL);
        if(Yn.N == deal.getDisplay()) throw new MinimerceException(ErrorCode.NOT_DISPLAYED_DEAL);
        return deal;
    }

    public Option findBySaleOption(Long optionId) {
        Option option = optionRepository.findOne(optionId);
        if(null == option) throw new MinimerceException(ErrorCode.NOT_FOUND_DEAL);
        if(null == option.getDeal()) throw new MinimerceException(ErrorCode.NOT_FOUND_DEAL);
        if(DealStatus.SALE != option.getDeal().getStatus()) throw new MinimerceException(ErrorCode.NOT_SALE_DEAL);
        if(DealStatus.SALE != option.getStatus()) throw new MinimerceException(ErrorCode.NOT_SALE_DEAL);
        if(Yn.N == option.getDeal().getDisplay()) throw new MinimerceException(ErrorCode.NOT_DISPLAYED_DEAL);
        if(Yn.N == option.getDisplay()) throw new MinimerceException(ErrorCode.NOT_DISPLAYED_DEAL);
        return option;
    }
}
