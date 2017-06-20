package com.minimerce.core.component.order.option;

import com.minimerce.builder.OptionBuilder;
import com.minimerce.builder.OrderOptionBuilder;
import com.minimerce.builder.OrderRequestDetailBuilder;
import com.minimerce.core.component.deal.SaleDealReader;
import com.minimerce.core.domain.deal.option.Option;
import com.minimerce.core.support.object.order.OrderRequestDetail;
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
    private final SaleDealReader mockSaleDealReader = mock(SaleDealReader.class);
    private final OrderOptionGenerator mockOrderOptionGenerator = mock(OrderOptionGenerator.class);

    private final OrderRequestDetailBuilder orderRequestDetailBuilder = OrderRequestDetailBuilder.anOrderRequestDetail();
    private final OrderOptionBuilder orderOptionBuilder = OrderOptionBuilder.anOrderOption();
    private final Option testOption = OptionBuilder.anOption().build();

    @Before
    public void setup() {
        when(mockSaleDealReader.findBySaleOption(any())).thenReturn(testOption);
        when(mockOrderOptionGenerator.generate(any(), any())).thenReturn(orderOptionBuilder.build());

        maker = new OrderOptionMaker(mockSaleDealReader, mockOrderOptionGenerator);
    }

    @Test
    public void testShouldBeMake() {
        Long clientId = 1L;
        OrderRequestDetail request = orderRequestDetailBuilder.build();
        maker.make(clientId, Lists.newArrayList(request));

        verify(mockSaleDealReader).findBySaleOption(request.getOptionId());
        verify(mockOrderOptionGenerator).generate(clientId, testOption);
    }
}