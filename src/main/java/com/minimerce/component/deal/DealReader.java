package com.minimerce.component.deal;

import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.DealRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by gemini on 10/04/2017.
 */
@Component
public class DealReader extends EntityReader {
    private final DealRepository repository;

    @Inject
    public DealReader(DealRepository repository) {
        this.repository = repository;
    }

    public Deal findByClientDeal(Long clientId, Long dealId) {
        Deal one = repository.findByClientIdAndId(clientId, dealId);
        validate(one);
        return one;
    }
}
