package com.minimerce.core.component.item;

import com.minimerce.builder.OrderRequestBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by gemini on 03/06/2017.
 */
public class StockProcessorTest {
    private StockProcessor stockProcessor;
    private StockConverter mockConverter;
    private StockReducer mockReducer;

    @Before
    public void setup() {
        mockConverter = mock(StockConverter.class);
        mockReducer = mock(StockReducer.class);

        stockProcessor = new StockProcessor(mockConverter, mockReducer);
    }

    @Test
    public void testShouldBeCallReduce() {
        stockProcessor.reduce(OrderRequestBuilder.anOrderRequest().build());

        verify(mockConverter).convert(any());
        verify(mockReducer).reduce(any());
    }
}