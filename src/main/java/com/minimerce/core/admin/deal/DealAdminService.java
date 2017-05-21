package com.minimerce.core.admin.deal;

import com.minimerce.core.api.domain.deal.Deal;
import com.minimerce.core.api.domain.deal.DealRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

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
    public Deal find(long dealId) {
        return dealRepository.findOne(dealId);
    }

    @Transactional
    public Page<Deal> findAll(Pageable pageable) {
        return dealRepository.findAll(pageable);
    }

    @Transactional
    public void save(Deal deal) {
        dealRepository.save(deal);
    }

    @Transactional
    public void save(List<Deal> deals) {
        dealRepository.save(deals);
    }

    @Transactional
    public void delete(long dealId) {
        Deal deal = dealRepository.findOne(dealId);
        deal.delete();
    }
}
