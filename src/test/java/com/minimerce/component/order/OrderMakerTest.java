package com.minimerce.component.order;

import com.minimerce.builder.OrderDetailBuilder;
import com.minimerce.builder.OrderRequestBuilder;
import com.minimerce.builder.OrderRequestDetailBuilder;
import com.minimerce.domain.order.Order;
import com.minimerce.domain.order.detail.OrderDetail;
import com.minimerce.object.order.OrderRequest;
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
    private final OrderRequestDetailBuilder detailRequestBuilder = OrderRequestDetailBuilder.anOrderRequestDetail();

    @Before
    public void setup() {
        OrderDetailMaker orderDetailMaker = mock(OrderDetailMaker.class);
        when(orderDetailMaker.make(anyLong(), anyLong(), any())).thenReturn(details());
        maker = new OrderMaker(orderDetailMaker);
    }

    @Test
    public void testShouldBeBuildOrder() {
        OrderRequest request = orderRequestBuilder.build();
        request.addDetail(detailRequestBuilder.build());
        request.addDetail(detailRequestBuilder.build());

        Order order = maker.make(1L, request);
        assertThat(order.getPrice(), is(10000));
        assertThat(order.getDetails().size(), is(2));
    }

    private ArrayList<OrderDetail> details() {
        OrderDetailBuilder anOrderDetail = OrderDetailBuilder.anOrderDetail();
        return Lists.newArrayList(anOrderDetail.build(), anOrderDetail.build());
    }
}