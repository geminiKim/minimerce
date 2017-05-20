package com.minimerce.core.admin.item;

import com.minimerce.core.api.domain.item.UsableItem;
import com.minimerce.core.api.domain.item.UsableItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

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
    public void save(UsableItem item) {
        if(item.getId() != null) return;
        itemRepository.save(item);
    }

    @Transactional
    public void update(UsableItem item) {
        if(item.getId() == null) return;
        itemRepository.save(item);
    }

    @Transactional
    public void delete(long id) {
        UsableItem item = itemRepository.findOne(id);
        item.delete();
    }
}
