package com.minimerce.core.component.stock;

import com.minimerce.builder.OptionBuilder;
import com.minimerce.builder.OrderRequestDetailBuilder;
import com.minimerce.core.domain.deal.option.Option;
import com.minimerce.core.domain.deal.option.OptionRepository;
import com.minimerce.core.object.deal.type.ProductType;
import com.minimerce.core.object.order.OrderRequestDetail;
import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.response.ErrorCode;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by gemini on 14/06/2017.
 */
public class StockConverterTest {
    private StockConverter converter;
    private final OptionRepository mockOptionRepository = mock(OptionRepository.class);
    private final OrderRequestDetailBuilder orderRequestDetailBuilder = OrderRequestDetailBuilder.anOrderRequestDetail();
    private final OptionBuilder optionBuilder = OptionBuilder.anOption();

    @Before
    public void setup() {
        when(mockOptionRepository.findOne(1L)).thenReturn(buildUsableOption());
        converter = new StockConverter(mockOptionRepository);
    }

    private Option buildUsableOption() {
        return optionBuilder.build();
    }

    @Test
    public void testShouldBeConvertStock() {
        OrderRequestDetail request = orderRequestDetailBuilder.withOptionId(1L).withQuantity(2).build();

        List<Stock> stocks = converter.convert(Lists.newArrayList(request));

        assertThat(stocks.get(0).getType(), is(ProductType.USABLE));
        assertThat(stocks.get(0).getOptionId(), is(1L));
        assertThat(stocks.get(0).getQuantity(), is(2));
    }

    @Test
    public void testShouldBeThrowsException_NOT_FOUND_DEAL() {
        try {
            OrderRequestDetail request = orderRequestDetailBuilder.withOptionId(2L).build();

            converter.convert(Lists.newArrayList(request));
            fail();
        } catch (MinimerceException e) {
            assertThat(e.getError(), is(ErrorCode.NOT_FOUND_OPTION));
        }
    }
}