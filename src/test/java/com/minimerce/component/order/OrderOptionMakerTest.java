package com.minimerce.component.order;

import com.minimerce.builder.DealBuilder;
import com.minimerce.builder.DealOptionBuilder;
import com.minimerce.builder.OrderRequestDetailBuilder;
import com.minimerce.component.deal.SaleDealReader;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.order.option.OrderOption;
import com.minimerce.object.order.OrderRequestDetail;
import com.minimerce.support.exception.UnsaleableProductException;
import com.minimerce.support.exception.UnsupportedItemTypeException;
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
public class OrderOptionMakerTest {

    private SaleDealReader saleDealReader;
    private OrderItemMaker orderItemMaker;
    private OrderOptionMaker maker;
    private final OrderRequestDetailBuilder detailRequestBuilder = OrderRequestDetailBuilder.anOrderRequestDetail();

    @Before
    public void setup() throws UnsaleableProductException {
        saleDealReader = mock(SaleDealReader.class);
        orderItemMaker = mock(OrderItemMaker.class);

        when(saleDealReader.findBySaleDeal(anyLong())).thenReturn(buildCommonDeal());
        when(saleDealReader.findBySaleDealOption(anyLong())).thenReturn(buildOptionPrice5000());

        maker = new OrderOptionMaker(saleDealReader, orderItemMaker);
    }

    @Test
    public void testShouldBeBuildDetail() throws UnsaleableProductException, UnsupportedItemTypeException {
        List<OrderRequestDetail> requestDetails = Lists.newArrayList(detailRequestBuilder.build(), detailRequestBuilder.build());

        List<OrderOption> details = maker.make(1L, requestDetails);
        assertThat(details.get(0).getPrice(), is(5000));
        assertThat(details.size(), is(2));
    }

    private Deal buildCommonDeal() {
        return DealBuilder.aDeal().build();
    }

    private DealOption buildOptionPrice5000() {
        return DealOptionBuilder.aDealOption().withSalePrice(5000).build();
    }
}