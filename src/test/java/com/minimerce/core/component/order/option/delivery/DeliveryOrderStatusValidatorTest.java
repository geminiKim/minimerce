package com.minimerce.core.component.order.option.delivery;

import com.minimerce.DeliveryOrderOptionBuilder;
import com.minimerce.core.domain.order.option.delivery.DeliveryOrderOption;
import com.minimerce.core.domain.order.option.delivery.DeliveryStatus;
import com.minimerce.core.object.order.status.CancelStatus;
import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.response.ErrorCode;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by gemini on 21/07/2017.
 */
public class DeliveryOrderStatusValidatorTest {
    private DeliveryOrderStatusValidator validator;

    @Before
    public void setup() {
        validator = new DeliveryOrderStatusValidator();
    }

    @Test
    public void testShouldBeValidateByDeliveryStartedOrderOption() {
        try {
            DeliveryOrderOption option = DeliveryOrderOptionBuilder.aDeliveryOrderOption().withDeliveryStatus(DeliveryStatus.SENDING).build();
            validator.validate(option);
        } catch (MinimerceException e) {
            assertThat(e.getError(), is(ErrorCode.DELIVERY_STARTED_ORDER));
        }
    }

    @Test
    public void testShouldBeValidateByDeliveryFinishedOrderOption() {
        try {
            DeliveryOrderOption option = DeliveryOrderOptionBuilder.aDeliveryOrderOption().withDeliveryStatus(DeliveryStatus.FINISH).build();
            validator.validate(option);
        } catch (MinimerceException e) {
            assertThat(e.getError(), is(ErrorCode.DELIVERY_FINISHED_ORDER));
        }
    }

    @Test
    public void testShouldBeValidateByAlreadyCanceledOrderOption() {
        try {
            DeliveryOrderOption option = DeliveryOrderOptionBuilder.aDeliveryOrderOption().withCancelStatus(CancelStatus.CANCEL).build();
            validator.validate(option);
        } catch (MinimerceException e) {
            assertThat(e.getError(), is(ErrorCode.ALREADY_CANCELED_ORDER));
        }
    }
}