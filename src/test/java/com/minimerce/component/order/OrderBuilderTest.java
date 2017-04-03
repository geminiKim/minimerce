package com.minimerce.component.order;

import com.minimerce.component.order.item.OptionItemReader;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.deal.option.DealOptionRepository;
import com.minimerce.domain.item.UsableItem;
import com.minimerce.domain.order.Order;
import com.minimerce.domain.order.OrderRepository;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by gemini on 30/03/2017.
 */
public class OrderBuilderTest {
    private OrderMaker maker;

    @Before
    public void setup() {
        OrderRepository mockOrderRepository = mock(OrderRepository.class);
        DealOptionRepository mockDealOptionRepository = mock(DealOptionRepository.class);
        OptionItemReader optionItemReader = mock(OptionItemReader.class);

        when(mockDealOptionRepository.findByClientIdAndId(anyLong())).thenReturn(new DealOption());
        when(optionItemReader.read(anyLong())).thenReturn(new UsableItem());

        maker = new OrderMaker(mockOrderRepository, mockDealOptionRepository, optionItemReader);
    }

    @Test
    public void testShouldBeBuildOrder() {
        OrderRequest request = new OrderRequest();
        Order order = maker.make(request);
        assertThat(order.getTotalAmount(), is(10000));
    }
}