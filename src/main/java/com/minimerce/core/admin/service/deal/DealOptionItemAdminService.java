package com.minimerce.core.admin.service.deal;

import com.minimerce.core.api.domain.deal.option.DealOption;
import com.minimerce.core.api.domain.deal.option.DealOptionRepository;
import com.minimerce.core.api.domain.deal.option.item.DealOptionItem;
import com.minimerce.core.api.domain.deal.option.item.DealOptionItemRepository;
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
    public void save(long optionId, DealOptionItem optionItem) {
        if(optionItem.getId() != null) return;
        DealOption option = optionRepository.findOne(optionId);
        option.addItem(optionItem);
    }

    @Transactional
    public void update(DealOptionItem optionItem) {
        if(optionItem.getId() == null) return;
        optionItemRepository.save(optionItem);
    }

    @Transactional
    public void delete(long id) {
        DealOptionItem optionItem = optionItemRepository.findOne(id);
        optionItem.delete();
    }
}
