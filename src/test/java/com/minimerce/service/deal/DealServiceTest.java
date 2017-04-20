package com.minimerce.service.deal;

import com.minimerce.builder.DealBuilder;
import com.minimerce.domain.deal.Deal;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by gemini on 20/04/2017.
 */
public class DealServiceTest {
    private DealService dealService;
    private DealInserter mockDealInserter;

    @Before
    public void setUp() {
        mockDealInserter = mock(DealInserter.class);
        dealService = new DealService(mockDealInserter);
    }

    @Test
    public void testShouldBeInsertDeal() {
        Deal deal = DealBuilder.aDeal().build();
        dealService.newDeal(1L, deal);
        verify(mockDealInserter, times(1)).insert(deal);
    }
}