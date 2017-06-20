package com.minimerce.core.service.api.order;

import com.minimerce.builder.FindOrderRequestBuilder;
import com.minimerce.builder.OrderRequestBuilder;
import com.minimerce.builder.PageableBuilder;
import com.minimerce.core.component.order.OrderFinder;
import com.minimerce.core.component.order.OrderInserter;
import com.minimerce.core.component.order.OrderMaker;
import com.minimerce.core.component.stock.StockProcessor;
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
        OrderRequest request = OrderRequestBuilder.anOrderRequest().build();
        orderService.order(1L, request);
        verify(mockOrderMaker).make(1L, request);
        verify(mockstockProcessor).reduce(any());
        verify(mockOrderInserter).insert(any());
    }

    @Test
    public void testShouldBeCallFindOrders() {
        FindOrderRequest request = FindOrderRequestBuilder.aFindOrderRequest().build();
        orderService.findOrder(1L, request);
        verify(mockOrderFinder).findOrder(1L, request);
    }

    @Test
    public void testShouldBeCallFindOrder() {
        Pageable page = PageableBuilder.aPageable().build();
        orderService.findCustomerOrders(1L, 5L, page);
        verify(mockOrderFinder).findOrders(1L, 5L, page);
    }
}