package com.minimerce.core.component.order.item;

import com.minimerce.builder.DealOptionBuilder;
import com.minimerce.builder.DealOptionItemBuilder;
import com.minimerce.builder.UsableItemBuilder;
import com.minimerce.core.domain.deal.option.DealOption;
import com.minimerce.core.domain.deal.option.item.DealOptionItem;
import com.minimerce.core.domain.order.item.OrderItem;
import com.minimerce.core.support.object.order.CancelStatus;
import com.minimerce.core.support.object.order.OrderStatus;
import com.minimerce.core.support.object.type.DealType;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by gemini on 18/04/2017.
 */
public class UsableOrderItemMakerTest {

    private UsableOrderItemMaker maker;

    @Before
    public void setup() {
        maker = new UsableOrderItemMaker();
    }
    @Test
    public void testShouldBeFillOrderItemField() {
        DealOptionItem optionItem = DealOptionItemBuilder.aDealOptionItem().build();
        optionItem.setItem(UsableItemBuilder.anUsableItem().build());

        DealOption option = DealOptionBuilder.aDealOption().withType(DealType.USABLE).build();
        option.addItem(optionItem);

        List<OrderItem> items = maker.make(option);

        assertThat(items.get(0).getTitle(), is("test-usable-item"));
        assertThat(items.get(0).getType(), is(DealType.USABLE));
        assertThat(items.get(0).getSalePrice(), is(1000));
        assertThat(items.get(0).getCostPrice(), is(500));
        assertThat(items.get(0).getStatus(), is(OrderStatus.ORDERED));
        assertThat(items.get(0).getCancelStatus(), is(CancelStatus.NOT_CANCEL));
    }

}