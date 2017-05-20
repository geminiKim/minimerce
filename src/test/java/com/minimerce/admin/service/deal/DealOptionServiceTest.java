package com.minimerce.admin.service.deal;

import com.minimerce.builder.DealBuilder;
import com.minimerce.builder.DealOptionBuilder;
import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.DealRepository;
import com.minimerce.core.domain.deal.option.DealOption;
import com.minimerce.core.domain.deal.option.DealOptionRepository;
import com.minimerce.core.support.util.Yn;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by gemini on 23/04/2017.
 */
public class DealOptionServiceTest {
    private DealOptionService optionService;
    private DealRepository mockDealRepository;
    private DealOptionRepository mockOptionRepository;

    @Before
    public void setUp() {
        mockDealRepository = mock(DealRepository.class);
        mockOptionRepository = mock(DealOptionRepository.class);
        optionService = new DealOptionService(mockDealRepository, mockOptionRepository);
    }

    @Test
    public void testShouldBeSaveNewOption() {
        Deal deal = DealBuilder.aDeal().build();
        when(mockDealRepository.findOne(1L)).thenReturn(deal);

        DealOption option = DealOptionBuilder.aDealOption().withId(null).build();
        optionService.save(1L, option);
        assertThat(deal.getOptions().size(), is(1));
    }

    @Test
    public void testShouldBeUpdateOption() {
        DealOption option = DealOptionBuilder.aDealOption().withId(1L).build();
        optionService.update(option);
        verify(mockOptionRepository, times(1)).save(option);
    }

    @Test
    public void testShouldBeDeleteOption() {
        DealOption option = DealOptionBuilder.aDealOption().withDeleted(Yn.N).build();
        when(mockOptionRepository.findOne(1L)).thenReturn(option);

        optionService.delete(1L);
        assertThat(option.getDeleted(), is(Yn.Y));
    }
}