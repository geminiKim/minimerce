package com.minimerce.service.deal;

import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.DealRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by gemini on 20/04/2017.
 */
@Component
public class DealInserter {
    private DealRepository dealRepository;

    @Inject
    public DealInserter(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    public void insert(Deal deal) {
        dealRepository.save(deal);
    }
}
