package com.minimerce.core.api.component.order;

import com.minimerce.builder.OrderBuilder;
import com.minimerce.core.api.domain.order.Order;
import com.minimerce.core.api.domain.order.OrderRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by gemini on 24/05/2017.
 */
public class OrderInserterTest {
    private OrderInserter inserter;
    private OrderRepository mockOrderRepository;

    @Before
    public void setup() {
        mockOrderRepository = mock(OrderRepository.class);
        inserter = new OrderInserter(mockOrderRepository);
    }

    @Test
    public void testShouldBeCallSaveOfRepository() {
        Order order = OrderBuilder.anOrder().build();
        inserter.insert(order);

        verify(mockOrderRepository, times(1)).save(order);
    }
}