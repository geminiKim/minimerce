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
public class UsableStockCounterTest {
    private UsableStockCounter reducer;
    private final UsableOptionDslRepository mockUsableOptionDslRepository = mock(UsableOptionDslRepository.class);

    @Before
    public void setup() {
        reducer = new UsableStockCounter(mockUsableOptionDslRepository);
    }

    @Test
    public void testShouldBeDecrease() {
        Stock stock = StockBuilder.aStock().build();
        reducer.decrease(stock);
        verify(mockUsableOptionDslRepository).decrease(stock);
    }

    @Test
    public void testShouldBeIncrease() {
        Stock stock = StockBuilder.aStock().build();
        reducer.increase(stock);
        verify(mockUsableOptionDslRepository).increase(stock);
    }
}