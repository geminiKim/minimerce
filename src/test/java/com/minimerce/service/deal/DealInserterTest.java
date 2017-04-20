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
public class DealInserterTest {

    private DealInserter inserter;
    private DealRepository mockDealRepository;

    @Before
    public void setUp() {
        mockDealRepository = mock(DealRepository.class);
        inserter = new DealInserter(mockDealRepository);
    }

    @Test
    public void testShouldBeCallSaveDeal() {
        Deal deal = DealBuilder.aDeal().build();
        inserter.insert(deal);
        verify(mockDealRepository, times(1)).save(deal);
    }

}