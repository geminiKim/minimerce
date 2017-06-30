package com.minimerce.core.component.order;

import com.minimerce.builder.OrderOptionBuilder;
import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.object.order.status.CancelStatus;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by gemini on 30/06/2017.
 */
public class OrderCancelerTest {
    private OrderCanceler canceler;

    @Before
    public void setup() {
        canceler = new OrderCanceler();
    }

    @Test
    public void testShouldBeCancelOrderOptions() {
        OrderOption orderOption = OrderOptionBuilder.anOrderOption().build();
        canceler.cancel(Lists.newArrayList(orderOption));

        assertThat(orderOption.getCancelStatus(), is(CancelStatus.CANCEL));
    }
}