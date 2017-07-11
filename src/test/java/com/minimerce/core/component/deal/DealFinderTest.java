package com.minimerce.core.component.deal;

import com.minimerce.builder.DealBuilder;
import com.minimerce.builder.OptionBuilder;
import com.minimerce.builder.PageableBuilder;
import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.DealRepository;
import com.minimerce.core.domain.deal.DealStatus;
import com.minimerce.core.domain.deal.option.Option;
import com.minimerce.core.domain.deal.option.OptionRepository;
import com.minimerce.core.object.deal.FindDealRequest;
import com.minimerce.core.object.deal.FindDealRequestBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Pageable;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by gemini on 15/06/2017.
 */
public class DealFinderTest {
    private DealFinder reader;
    private final DealRepository mockDealRepository = mock(DealRepository.class);
    private final OptionRepository mockOptionRepository = mock(OptionRepository.class);

    @Before
    public void setup() {
        when(mockDealRepository.findOne(1L)).thenReturn(buildTestOption().getDeal());
        when(mockOptionRepository.findOne(2L)).thenReturn(buildTestOption());

        reader = new DealFinder(mockDealRepository, mockOptionRepository);
    }

    private Option buildTestOption() {
        Deal deal = DealBuilder.aDeal().build();
        return OptionBuilder.anOption().withId(2L)
                                        .withDeal(deal)
                                        .build();
    }

    @Test
    public void testShouldBeFindSaleDeal() {
        Deal deal = reader.findBySaleDeal(1L);
        assertThat(deal.getId(), is(1L));
    }

    @Test
    public void testShouldBeFindDeals() {
        FindDealRequest request = FindDealRequestBuilder.aFindDealRequest().build();
        Pageable page = PageableBuilder.aPageable().build();

        reader.findDeals(request, page);
        verify(mockDealRepository).findAll(page);
    }

    @Test
    public void testShouldBeFindDealsByStatus() {
        FindDealRequest request = FindDealRequestBuilder.aFindDealRequest().withStatus(DealStatus.SALE).build();
        Pageable page = PageableBuilder.aPageable().build();

        reader.findDeals(request, page);
        verify(mockDealRepository).findByStatus(request.getStatus(), page);
    }
}