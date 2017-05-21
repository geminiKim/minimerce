package com.minimerce.core.admin.deal;

import com.minimerce.core.api.domain.deal.Deal;
import com.minimerce.core.api.domain.deal.DealRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by gemini on 20/04/2017.
 */
@Service
public class DealAdminService {
    private final DealRepository repository;

    @Inject
    public DealAdminService(DealRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Deal find(long id) {
        return repository.findOne(id);
    }

    @Transactional
    public Page<Deal> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public void save(Deal deal) {
        repository.save(deal);
    }

    @Transactional
    public void delete(long id) {
        Deal deal = repository.findOne(id);
        deal.delete();
    }
}
