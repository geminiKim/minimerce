package com.minimerce.core.admin.deal;

import com.minimerce.builder.DealBuilder;
import com.minimerce.builder.DealOptionBuilder;
import com.minimerce.core.api.domain.deal.Deal;
import com.minimerce.core.api.domain.deal.DealRepository;
import com.minimerce.core.api.domain.deal.option.DealOption;
import com.minimerce.core.api.domain.deal.option.DealOptionRepository;
import com.minimerce.core.api.support.util.Yn;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by gemini on 23/04/2017.
 */
public class DealOptionAdminServiceTest {
    private DealOptionAdminService optionService;
    private DealRepository mockDealRepository;
    private DealOptionRepository mockOptionRepository;

    @Before
    public void setUp() {
        mockDealRepository = mock(DealRepository.class);
        mockOptionRepository = mock(DealOptionRepository.class);
        optionService = new DealOptionAdminService(mockDealRepository, mockOptionRepository);
    }

    @Test
    public void testShouldBeSave() {
        Deal deal = DealBuilder.aDeal().build();
        when(mockDealRepository.findOne(1L)).thenReturn(deal);

        DealOption option = DealOptionBuilder.aDealOption().build();
        optionService.save(1L, option);
        verify(mockDealRepository, times(1)).findOne(anyLong());
        verify(mockOptionRepository, times(1)).save(any(DealOption.class));
    }

    @Test
    public void testShouldBeDeleteOption() {
        DealOption option = DealOptionBuilder.aDealOption().withDeleted(Yn.N).build();
        when(mockOptionRepository.findOne(1L)).thenReturn(option);

        optionService.delete(1L);
        assertThat(option.getDeleted(), is(Yn.Y));
    }
}