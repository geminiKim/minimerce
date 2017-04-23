package com.minimerce.service.deal;

import com.minimerce.builder.DealOptionBuilder;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.deal.option.DealOptionRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by gemini on 23/04/2017.
 */
public class DealOptionServiceTest {
    private DealOptionService mockOptionService;
    private DealOptionRepository mockOptionRepository;

    @Before
    public void setUp() {
        mockOptionRepository = mock(DealOptionRepository.class);
        mockOptionService = new DealOptionService(mockOptionRepository);
    }

    @Test
    public void testShouldBeSaveNewOption() {
        DealOption option = DealOptionBuilder.aDealOption().withId(null).build();
        mockOptionService.newDeal(1L, option);
        verify(mockOptionRepository, times(1)).save(option);
    }

    @Test
    public void testShouldBeUpdateOption() {
        DealOption option = DealOptionBuilder.aDealOption().withId(1L).build();
        mockOptionService.updateDeal(1L, option);
        verify(mockOptionRepository, times(1)).save(option);
    }
}