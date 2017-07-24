package com.minimerce.core.component.order;

import com.minimerce.builder.UsableOrderOptionBuilder;
import com.minimerce.core.component.order.option.validator.OrderStatusValidator;
import com.minimerce.core.component.order.option.validator.OrderStatusValidatorFactory;
import com.minimerce.core.component.order.option.validator.UsableOrderStatusValidator;
import com.minimerce.core.domain.order.option.usable.UsableOrderOption;
import com.minimerce.core.object.deal.type.ProductType;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by gemini on 26/06/2017.
 */
public class OrderStatusValidatorTest {
    private OrderStatusValidator validator;
    private final UsableOrderStatusValidator mockUsableOrderStatusValidator = mock(UsableOrderStatusValidator.class);
    private final OrderStatusValidatorFactory mockValidatorFactory = mock(OrderStatusValidatorFactory.class);

    @Before
    public void setup() {
        when(mockValidatorFactory.getValidator(ProductType.USABLE)).thenReturn(mockUsableOrderStatusValidator);
        validator = new OrderStatusValidator(mockValidatorFactory);
    }

    @Test
    public void testShouldBeValidate( ){
        UsableOrderOption usableOrderOption = UsableOrderOptionBuilder.anUsableOrderOption().build();
        validator.validate(Lists.newArrayList(usableOrderOption));

        verify(mockValidatorFactory).getValidator(ProductType.USABLE);
        verify(mockUsableOrderStatusValidator).validate(usableOrderOption);
    }

}