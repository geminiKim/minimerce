package com.minimerce.core.component.order.option;

import com.minimerce.builder.OptionBuilder;
import com.minimerce.builder.OrderOptionBuilder;
import com.minimerce.builder.OrderRequestDetailBuilder;
import com.minimerce.core.component.deal.DealFinder;
import com.minimerce.core.component.order.option.generator.OrderOptionGenerator;
import com.minimerce.core.domain.deal.option.Option;
import com.minimerce.core.object.order.OrderRequestDetail;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by gemini on 14/06/2017.
 */
public class OrderOptionMakerTest {
    private OrderOptionMaker maker;
    private final DealFinder mockDealFinder = mock(DealFinder.class);
    private final OrderOptionGenerator mockOrderOptionGenerator = mock(OrderOptionGenerator.class);

    private final OrderRequestDetailBuilder orderRequestDetailBuilder = OrderRequestDetailBuilder.anOrderRequestDetail();
    private final OrderOptionBuilder orderOptionBuilder = OrderOptionBuilder.anOrderOption();
    private final Option testOption = OptionBuilder.anOption().build();

    @Before
    public void setup() {
        when(mockDealFinder.findBySaleOption(any())).thenReturn(testOption);
        when(mockOrderOptionGenerator.generate(any(), any())).thenReturn(orderOptionBuilder.build());

        maker = new OrderOptionMaker(mockDealFinder, mockOrderOptionGenerator);
    }

    @Test
    public void testShouldBeMake() {
        Long clientId = 1L;
        OrderRequestDetail request = orderRequestDetailBuilder.build();
        maker.make(clientId, Lists.newArrayList(request));

        verify(mockDealFinder).findBySaleOption(request.getOptionId());
        verify(mockOrderOptionGenerator).generate(clientId, testOption);
    }
}