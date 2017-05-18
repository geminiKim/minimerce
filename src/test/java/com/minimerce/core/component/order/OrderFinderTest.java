package com.minimerce.core.component.order;

import com.minimerce.builder.FindOrderRequestBuilder;
import com.minimerce.core.domain.order.OrderRepository;
import com.minimerce.core.object.order.FindOrderRequest;
import com.minimerce.core.support.exception.NotExistOrderException;
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
        } catch (NotExistOrderException e) {
            System.out.println("Should Be Throws NotExistOrderException");
        }
    }

    @Test
    public void testShouldBeFindByOrderId() throws NotExistOrderException {
        FindOrderRequest request = FindOrderRequestBuilder.aFindOrderRequest().withOrderId(500L).build();
        finder.findOrder(1L, request);
        verify(mockOrderRepository, times(1)).findByClientIdAndId(1L, 500L);
    }

    @Test
    public void testShouldBeFindByClientOrderId() throws NotExistOrderException {
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