package com.minimerce.component.order;

import com.minimerce.domain.deal.option.DealOptionRepository;
import com.minimerce.domain.order.Order;
import com.minimerce.domain.order.OrderRepository;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by gemini on 30/03/2017.
 */
public class OrderBuilderTest {
    private OrderBuilder builder;

    @Before
    public void setup() {
        OrderRepository mockOrderRepository = mock(OrderRepository.class);
        DealOptionRepository mockDealOptionRepository = mock(DealOptionRepository.class);
        OptionItemReader optionItemReader = mock(OptionItemReader.class);
        builder = new OrderBuilder(mockOrderRepository, mockDealOptionRepository, optionItemReader);
    }

    @Test
    public void testShouldBeBuildOrder() {
        Order order = builder.build(request);
        assertThat(order.getTotalAmount(), is(10000));
    }
}