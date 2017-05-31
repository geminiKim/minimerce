package com.minimerce.core.service.admin.item;

import com.minimerce.core.domain.item.usable.UsableItem;
import com.minimerce.core.domain.item.usable.UsableItemRepository;
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
public class UsableItemAdminService {
    private final UsableItemRepository itemRepository;

    @Inject
    public UsableItemAdminService(UsableItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public UsableItem find(long itemId) {
        return itemRepository.findOne(itemId);
    }

    @Transactional
    public Page<UsableItem> findAll(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }

    @Transactional
    public void save(UsableItem item) {
        itemRepository.save(item);
    }
    @Transactional
    public void save(List<UsableItem> item) {
        itemRepository.save(item);
    }

    @Transactional
    public void delete(long id) {
        UsableItem item = itemRepository.findOne(id);
        item.delete();
    }
}
