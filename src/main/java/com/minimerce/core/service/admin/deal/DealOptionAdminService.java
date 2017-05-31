package com.minimerce.core.service.admin.deal;

import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.DealRepository;
import com.minimerce.core.domain.deal.option.DealOption;
import com.minimerce.core.domain.deal.option.DealOptionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 23/04/2017.
 */
@Service
public class DealOptionAdminService {
    private final DealRepository dealRepository;
    private final DealOptionRepository optionRepository;

    @Inject
    public DealOptionAdminService(DealRepository dealRepository, DealOptionRepository optionRepository) {
        this.dealRepository = dealRepository;
        this.optionRepository = optionRepository;
    }

    @Transactional
    public DealOption find(Long dealId, Long optionId) {
        return optionRepository.findByDealIdAndId(dealId, optionId);
    }

    @Transactional
    public Page<DealOption> find(Long dealId, Pageable pageable) {
        return optionRepository.findByDealId(pageable, dealId);
    }

    @Transactional
    public void save(long dealId, DealOption option) {
        Deal deal = dealRepository.findOne(dealId);
        option.setDeal(deal);
        optionRepository.save(option);
    }

    @Transactional
    public void save(long dealId, List<DealOption> options) {
        Deal deal = dealRepository.findOne(dealId);
        options.forEach(e -> e.setDeal(deal));
        optionRepository.save(options);
    }

    @Transactional
    public void delete(Long dealId, long optionId) {
        DealOption option = optionRepository.findByDealIdAndId(dealId, optionId);
        option.delete();
    }
}
