package com.minimerce.core.service.admin.deal;

import com.minimerce.core.domain.deal.option.DealOption;
import com.minimerce.core.domain.deal.option.DealOptionRepository;
import com.minimerce.core.domain.deal.option.item.DealOptionItem;
import com.minimerce.core.domain.deal.option.item.DealOptionItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

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
    public DealOptionItem find(Long optionId, Long itemId) {
        return optionItemRepository.findByOptionIdAndId(optionId, itemId);
    }

    @Transactional
    public Page<DealOptionItem> find(Long optionId, Pageable pageable) {
        return optionItemRepository.findByOptionId(pageable, optionId);
    }

    @Transactional
    public void save(Long optionId, DealOptionItem optionItem) {
        DealOption option = optionRepository.findOne(optionId);
        optionItem.setOption(option);
        optionItemRepository.save(optionItem);
    }

    @Transactional
    public void save(Long optionId, List<DealOptionItem> optionItems) {
        DealOption option = optionRepository.findOne(optionId);
        optionItems.forEach(e -> e.setOption(option));
        optionItemRepository.save(optionItems);
    }

    @Transactional
    public void delete(Long optionId, Long itemId) {
        DealOptionItem optionItem = optionItemRepository.findByOptionIdAndId(optionId, itemId);
        optionItem.delete();
    }
}
