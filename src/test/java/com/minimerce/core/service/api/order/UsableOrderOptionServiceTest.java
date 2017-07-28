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


    @Before
    public void setup() {
        when(mockUsableOrderOptionRepository.findOne(1L)).thenReturn(testUsableOrder);

        usableOrderService = new UsableOrderOptionService(mockUsableOrderOptionRepository);
    }

    @Test
    public void testShouldBeUseOrderOption() {
        usableOrderService.use(1L);

        assertThat(testUsableOrder.getUsedCount(), is(1));
        assertThat(testUsableOrder.getStatus(), is(OrderStatus.USED));
    }
}