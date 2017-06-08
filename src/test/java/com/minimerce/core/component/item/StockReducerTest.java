package com.minimerce.core.component.item;

import com.minimerce.core.support.object.type.ProductType;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by gemini on 07/06/2017.
 */
public class StockReducerTest {
    private UsableStockReducer mockUsableReducer;
    private StockReducer reducer;

    @Before
    public void setup() {
        mockUsableReducer = mock(UsableStockReducer.class);
        reducer = new StockReducer(mockUsableReducer);
    }
    @Test
    public void testShouldBeCallUsableItemStockReduce() {
        List<Stock> stocks = Lists.newArrayList(StockBuilder.aStock().withType(ProductType.USABLE).build());
        reducer.reduce(stocks);
        verify(mockUsableReducer).reduce(stocks.get(0));
    }
}