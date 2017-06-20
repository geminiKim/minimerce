package com.minimerce.core.service.admin.deal;

import com.minimerce.builder.DealBuilder;
import com.minimerce.builder.PageableBuilder;
import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.DealRepository;
import com.minimerce.core.support.util.Yn;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by gemini on 20/04/2017.
 */
public class DealAdminServiceTest {
    private DealAdminService dealAdminService;
    private final DealRepository mockDealRepository = mock(DealRepository.class);

    @Before
    public void setUp() {
        dealAdminService = new DealAdminService(mockDealRepository);
    }

    @Test
    public void testShouldBeFind() {
        dealAdminService.find(1L);
        verify(mockDealRepository).findOne(1L);
    }

    @Test
    public void testShouldBeFindWithPageable() {
        Pageable pageable = PageableBuilder.aPageable().build();
        dealAdminService.find(pageable);
        verify(mockDealRepository).findAll(pageable);
    }

    @Test
    public void testShouldBeSaveDeals() {
        List<Deal> deals = Lists.newArrayList(DealBuilder.aDeal().build());
        dealAdminService.save(deals);
        verify(mockDealRepository).save(deals);
    }

    @Test
    public void testShouldBeSaveDeal() {
        Deal deal = DealBuilder.aDeal().build();
        dealAdminService.save(deal);
        verify(mockDealRepository).save(deal);
    }

    @Test
    public void testShouldBeDeleteDeal() {
        Deal deal = DealBuilder.aDeal().withDeleted(Yn.N).build();
        when(mockDealRepository.findOne(1L)).thenReturn(deal);

        dealAdminService.delete(1L);
        assertThat(deal.getDeleted(), is(Yn.Y));
    }
}