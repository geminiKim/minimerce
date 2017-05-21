package com.minimerce.core.admin.deal;

import com.minimerce.core.api.domain.deal.Deal;
import com.minimerce.core.api.domain.deal.DealRepository;
import com.minimerce.core.api.domain.deal.option.DealOption;
import com.minimerce.core.api.domain.deal.option.DealOptionRepository;
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
    public DealOption find(long optionId) {
        return optionRepository.findOne(optionId);
    }

    @Transactional
    public Page<DealOption> findAll(Pageable pageable) {
        return optionRepository.findAll(pageable);
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
    public void delete(long optionId) {
        DealOption option = optionRepository.findOne(optionId);
        option.delete();
    }
}
