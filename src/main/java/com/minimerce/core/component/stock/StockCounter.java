package com.minimerce.core.component.stock;

import com.minimerce.core.object.deal.type.ProductType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 03/06/2017.
 */
@Component
public class StockCounter {
    private final UsableStockCounter usableStockCounter;

    @Inject
    public StockCounter(UsableStockCounter usableStockCounter) {
        this.usableStockCounter = usableStockCounter;
    }

    @Transactional
    public void reduce(List<Stock> stocks) {
        for (Stock stock : stocks) {
            if(ProductType.USABLE == stock.getType()) usableStockCounter.decrease(stock);
        }
    }

    @Transactional
    public void restore(List<Stock> stocks) {
        for (Stock stock : stocks) {
            if(ProductType.USABLE == stock.getType()) usableStockCounter.increase(stock);
        }
    }
}
