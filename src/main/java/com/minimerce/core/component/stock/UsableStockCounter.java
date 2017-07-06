package com.minimerce.core.component.stock;

import com.minimerce.core.domain.deal.option.usable.UsableOptionDslRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by gemini on 05/06/2017.
 */
@Component
public class UsableStockCounter {
    private final UsableOptionDslRepository usableOptionDslRepository;

    @Inject
    public UsableStockCounter(UsableOptionDslRepository usableOptionDslRepository) {
        this.usableOptionDslRepository = usableOptionDslRepository;
    }

    public void decrease(Stock stock) {
        usableOptionDslRepository.decrease(stock);
    }

    public void increase(Stock stock) {
        usableOptionDslRepository.decrease(stock);
    }
}
