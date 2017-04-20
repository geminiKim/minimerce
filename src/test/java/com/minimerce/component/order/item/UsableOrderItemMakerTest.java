package com.minimerce.component.order.item;

import com.minimerce.builder.DealOptionBuilder;
import com.minimerce.builder.UsableItemBuilder;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.item.UsableItem;
import com.minimerce.domain.item.UsableItemRepository;
import com.minimerce.domain.order.item.OrderItem;
import com.minimerce.domain.order.item.usable.UsableOrderItem;
import com.minimerce.domain.order.item.usable.UsableOrderItemRepository;
import com.minimerce.domain.order.status.CancelStatus;
import com.minimerce.domain.order.status.OrderStatus;
import com.minimerce.domain.type.DealType;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by gemini on 18/04/2017.
 */
public class UsableOrderItemMakerTest {

    private UsableOrderItemMaker maker;
    private UsableItemRepository mockUsableItemRepository;
    private UsableOrderItemRepository mockUsableOrderItemRepository;

    @Before
    public void setup() {
        mockUsableItemRepository = mock(UsableItemRepository.class);
        mockUsableOrderItemRepository = mock(UsableOrderItemRepository.class);

        UsableItem findItem = UsableItemBuilder.anUsableItem().build();
        when(mockUsableItemRepository.findByIdIn(any())).thenReturn(Lists.newArrayList(findItem));

        maker = new UsableOrderItemMaker(mockUsableItemRepository, mockUsableOrderItemRepository);
    }
    @Test
    public void testShouldBeMakeUsableOrderItem() {
        DealOption option = DealOptionBuilder.aDealOption().withType(DealType.USABLE).build();
        List<OrderItem> items = maker.make(option);

        assertThat(items.size(), is(1));
        verify(mockUsableItemRepository, times(1)).findByIdIn(any());
        verify(mockUsableOrderItemRepository, times(1)).save(any(UsableOrderItem.class));
    }

    @Test
    public void testShouldBeFillOrderItemField() {
        DealOption option = DealOptionBuilder.aDealOption().withType(DealType.USABLE).build();
        List<OrderItem> items = maker.make(option);

        assertThat(items.get(0).getTitle(), is("test-usable-item"));
        assertThat(items.get(0).getType(), is(DealType.USABLE));
        assertThat(items.get(0).getSalePrice(), is(1000));
        assertThat(items.get(0).getCostPrice(), is(500));
        assertThat(items.get(0).getStatus(), is(OrderStatus.ORDERED));
        assertThat(items.get(0).getCancelStatus(), is(CancelStatus.NOT_CANCEL));
    }

}