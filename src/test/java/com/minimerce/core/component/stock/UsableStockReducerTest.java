package com.minimerce.core.component.stock;

import com.minimerce.builder.StockBuilder;
import com.minimerce.core.domain.deal.option.usable.UsableOptionDslRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by gemini on 14/06/2017.
 */
public class UsableStockReducerTest {
    private UsableOptionDslRepository mockUsableOptionDslRepository;
    private UsableStockReducer reducer;

    @Before
    public void setup() {
        mockUsableOptionDslRepository = mock(UsableOptionDslRepository.class);
        reducer = new UsableStockReducer(mockUsableOptionDslRepository);
    }

    @Test
    public void testShouldBeReduce() {
        Stock stock = StockBuilder.aStock().build();
        reducer.reduce(stock);
        verify(mockUsableOptionDslRepository).decreaseStock(stock);
    }
}