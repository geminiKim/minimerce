package com.minimerce.core.component.item;

import com.minimerce.core.domain.item.usable.UsableItemDslRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by gemini on 05/06/2017.
 */
@Component
public class UsableStockReducer {
    private final UsableItemDslRepository usableItemDslRepository;

    @Inject
    public UsableStockReducer(UsableItemDslRepository usableItemDslRepository) {
        this.usableItemDslRepository = usableItemDslRepository;
    }

    public void reduce(Stock stock) {
        usableItemDslRepository.decreaseStock(stock);
    }
}
