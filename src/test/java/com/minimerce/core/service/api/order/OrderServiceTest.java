package com.minimerce.core.service.api.order;

import com.minimerce.builder.ClientBuilder;
import com.minimerce.builder.FindOrderRequestBuilder;
import com.minimerce.builder.OrderRequestBuilder;
import com.minimerce.builder.PageableBuilder;
import com.minimerce.core.component.order.OrderFinder;
import com.minimerce.core.component.order.OrderInserter;
import com.minimerce.core.component.order.OrderMaker;
import com.minimerce.core.component.stock.StockProcessor;
import com.minimerce.core.domain.client.Client;
import com.minimerce.core.support.object.order.FindOrderRequest;
import com.minimerce.core.support.object.order.OrderRequest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.*;

/**
 * Created by gemini on 20/04/2017.
 */
public class OrderServiceTest {
    private OrderService orderService;
    private final OrderMaker mockOrderMaker = mock(OrderMaker.class);
    private final OrderInserter mockOrderInserter = mock(OrderInserter.class);
    private final OrderFinder mockOrderFinder = mock(OrderFinder.class);
    private final StockProcessor mockstockProcessor = mock(StockProcessor.class);

    @Before
    public void setup() {
        orderService = new OrderService(mockOrderMaker, mockOrderInserter, mockOrderFinder, mockstockProcessor);
    }

    @Test
    public void testShouldBeCallOrder() {
        Client client = ClientBuilder.aClient().build();
        OrderRequest request = OrderRequestBuilder.anOrderRequest().build();
        orderService.order(client, request);
        verify(mockOrderMaker).make(client.getId(), request);
        verify(mockstockProcessor).reduce(any());
        verify(mockOrderInserter).insert(any());
    }

    @Test
    public void testShouldBeCallFindOrders() {
        Client client = ClientBuilder.aClient().build();
        FindOrderRequest request = FindOrderRequestBuilder.aFindOrderRequest().build();
        orderService.findOrder(client, request);
        verify(mockOrderFinder).findOrder(client.getId(), request);
    }

    @Test
    public void testShouldBeCallFindOrder() {
        Client client = ClientBuilder.aClient().build();
        Pageable page = PageableBuilder.aPageable().build();
        orderService.findCustomerOrders(client, 5L, page);
        verify(mockOrderFinder).findOrders(client.getId(), 5L, page);
    }
}