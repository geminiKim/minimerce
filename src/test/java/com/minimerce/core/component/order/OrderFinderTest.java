package com.minimerce.core.component.order;

import com.minimerce.builder.FindOrderRequestBuilder;
import com.minimerce.builder.OrderCancelRequestBuilder;
import com.minimerce.builder.PageableBuilder;
import com.minimerce.core.domain.order.OrderRepository;
import com.minimerce.core.domain.order.option.OrderOptionRepository;
import com.minimerce.core.object.order.FindOrderRequest;
import com.minimerce.core.object.order.cancel.OrderCancelRequest;
import com.minimerce.core.support.exception.MinimerceException;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Pageable;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by gemini on 20/04/2017.
 */
public class OrderFinderTest {
    private OrderFinder finder;
    private final OrderRepository mockOrderRepository = mock(OrderRepository.class);
    private final OrderOptionRepository mockOrderOptionRepository = mock(OrderOptionRepository.class);

    @Before
    public void setup() {
        finder = new OrderFinder(mockOrderRepository, mockOrderOptionRepository);

    }

    @Test
    public void testShouldBeThrowsNotExistOrderExceptionByNotSupportRequest() {
        FindOrderRequest request = FindOrderRequestBuilder.aFindOrderRequest().withOrderId(500L).withClientOrderId(400L).build();
        try {
            finder.findOrder(1L, request);
            fail();
        } catch (MinimerceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testShouldBeFindByOrderId() {
        FindOrderRequest request = FindOrderRequestBuilder.aFindOrderRequest().withOrderId(500L).build();
        finder.findOrder(1L, request);
        verify(mockOrderRepository).findByClientIdAndId(1L, 500L);
    }

    @Test
    public void testShouldBeFindByClientOrderId() {
        FindOrderRequest request = FindOrderRequestBuilder.aFindOrderRequest().withClientOrderId(400L).build();
        finder.findOrder(1L, request);
        verify(mockOrderRepository).findByClientIdAndClientOrderId(1L, 400L);
    }

    @Test
    public void testShouldBeFindByCustomerId() {
        Pageable page = PageableBuilder.aPageable().build();
        finder.findOrders(1L, 2L, page);
        verify(mockOrderRepository).findByClientIdAndCustomerId(1L, 2L, page);
    }

    @Test
    public void testShouldBeFindByFullCancelOptions() {
        OrderCancelRequest request = OrderCancelRequestBuilder.anOrderCancelRequest().build();
        finder.findCancelOptions(1L, request);
        verify(mockOrderOptionRepository).findByClientIdAndOrderId(1L, request.getOrderId());
    }

    @Test
    public void testShouldBeFindByPartialCancelOptions() {
        OrderCancelRequest request = OrderCancelRequestBuilder.anOrderCancelRequest().withOrderOptionId(Lists.newArrayList(1L, 2L)).build();
        finder.findCancelOptions(1L, request);
        verify(mockOrderOptionRepository).findByClientIdAndOrderIdAndIdIn(1L, request.getOrderId(), request.getOrderOptionId());
    }
}