package com.minimerce.core.component.order.option.delivery;

import com.minimerce.builder.DeliveryOptionBuilder;
import com.minimerce.core.domain.deal.option.delivery.DeliveryOption;
import com.minimerce.core.domain.order.option.delivery.DeliveryOrderOption;
import com.minimerce.core.domain.order.option.delivery.DeliveryStatus;
import com.minimerce.core.object.order.status.CancelStatus;
import com.minimerce.core.object.order.status.OrderStatus;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by gemini on 18/07/2017.
 */
public class DeliveryOrderOptionGeneratorTest {
    private DeliveryOrderOptionGenerator generator;

    @Before
    public void setup() {
        generator = new DeliveryOrderOptionGenerator();
    }

    @Test
    public void testShouldBeGenerateUsableOption() {
        Long clientId = 1L;
        DeliveryOption option = DeliveryOptionBuilder.aDeliveryOption().build();
        DeliveryOrderOption orderOption = (DeliveryOrderOption) generator.generate(clientId, option);

        assertThat(orderOption.getClientId(), is(clientId));
        assertThat(orderOption.getDeal(), is(option.getDeal()));
        assertThat(orderOption.getTitle(), is(option.getName()));
        assertThat(orderOption.getStatus(), is(OrderStatus.ORDERED));
        assertThat(orderOption.getCancelStatus(), is(CancelStatus.NOT_CANCEL));
        assertThat(orderOption.getSalePrice(), is(option.getSalePrice()));
        assertThat(orderOption.getCostPrice(), is(option.getCostPrice()));
        assertThat(orderOption.getOption(), is(option));
        assertThat(orderOption.getDeliveryStatus(), is(DeliveryStatus.WAIT));
    }
}