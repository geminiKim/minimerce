package com.minimerce.component.order;

import com.minimerce.builder.OrderRequestDetailBuilder;
import com.minimerce.component.deal.DealOptionReader;
import com.minimerce.component.deal.DealReader;
import com.minimerce.domain.order.detail.OrderDetail;
import com.minimerce.object.order.OrderRequestDetail;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

/**
 * Created by gemini on 09/04/2017.
 */
public class OrderDetailMakerTest {

    private DealReader dealReader;
    private DealOptionReader dealOptionReader;
    private OrderItemMaker orderItemMaker;
    private OrderDetailMaker maker;
    private final OrderRequestDetailBuilder detailRequestBuilder = OrderRequestDetailBuilder.anOrderRequestDetail();


    @Before
    public void setup() {
        dealReader = mock(DealReader.class);
        dealOptionReader = mock(DealOptionReader.class);
        orderItemMaker = mock(OrderItemMaker.class);

        maker = new OrderDetailMaker(dealReader, dealOptionReader, orderItemMaker);
    }

    @Test
    public void testShouldBeBuildDetail() {

        List<OrderRequestDetail> requestDetails = Lists.newArrayList(detailRequestBuilder.build(), detailRequestBuilder.build());

        List<OrderDetail> details = maker.make(1L, 1L, requestDetails);
        assertThat(details.get(0).getPrice(), is(5000));
        assertThat(details.size(), is(2));
//        assertThat(details.get(0).getDetails().size(), is(2));
    }


}