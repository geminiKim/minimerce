package com.minimerce.component.deal;

import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.DealRepository;
import com.minimerce.domain.deal.DealStatus;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.deal.option.DealOptionRepository;
import com.minimerce.support.exception.UnsaleableProductException;
import com.minimerce.support.util.Yn;
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

    public Deal findBySaleDeal(Long clientId, Long dealId) throws UnsaleableProductException {
        Deal deal = dealRepository.findByClientIdAndId(clientId, dealId);
        if(null == deal) throw new UnsaleableProductException("상품이 없어요.");
        if(DealStatus.SALE != deal.getStatus()) throw new UnsaleableProductException("판매 금지 상품입니다.");
        if(Yn.N == deal.getDisplay()) throw new UnsaleableProductException("노출 안함 상품입니다.");
        return deal;
    }

    public DealOption findBySaleDealOption(Long clientId, Long optionId) throws UnsaleableProductException {
        DealOption option = dealOptionRepository.findByClientIdAndId(clientId, optionId);
        if(null == option) throw new UnsaleableProductException("상품이 없어요.");
        if(DealStatus.SALE != option.getStatus()) throw new UnsaleableProductException("판매 금지 상품입니다.");
        if(Yn.N == option.getDisplay()) throw new UnsaleableProductException("노출 안함 상품입니다.");
        return option;
    }
}
