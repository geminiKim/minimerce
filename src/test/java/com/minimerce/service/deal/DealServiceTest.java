package com.minimerce.service.deal;

import com.minimerce.builder.DealBuilder;
import com.minimerce.domain.deal.Deal;
import com.minimerce.domain.deal.DealRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by gemini on 20/04/2017.
 */
public class DealServiceTest {
    private DealService dealService;
    private DealRepository mockDealRepository;

    @Before
    public void setUp() {
        mockDealRepository = mock(DealRepository.class);
        dealService = new DealService(mockDealRepository);
    }

    @Test
    public void testShouldBeSaveNewDeal() {
        Deal deal = DealBuilder.aDeal().withId(null).build();
        dealService.newDeal(1L, deal);
        verify(mockDealRepository, times(1)).save(deal);
    }

    @Test
    public void testShouldBeUpdateDeal() {
        Deal deal = DealBuilder.aDeal().build();
        dealService.updateDeal(1L, deal);
        verify(mockDealRepository, times(1)).save(deal);
    }
}