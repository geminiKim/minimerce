package com.minimerce.core.component.stock;

import com.minimerce.builder.StockBuilder;
import com.minimerce.core.object.type.ProductType;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by gemini on 07/06/2017.
 */
public class StockReducerTest {
    private StockReducer reducer;
    private UsableStockReducer mockUsableReducer = mock(UsableStockReducer.class);

    @Before
    public void setup() {
        reducer = new StockReducer(mockUsableReducer);
    }
    @Test
    public void testShouldBeReduceUsableStock() {
        Stock usableStock = StockBuilder.aStock().withType(ProductType.USABLE).build();
        reducer.reduce(Lists.newArrayList(usableStock));
        verify(mockUsableReducer).reduce(usableStock);
    }
}