package com.minimerce.core.component.stock;

import com.minimerce.builder.StockBuilder;
import com.minimerce.core.object.deal.type.ProductType;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by gemini on 07/06/2017.
 */
public class StockCounterTest {
    private StockCounter counter;
    private UsableStockCounter mockUsableReducer = mock(UsableStockCounter.class);

    @Before
    public void setup() {
        counter = new StockCounter(mockUsableReducer);
    }
    @Test
    public void testShouldBeReduceUsableStock() {
        Stock usableStock = StockBuilder.aStock().withType(ProductType.USABLE).build();
        counter.reduce(Lists.newArrayList(usableStock));
        verify(mockUsableReducer).decrease(usableStock);
    }
    @Test
    public void testShouldBeRestoreUsableStock() {
        Stock usableStock = StockBuilder.aStock().withType(ProductType.USABLE).build();
        counter.restore(Lists.newArrayList(usableStock));
        verify(mockUsableReducer).increase(usableStock);
    }
}