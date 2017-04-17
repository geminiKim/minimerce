package com.minimerce.component.order;

import com.minimerce.builder.DealOptionBuilder;
import com.minimerce.component.order.item.UsableOrderItemMaker;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.order.item.OrderItem;
import com.minimerce.support.exception.UnsupportedItemTypeException;
import org.junit.Before;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by gemini on 14/04/2017.
 */
public class OrderItemMakerTest {

    private OrderItemMaker maker;
    private UsableOrderItemMaker usableOrderItemMaker;

    @Before
    public void setup() {
        usableOrderItemMaker = mock(UsableOrderItemMaker.class);
        maker = new OrderItemMaker(usableOrderItemMaker);
    }

    public void testShouldBeMakeOrderItem() throws UnsupportedItemTypeException {
        DealOption option = DealOptionBuilder.aDealOption().build();
        List<OrderItem> items = maker.make(option);
        assertThat(items.size(), is(1));
    }

}