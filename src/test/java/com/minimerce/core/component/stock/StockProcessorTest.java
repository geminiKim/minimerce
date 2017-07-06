package com.minimerce.core.component.stock;

import com.minimerce.builder.OrderOptionBuilder;
import com.minimerce.core.domain.order.option.OrderOption;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by gemini on 03/06/2017.
 */
public class StockProcessorTest {
    private StockProcessor stockProcessor;
    private StockConverter mockConverter = mock(StockConverter.class);
    private StockCounter mockCounter = mock(StockCounter.class);

    private final OrderOptionBuilder orderOptionBuilder = OrderOptionBuilder.anOrderOption();

    @Before
    public void setup() {
        stockProcessor = new StockProcessor(mockConverter, mockCounter);
    }

    @Test
    public void testShouldBeCallReduce() {
        List<OrderOption> options = Lists.newArrayList(orderOptionBuilder.build());
        stockProcessor.reduce(options);

        verify(mockConverter).convert(options);
        verify(mockCounter).reduce(any());
    }

    @Test
    public void testShouldBeCallRestore() {
        List<OrderOption> options = Lists.newArrayList(orderOptionBuilder.build());
        stockProcessor.restore(options);

        verify(mockConverter).convert(options);
        verify(mockCounter).restore(any());
    }
}