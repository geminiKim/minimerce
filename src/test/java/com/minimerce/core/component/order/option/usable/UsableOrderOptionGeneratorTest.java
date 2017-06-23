package com.minimerce.core.component.order.option.usable;

import com.minimerce.builder.UsableOptionBuilder;
import com.minimerce.core.domain.deal.option.usable.UsableOption;
import com.minimerce.core.domain.order.option.usable.UsableOrderOption;
import com.minimerce.core.object.order.CancelStatus;
import com.minimerce.core.object.order.OrderStatus;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by gemini on 20/06/2017.
 */
public class UsableOrderOptionGeneratorTest {
    private UsableOrderOptionGenerator generator;

    @Before
    public void setup() {
        generator = new UsableOrderOptionGenerator();
    }

    @Test
    public void testShouldBeGenerateUsableOption() {
        Long clientId = 1L;
        UsableOption option = UsableOptionBuilder.anUsableOption().build();
        UsableOrderOption orderOption = (UsableOrderOption) generator.generate(clientId, option);

        assertThat(orderOption.getClientId(), is(clientId));
        assertThat(orderOption.getDeal(), is(option.getDeal()));
        assertThat(orderOption.getTitle(), is(option.getName()));
        assertThat(orderOption.getStatus(), is(OrderStatus.ORDERED));
        assertThat(orderOption.getCancelStatus(), is(CancelStatus.NOT_CANCEL));
        assertThat(orderOption.getSalePrice(), is(option.getSalePrice()));
        assertThat(orderOption.getCostPrice(), is(option.getCostPrice()));
        assertThat(orderOption.getOption(), is(option));
        assertThat(orderOption.getUsedCount(), is(0));
        assertThat(orderOption.getUsableCount(), is(option.getUsableCount()));
        assertThat(orderOption.getAvailableStartAt(), is(option.getAvailableStartAt()));
        assertThat(orderOption.getAvailableEndAt(), is(option.getAvailableEndAt()));
    }
}