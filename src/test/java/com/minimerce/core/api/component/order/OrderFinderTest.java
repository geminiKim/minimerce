package com.minimerce.core.api.component.order;

import com.minimerce.builder.FindOrderRequestBuilder;
import com.minimerce.core.api.domain.order.OrderRepository;
import com.minimerce.core.api.support.exception.MinimerceException;
import com.minimerce.core.api.support.object.order.FindOrderRequest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

/**
 * Created by gemini on 20/04/2017.
 */
public class OrderFinderTest {
    private OrderFinder finder;
    private OrderRepository mockOrderRepository;

    @Before
    public void setup() {
        mockOrderRepository = mock(OrderRepository.class);
        finder = new OrderFinder(mockOrderRepository);

    }

    @Test
    public void testShouldBeThrowsNotExistOrderExceptionByNotSupportRequest() {
        FindOrderRequest request = FindOrderRequestBuilder.aFindOrderRequest().withOrderId(500L).withClientOrderId(400L).build();
        try {
            finder.findOrder(1L, request);
            fail();
        } catch (MinimerceException e) {
        }
    }

    @Test
    public void testShouldBeFindByOrderId() {
        FindOrderRequest request = FindOrderRequestBuilder.aFindOrderRequest().withOrderId(500L).build();
        finder.findOrder(1L, request);
        verify(mockOrderRepository, times(1)).findByClientIdAndId(1L, 500L);
    }

    @Test
    public void testShouldBeFindByClientOrderId() {
        FindOrderRequest request = FindOrderRequestBuilder.aFindOrderRequest().withClientOrderId(400L).build();
        finder.findOrder(1L, request);
        verify(mockOrderRepository, times(1)).findByClientIdAndClientOrderId(1L, 400L);
    }

    @Test
    public void testShouldBeFindByCustomerId() {
        finder.findOrders(1L, 2L);
        verify(mockOrderRepository, times(1)).findByClientIdAndCustomerId(1L, 2L);
    }

}