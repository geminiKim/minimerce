package com.minimerce.core.component.order;

import com.minimerce.builder.OrderBuilder;
import com.minimerce.core.domain.order.Order;
import com.minimerce.core.domain.order.OrderRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

        verify(mockOrderRepository).save(order);
    }
}