package com.minimerce.service.deal;

import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.DealRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by gemini on 20/04/2017.
 */
@Service
public class DealService {
    private final DealRepository dealRepository;

    @Inject
    public DealService(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    public void newDeal(Long clientId, Deal deal) {
        if(deal.getId() != null) return;
        deal.setClientId(clientId);
        dealRepository.save(deal);
    }

    public void updateDeal(Long clientId, Deal deal) {
        if(deal.getId() == null) return;
        deal.setClientId(clientId);
        dealRepository.save(deal);
    }
}
