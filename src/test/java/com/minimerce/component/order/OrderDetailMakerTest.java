package com.minimerce.component.order;

import com.minimerce.builder.DealBuilder;
import com.minimerce.builder.DealOptionBuilder;
import com.minimerce.builder.OrderRequestDetailBuilder;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.DealRepository;
import com.minimerce.domain.order.detail.OrderDetail;
import com.minimerce.object.order.OrderRequestDetail;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by gemini on 09/04/2017.
 */
public class OrderDetailMakerTest {

    private DealRepository dealRepository;
    private OrderItemMaker orderItemMaker;
    private OrderDetailMaker maker;
    private final OrderRequestDetailBuilder detailRequestBuilder = OrderRequestDetailBuilder.anOrderRequestDetail();

    @Before
    public void setup() {
        dealRepository = mock(DealRepository.class);
        orderItemMaker = mock(OrderItemMaker.class);

        when(dealRepository.findByClientIdAndId(anyLong(), anyLong())).thenReturn(getCommonDeal());

        maker = new OrderDetailMaker(dealRepository, orderItemMaker);
    }

    @Test
    public void testShouldBeBuildDetail() {
        List<OrderRequestDetail> requestDetails = Lists.newArrayList(detailRequestBuilder.build(), detailRequestBuilder.build());

        List<OrderDetail> details = maker.make(1L, 1L, requestDetails);
        assertThat(details.get(0).getPrice(), is(5000));
        assertThat(details.size(), is(2));
    }

    private Deal getCommonDeal() {
        Deal deal = DealBuilder.aDeal().build();
        deal.addOption(DealOptionBuilder.aDealOption().withSalePrice(5000).build());
        return deal;
    }
}