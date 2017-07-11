package com.minimerce.core.service.api.deal;

import com.minimerce.core.component.deal.DealFinder;
import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.object.deal.FindDealRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by gemini on 12/07/2017.
 */
@Service
public class DealService {
    private final DealFinder reader;

    @Inject
    public DealService(DealFinder reader) {
        this.reader = reader;
    }

    public Page<Deal> findDeals(FindDealRequest request, Pageable page) {
        return reader.findDeals(request, page);
    }

    public Deal findDeal(long dealId) {
        return reader.findBySaleDeal(dealId);
    }
}
