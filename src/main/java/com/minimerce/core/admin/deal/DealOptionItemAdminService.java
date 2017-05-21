package com.minimerce.core.admin.deal;

import com.minimerce.core.api.domain.deal.option.DealOption;
import com.minimerce.core.api.domain.deal.option.DealOptionRepository;
import com.minimerce.core.api.domain.deal.option.item.DealOptionItem;
import com.minimerce.core.api.domain.deal.option.item.DealOptionItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by gemini on 24/04/2017.
 */
@Service
public class DealOptionItemAdminService {
    private final DealOptionRepository optionRepository;
    private final DealOptionItemRepository optionItemRepository;

    @Inject
    public DealOptionItemAdminService(DealOptionRepository optionRepository, DealOptionItemRepository optionItemRepository) {
        this.optionRepository = optionRepository;
        this.optionItemRepository = optionItemRepository;
    }

    @Transactional
    public DealOptionItem find(long id) {
        return optionItemRepository.findOne(id);
    }

    @Transactional
    public Page<DealOptionItem> findAll(Pageable pageable) {
        return optionItemRepository.findAll(pageable);
    }

    @Transactional
    public void save(long optionId, DealOptionItem optionItem) {
        DealOption option = optionRepository.findOne(optionId);
        optionItem.setOption(option);
        optionItemRepository.save(optionItem);
    }

    @Transactional
    public void delete(long id) {
        DealOptionItem optionItem = optionItemRepository.findOne(id);
        optionItem.delete();
    }
}
