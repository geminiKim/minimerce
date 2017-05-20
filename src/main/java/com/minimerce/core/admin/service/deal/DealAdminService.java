package com.minimerce.core.admin.service.deal;

import com.minimerce.core.api.domain.deal.Deal;
import com.minimerce.core.api.domain.deal.DealRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by gemini on 20/04/2017.
 */
@Service
public class DealAdminService {
    private final DealRepository dealRepository;

    @Inject
    public DealAdminService(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    @Transactional
    public Deal findById(long dealId) {
        return dealRepository.findOne(dealId);
    }

    @Transactional
    public void save(Deal deal) {
        if(deal.getId() != null) return;
        dealRepository.save(deal);
    }

    @Transactional
    public void update(Deal deal) {
        if(deal.getId() == null) return;
        dealRepository.save(deal);
    }

    @Transactional
    public void delete(long id) {
        Deal deal = dealRepository.findOne(id);
        deal.delete();
    }
}
