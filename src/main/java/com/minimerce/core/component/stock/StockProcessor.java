package com.minimerce.core.component.stock;

import com.minimerce.core.support.object.order.OrderRequest;
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

    public void reduce(OrderRequest request) {
        List<Stock> stocks = converter.convert(request.getDetails());
        reducer.reduce(stocks);
    }
}
