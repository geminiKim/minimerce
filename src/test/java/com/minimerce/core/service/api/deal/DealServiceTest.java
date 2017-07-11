package com.minimerce.core.service.api.deal;

import com.minimerce.builder.PageableBuilder;
import com.minimerce.core.component.deal.DealFinder;
import com.minimerce.core.object.deal.FindDealRequest;
import com.minimerce.core.object.deal.FindDealRequestBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by gemini on 11/07/2017.
 */
public class DealServiceTest {
    private DealService service;
    private final DealFinder mockDealFinder = mock(DealFinder.class);

    @Before
    public void setup() {
        service = new DealService(mockDealFinder);
    }

    @Test
    public void testShouldBeFindDeals() {
        FindDealRequest request = FindDealRequestBuilder.aFindDealRequest().build();
        Pageable page = PageableBuilder.aPageable().build();

        service.findDeals(request, page);
        verify(mockDealFinder).findDeals(request, page);
    }

    @Test
    public void testShouldBeFindDeal() {
        service.findDeal(1L);
        verify(mockDealFinder).findBySaleDeal(1L);
    }
}