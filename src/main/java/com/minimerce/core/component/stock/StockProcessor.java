package com.minimerce.core.component.stock;

import com.minimerce.core.domain.order.option.OrderOption;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by gemini on 01/06/2017.
 */
@Component
public class StockProcessor {
    private final StockConverter converter;
    private final StockCounter counter;

    public StockProcessor(StockConverter converter, StockCounter counter) {
        this.converter = converter;
        this.counter = counter;
    }

    public void reduce(List<OrderOption> options) {
        List<Stock> stocks = converter.convert(options);
        counter.reduce(stocks);
    }

    public void restore(List<OrderOption> options) {
        List<Stock> stocks = converter.convert(options);
        counter.restore(stocks);
    }
}
