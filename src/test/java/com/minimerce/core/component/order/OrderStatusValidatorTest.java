package com.minimerce.core.component.order;

import com.minimerce.builder.UsableOrderOptionBuilder;
import com.minimerce.core.component.order.option.validator.UsableOrderStatusValidator;
import com.minimerce.core.domain.order.option.usable.UsableOrderOption;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by gemini on 26/06/2017.
 */
public class OrderStatusValidatorTest {
    private OrderStatusValidator validator;
    private final UsableOrderStatusValidator mockUsableOrderStatusValidator = mock(UsableOrderStatusValidator.class);

    @Before
    public void setup() {
        validator = new OrderStatusValidator(mockUsableOrderStatusValidator);
    }

    @Test
    public void testShouldBeValidate( ){
        UsableOrderOption usableOrderOption = UsableOrderOptionBuilder.anUsableOrderOption().build();
        validator.validate(Lists.newArrayList(usableOrderOption));

        verify(mockUsableOrderStatusValidator).validate(usableOrderOption);
    }

}