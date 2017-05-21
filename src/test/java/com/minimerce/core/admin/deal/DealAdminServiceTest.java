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
    public void testShouldBeSave() {
        Deal deal = DealBuilder.aDeal().build();
        dealAdminService.save(deal);
        verify(mockDealRepository, times(1)).save(deal);
    }
}