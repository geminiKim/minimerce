package com.minimerce.core.api.component.order;

import com.minimerce.builder.DealOptionBuilder;
import com.minimerce.core.api.component.order.item.UsableOrderItemMaker;
import com.minimerce.core.api.domain.deal.option.DealOption;
import com.minimerce.core.api.support.object.type.DealType;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

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

    @Test
    public void testShouldBeMakeOrderItem() {
        DealOption option = DealOptionBuilder.aDealOption().withType(DealType.USABLE).build();
        maker.make(option);
        verify(usableOrderItemMaker, times(1)).make(any());
    }

}