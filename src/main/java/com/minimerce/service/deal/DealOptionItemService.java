package com.minimerce.service.deal;

import com.minimerce.domain.deal.option.item.DealOptionItem;
import com.minimerce.domain.deal.option.item.DealOptionItemRepository;
import org.springframework.stereotype.Service;

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

    public void newDeal(Long clientId, DealOptionItem optionItem) {
        if(optionItem.getId() != null) return;
        optionItem.setClientId(clientId);
        optionItemRepository.save(optionItem);
    }

    public void updateDeal(Long clientId, DealOptionItem optionItem) {
        if(optionItem.getId() == null) return;
        optionItem.setClientId(clientId);
        optionItemRepository.save(optionItem);
    }
}
