package com.minimerce.core.component.order;

import com.minimerce.builder.UsableOrderOptionBuilder;
import com.minimerce.core.domain.order.option.usable.UsableOrderOption;
import com.minimerce.core.object.order.status.CancelStatus;
import com.minimerce.core.object.order.status.OrderStatus;
import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.response.ErrorCode;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by gemini on 28/06/2017.
 */
public class UsableOrderStatusValidatorTest {

    private UsableOrderStatusValidator validator;

    @Before
    public void setup() {
        validator = new UsableOrderStatusValidator();
    }

    @Test
    public void testShouldBeValidateByAlreadyUsedOrderOption() {
        try {
            UsableOrderOption usableOrderOption = UsableOrderOptionBuilder.anUsableOrderOption().withStatus(OrderStatus.USED).build();
            validator.validate(usableOrderOption);
        } catch (MinimerceException e) {
            assertThat(e.getError(), is(ErrorCode.ALREADY_USE_COMPLETED_ORDER));
        }
    }

    @Test
    public void testShouldBeValidateByAlreadyCanceledOrderOption() {
        try {
            UsableOrderOption usableOrderOption = UsableOrderOptionBuilder.anUsableOrderOption().withCancelStatus(CancelStatus.CANCEL).build();
            validator.validate(usableOrderOption);
        } catch (MinimerceException e) {
            assertThat(e.getError(), is(ErrorCode.ALREADY_CANCELED_ORDER));
        }
    }
}