package com.minimerce.core.component.stock;

import com.minimerce.core.domain.deal.option.usable.UsableOptionDslRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by gemini on 05/06/2017.
 */
@Component
public class UsableStockReducer {
    private final UsableOptionDslRepository usableOptionDslRepository;

    @Inject
    public UsableStockReducer(UsableOptionDslRepository usableOptionDslRepository) {
        this.usableOptionDslRepository = usableOptionDslRepository;
    }

    public void reduce(Stock stock) {
        usableOptionDslRepository.decrease(stock);
    }
}
