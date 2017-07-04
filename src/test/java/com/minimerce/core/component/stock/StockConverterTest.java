package com.minimerce.core.component.stock;

import com.minimerce.builder.OrderOptionBuilder;
import com.minimerce.core.object.deal.type.ProductType;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by gemini on 14/06/2017.
 */
public class StockConverterTest {
    private StockConverter converter;
    private final OrderOptionBuilder orderOptionBuilder = OrderOptionBuilder.anOrderOption();

    @Before
    public void setup() {
        converter = new StockConverter();
    }

    @Test
    public void testShouldBeConvertStock() {
        List<Stock> stocks = converter.convert(Lists.newArrayList(orderOptionBuilder.build(), orderOptionBuilder.build()));

        assertThat(stocks.get(0).getType(), is(ProductType.USABLE));
        assertThat(stocks.get(0).getOptionId(), is(1L));
        assertThat(stocks.get(0).getQuantity(), is(2));
    }
}