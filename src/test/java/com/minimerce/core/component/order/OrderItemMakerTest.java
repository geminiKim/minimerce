package com.minimerce.core.component.order;

import com.minimerce.builder.DealOptionBuilder;
import com.minimerce.core.component.order.item.UsableOrderItemMaker;
import com.minimerce.core.domain.deal.option.DealOption;
import com.minimerce.core.object.type.DealType;
import com.minimerce.core.support.exception.UnsupportedItemTypeException;
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
    public void testShouldBeMakeOrderItem() throws UnsupportedItemTypeException {
        DealOption option = DealOptionBuilder.aDealOption().withType(DealType.USABLE).build();
        maker.make(option);
        verify(usableOrderItemMaker, times(1)).make(any());
    }

}