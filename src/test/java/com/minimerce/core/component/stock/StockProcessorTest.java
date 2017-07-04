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
    private StockReducer mockReducer = mock(StockReducer.class);

    private final OrderOptionBuilder orderOptionBuilder = OrderOptionBuilder.anOrderOption();

    @Before
    public void setup() {
        stockProcessor = new StockProcessor(mockConverter, mockReducer);
    }

    @Test
    public void testShouldBeCallReduce() {
        List<OrderOption> options = Lists.newArrayList(orderOptionBuilder.build());
        stockProcessor.reduce(options);

        verify(mockConverter).convert(options);
        verify(mockReducer).reduce(any());
    }
}