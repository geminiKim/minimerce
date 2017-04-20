package com.minimerce.service.deal;

import com.minimerce.domain.deal.Deal;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by gemini on 20/04/2017.
 */
@Service
public class DealService {
    private DealInserter inserter;

    @Inject
    public DealService(DealInserter inserter) {
        this.inserter = inserter;
    }

    public void newDeal(Long clientId, Deal deal) {
        deal.setClientId(clientId);
        inserter.insert(deal);
    }
}
