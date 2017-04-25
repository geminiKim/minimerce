package com.minimerce.service.deal;

import com.minimerce.domain.deal.option.item.DealOptionItem;
import com.minimerce.domain.deal.option.item.DealOptionItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by gemini on 24/04/2017.
 */
@Service
public class DealOptionItemService {
    private final DealOptionItemRepository optionItemRepository;

    @Inject
    public DealOptionItemService(DealOptionItemRepository optionItemRepository) {
        this.optionItemRepository = optionItemRepository;
    }

    @Transactional
    public void save(DealOptionItem optionItem) {
        if(optionItem.getId() != null) return;
        optionItemRepository.save(optionItem);
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
