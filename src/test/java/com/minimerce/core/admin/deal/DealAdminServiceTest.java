package com.minimerce.core.admin.deal;

import com.minimerce.builder.DealBuilder;
import com.minimerce.core.api.domain.deal.Deal;
import com.minimerce.core.api.domain.deal.DealRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by gemini on 20/04/2017.
 */
public class DealAdminServiceTest {
    private DealAdminService dealAdminService;
    private DealRepository mockDealRepository;

    @Before
    public void setUp() {
        mockDealRepository = mock(DealRepository.class);
        dealAdminService = new DealAdminService(mockDealRepository);
    }

    @Test
    public void testShouldBeSaveNewDeal() {
        Deal deal = DealBuilder.aDeal().withId(null).build();
        dealAdminService.save(deal);
        verify(mockDealRepository, times(1)).save(deal);
    }

    @Test
    public void testShouldBeUpdateDeal() {
        Deal deal = DealBuilder.aDeal().withId(1L).build();
        dealAdminService.update(deal);
        verify(mockDealRepository, times(1)).save(deal);
    }
}