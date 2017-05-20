package com.minimerce.core.admin.service.deal;

import com.minimerce.core.api.domain.deal.Deal;
import com.minimerce.core.api.domain.deal.DealRepository;
import com.minimerce.core.api.domain.deal.option.DealOption;
import com.minimerce.core.api.domain.deal.option.DealOptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

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
    public void save(long dealId, DealOption option) {
        if(option.getId() != null) return;
        Deal deal = dealRepository.findOne(dealId);
        deal.addOption(option);
    }

    @Transactional
    public void update(DealOption option) {
        if(option.getId() == null) return;
        optionRepository.save(option);
    }

    @Transactional
    public void delete(long id) {
        DealOption option = optionRepository.findOne(id);
        option.delete();
    }
}
