package com.minimerce.core.api.component.order;

import com.minimerce.builder.OrderOptionBuilder;
import com.minimerce.builder.OrderRequestBuilder;
import com.minimerce.builder.OrderRequestDetailBuilder;
import com.minimerce.core.api.domain.order.Order;
import com.minimerce.core.api.domain.order.option.OrderOption;
import com.minimerce.core.api.support.object.order.OrderRequest;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by gemini on 30/03/2017.
 */
public class OrderMakerTest {
    private OrderMaker maker;
    private final OrderRequestBuilder orderRequestBuilder = OrderRequestBuilder.anOrderRequest();
    private final OrderRequestDetailBuilder orderRequestDetailBuilder = OrderRequestDetailBuilder.anOrderRequestDetail();

    @Before
    public void setup() {
        OrderOptionMaker orderDetailMaker = mock(OrderOptionMaker.class);
        when(orderDetailMaker.make(anyLong(), any())).thenReturn(details());
        maker = new OrderMaker(orderDetailMaker);
    }

    @Test
    public void testShouldBeBuildOrder() {
        OrderRequest request = orderRequestBuilder.build();
        request.addDetail(orderRequestDetailBuilder.build());
        request.addDetail(orderRequestDetailBuilder.build());

        Order order = maker.make(1L, request);
        assertThat(order.getPrice(), is(10000));
        assertThat(order.getOptions().size(), is(2));
    }

    private ArrayList<OrderOption> details() {
        OrderOptionBuilder anOrderOption = OrderOptionBuilder.anOrderOption();
        return Lists.newArrayList(anOrderOption.build(), anOrderOption.build());
    }
}