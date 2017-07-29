package com.minimerce.core.service.api.order;

import com.minimerce.builder.UsableOrderOptionBuilder;
import com.minimerce.core.domain.order.option.usable.UsableOrderOption;
import com.minimerce.core.domain.order.option.usable.UsableOrderOptionRepository;
import com.minimerce.core.object.order.status.OrderStatus;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UsableOrderOptionServiceTest {
    private UsableOrderOptionService usableOrderService;
    private final UsableOrderOptionRepository mockUsableOrderOptionRepository = mock(UsableOrderOptionRepository.class);
    private final UsableOrderOption testUsableOrder = UsableOrderOptionBuilder.anUsableOrderOption().build();
    private final UsableOrderOption testUsedUsableOrder = UsableOrderOptionBuilder.anUsableOrderOption().withUsedCount(1).withStatus(OrderStatus.USED).build();


    @Before
    public void setup() {
        when(mockUsableOrderOptionRepository.findOne(1L)).thenReturn(testUsableOrder);
        when(mockUsableOrderOptionRepository.findOne(2L)).thenReturn(testUsedUsableOrder);

        usableOrderService = new UsableOrderOptionService(mockUsableOrderOptionRepository);
    }

    @Test
    public void testShouldBeUseOrderOption() {
        usableOrderService.use(1L);

        assertThat(testUsedUsableOrder.getUsedCount(), is(1));
        assertThat(testUsedUsableOrder.getStatus(), is(OrderStatus.USED));
    }

    @Test
    public void testShouldBeRestoreOrderOption() {
        usableOrderService.restore(2L);

        assertThat(testUsedUsableOrder.getUsedCount(), is(0));
        assertThat(testUsedUsableOrder.getStatus(), is(OrderStatus.ORDERED));
    }
}