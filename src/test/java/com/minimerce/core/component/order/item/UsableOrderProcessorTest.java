package com.minimerce.core.component.order.item;

import com.minimerce.builder.OrderOptionBuilder;
import com.minimerce.builder.UsableOrderItemBuilder;
import com.minimerce.core.domain.order.item.usable.UsableOrderItem;
import com.minimerce.core.domain.order.item.usable.UsableOrderItemRepository;
import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.support.object.order.OrderStatus;
import com.minimerce.core.support.object.type.DealType;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by gemini on 30/05/2017.
 */
public class UsableOrderProcessorTest {
    private UsableOrderProcessor processor;
    private UsableOrderItemRepository mockUsableOrderItemRepository;

    private final UsableOrderItemBuilder usableOrderBuilder = UsableOrderItemBuilder.anUsableOrderItem();

    @Before
    public void setup() {
        mockUsableOrderItemRepository = mock(UsableOrderItemRepository.class);
        processor = new UsableOrderProcessor(mockUsableOrderItemRepository);
    }

    @Test
    public void consume() throws Exception {
        UsableOrderItem usableOrder = usableOrderBuilder.withOption(UsableOrderOption()).withUsedCount(0).build();
        when(mockUsableOrderItemRepository.findOne(1L)).thenReturn(usableOrder);

        processor.consume(1L);
        assertThat(usableOrder.getUsedCount(), is(1));
        assertThat(usableOrder.getStatus(), is(OrderStatus.USED));
        assertThat(usableOrder.getOption().getStatus(), is(OrderStatus.USED));
    }

    @Test
    public void restore() throws Exception {
        UsableOrderItem usableOrder = usableOrderBuilder.withOption(UsableOrderOption()).withUsedCount(1).build();
        when(mockUsableOrderItemRepository.findOne(1L)).thenReturn(usableOrder);

        processor.restore(1L);
        assertThat(usableOrder.getUsedCount(), is(0));
        assertThat(usableOrder.getStatus(), is(OrderStatus.ORDERED));
        assertThat(usableOrder.getOption().getStatus(), is(OrderStatus.ORDERED));
    }

    private OrderOption UsableOrderOption() {
        return OrderOptionBuilder.anOrderOption().withType(DealType.USABLE).build();
    }
}