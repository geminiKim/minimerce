package com.minimerce.core.service.api.order;

import com.minimerce.builder.ClientBuilder;
import com.minimerce.builder.OrderBuilder;
import com.minimerce.builder.OrderCancelRequestBuilder;
import com.minimerce.builder.OrderOptionBuilder;
import com.minimerce.core.component.order.OrderCanceler;
import com.minimerce.core.component.order.OrderFinder;
import com.minimerce.core.component.order.OrderStatusValidator;
import com.minimerce.core.domain.client.Client;
import com.minimerce.core.domain.order.Order;
import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.object.order.FindOrderRequest;
import com.minimerce.core.object.order.cancel.OrderCancelRequest;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * Created by gemini on 20/06/2017.
 */
public class OrderCancelServiceTest {
    private OrderCancelService service;
    private final OrderFinder mockOrderFinder = mock(OrderFinder.class);
    private final OrderStatusValidator mockOrderStatusValidator = mock(OrderStatusValidator.class);
    private final OrderCanceler mockOrderCanceler = mock(OrderCanceler.class);

    private Order testOrder;

    @Before
    public void setup() {
        testOrder = buildOrder();
        when(mockOrderFinder.findOrder(any(), any())).thenReturn(testOrder);

        service = new OrderCancelService(mockOrderFinder, mockOrderStatusValidator, mockOrderCanceler);
    }

    @Test
    public void testShouldBeFullCancel() {
        Client client = ClientBuilder.aClient().build();
        OrderCancelRequest request = OrderCancelRequestBuilder.anOrderCancelRequest().build();
        service.cancel(client, request);

        verify(mockOrderFinder).findOrder(eq(client.getId()), any(FindOrderRequest.class));
        verify(mockOrderStatusValidator).validate(testOrder.getOptions());
        verify(mockOrderCanceler).cancel(testOrder.getOptions());
    }

    private Order buildOrder() {
        OrderOption option = OrderOptionBuilder.anOrderOption().build();
        return OrderBuilder.anOrder().withOptions(Lists.newArrayList(option)).build();
    }
}