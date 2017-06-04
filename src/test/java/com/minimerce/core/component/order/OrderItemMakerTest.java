package com.minimerce.core.component.order;

import com.minimerce.builder.DealOptionBuilder;
import com.minimerce.core.component.order.item.UsableOrderItemMaker;
import com.minimerce.core.domain.deal.option.DealOption;
import com.minimerce.core.support.object.type.ProductType;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by gemini on 14/04/2017.
 */
public class OrderItemMakerTest {
    private OrderItemMaker maker;
    private UsableOrderItemMaker mockUsableOrderItemMaker;

    @Before
    public void setup() {
        mockUsableOrderItemMaker = mock(UsableOrderItemMaker.class);
        maker = new OrderItemMaker(mockUsableOrderItemMaker);
    }

    @Test
    public void testShouldBeMakeOrderItem() {
        DealOption option = DealOptionBuilder.aDealOption().withType(ProductType.USABLE).build();
        maker.make(option);
        verify(mockUsableOrderItemMaker, times(1)).make(any());
    }

}