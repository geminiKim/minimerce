package com.minimerce.core.service.api.order;

import com.minimerce.builder.ClientBuilder;
import com.minimerce.builder.OrderCancelRequestBuilder;
import com.minimerce.builder.OrderOptionBuilder;
import com.minimerce.core.component.order.OrderCanceler;
import com.minimerce.core.component.order.OrderFinder;
import com.minimerce.core.component.order.option.validator.OrderStatusValidator;
import com.minimerce.core.component.stock.StockProcessor;
import com.minimerce.core.domain.client.Client;
import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.object.order.cancel.OrderCancelRequest;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by gemini on 20/06/2017.
 */
public class OrderCancelServiceTest {
    private OrderCancelService service;
    private final OrderFinder mockOrderFinder = mock(OrderFinder.class);
    private final OrderStatusValidator mockOrderStatusValidator = mock(OrderStatusValidator.class);
    private final StockProcessor mockStockProcessor = mock(StockProcessor.class);
    private final OrderCanceler mockOrderCanceler = mock(OrderCanceler.class);

    List<OrderOption> testOptions = Lists.newArrayList(OrderOptionBuilder.anOrderOption().build());

    @Before
    public void setup() {
        when(mockOrderFinder.findCancelOptions(any(), any())).thenReturn(testOptions);

        service = new OrderCancelService(mockOrderFinder, mockOrderStatusValidator, mockStockProcessor, mockOrderCanceler);
    }

    @Test
    public void testShouldBeCancel() {
        Client client = ClientBuilder.aClient().build();
        OrderCancelRequest request = OrderCancelRequestBuilder.anOrderCancelRequest().build();
        service.cancel(client, request);

        verify(mockOrderFinder).findCancelOptions(client.getId(), request);
        verify(mockOrderStatusValidator).validate(testOptions);
        verify(mockStockProcessor).restore(testOptions);
        verify(mockOrderCanceler).cancel(testOptions);
    }
}