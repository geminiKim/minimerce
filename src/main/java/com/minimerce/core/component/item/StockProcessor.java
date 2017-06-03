package com.minimerce.core.component.item;

import com.minimerce.core.domain.order.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by gemini on 01/06/2017.
 */
@Component
public class StockProcessor {
    private final StockConverter converter;
    private final StockReducer reducer;

    public StockProcessor(StockConverter converter, StockReducer reducer) {
        this.converter = converter;
        this.reducer = reducer;
    }

    public void reduce(Order order) {
        List<Stock> stocks = converter.convert(order);
        reducer.reduce(stocks);
    }
}
