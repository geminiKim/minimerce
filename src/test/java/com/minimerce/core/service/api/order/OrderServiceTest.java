package com.minimerce.core.service.api.order;

import com.minimerce.builder.FindOrderRequestBuilder;
import com.minimerce.builder.OrderRequestBuilder;
import com.minimerce.core.component.item.StockReducer;
import com.minimerce.core.component.order.OrderFinder;
import com.minimerce.core.component.order.OrderInserter;
import com.minimerce.core.component.order.OrderMaker;
import com.minimerce.core.support.object.order.FindOrderRequest;
import com.minimerce.core.support.object.order.OrderRequest;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by gemini on 20/04/2017.
 */
public class OrderServiceTest {
    private OrderService orderService;
    private OrderMaker mockOrderMaker;
    private OrderInserter mockOrderInserter;
    private OrderFinder mockOrderFinder;
    private StockReducer mockStockReducer;

    @Before
    public void setup() {
        mockOrderMaker = mock(OrderMaker.class);
        mockOrderInserter = mock(OrderInserter.class);
        mockOrderFinder = mock(OrderFinder.class);
        mockStockReducer = mock(StockReducer.class);
        orderService = new OrderService(mockOrderMaker, mockOrderInserter, mockOrderFinder, mockStockReducer);
    }

    @Test
    public void testShouldBeCallOrder() {
        OrderRequest request = OrderRequestBuilder.anOrderRequest().build();
        orderService.order(1L, request);
        verify(mockOrderMaker, times(1)).make(1L, request);
        verify(mockOrderInserter, times(1)).insert(any());
    }

    @Test
    public void testShouldBeCallFindOrders() {
        FindOrderRequest request = FindOrderRequestBuilder.aFindOrderRequest().build();
        orderService.findOrder(1L, request);
        verify(mockOrderFinder, times(1)).findOrder(1L, request);
    }

    @Test
    public void testShouldBeCallFindOrder() {
        orderService.findCustomerOrders(1L, 5L);
        verify(mockOrderFinder, times(1)).findOrders(1L, 5L);
    }
}