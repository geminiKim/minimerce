package com.minimerce.core.api.component.order;

import com.minimerce.builder.DealBuilder;
import com.minimerce.builder.DealOptionBuilder;
import com.minimerce.builder.OrderItemBuilder;
import com.minimerce.builder.OrderRequestDetailBuilder;
import com.minimerce.core.api.component.deal.SaleDealReader;
import com.minimerce.core.api.domain.order.item.OrderItem;
import com.minimerce.core.api.domain.order.option.OrderOption;
import com.minimerce.core.api.support.object.order.OrderRequestDetail;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by gemini on 09/04/2017.
 */
public class OrderOptionMakerTest {

    private SaleDealReader saleDealReader;
    private OrderItemMaker orderItemMaker;
    private OrderOptionMaker maker;
    private final OrderRequestDetailBuilder detailRequestBuilder = OrderRequestDetailBuilder.anOrderRequestDetail();

    @Before
    public void setup() {
        saleDealReader = mock(SaleDealReader.class);
        orderItemMaker = mock(OrderItemMaker.class);

        when(saleDealReader.findBySaleDeal(anyLong())).thenReturn(DealBuilder.aDeal().build());
        when(saleDealReader.findBySaleDealOption(anyLong())).thenReturn(DealOptionBuilder.aDealOption().build());

        when(orderItemMaker.make(any())).thenReturn(buildOrderItemsPrice5000());

        maker = new OrderOptionMaker(saleDealReader, orderItemMaker);
    }

    @Test
    public void testShouldBeBuildDetail() {
        List<OrderRequestDetail> requestDetails = Lists.newArrayList(detailRequestBuilder.build(), detailRequestBuilder.build());

        List<OrderOption> details = maker.make(1L, requestDetails);
        assertThat(details.get(0).getPrice(), is(5000));
        assertThat(details.size(), is(2));
    }

    private List<OrderItem> buildOrderItemsPrice5000() {
        OrderItemBuilder itemBuilder = OrderItemBuilder.anOrderItem();
        return Lists.newArrayList(itemBuilder.withSalePrice(5000).build());
    }
}