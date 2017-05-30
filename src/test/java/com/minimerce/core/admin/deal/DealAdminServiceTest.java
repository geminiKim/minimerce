package com.minimerce.core.admin.deal;

import com.minimerce.builder.DealBuilder;
import com.minimerce.builder.DealOptionItemBuilder;
import com.minimerce.builder.PageableBuilder;
import com.minimerce.core.api.domain.deal.Deal;
import com.minimerce.core.api.domain.deal.DealRepository;
import com.minimerce.core.api.domain.deal.option.item.DealOptionItem;
import com.minimerce.core.api.support.util.Yn;
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
    private DealRepository mockDealRepository;

    @Before
    public void setUp() {
        mockDealRepository = mock(DealRepository.class);
        dealAdminService = new DealAdminService(mockDealRepository);
    }

    @Test
    public void testShouldBeFind() {
        dealAdminService.find(1L);
        verify(mockDealRepository, times(1)).findOne(1L);
    }

    @Test
    public void testShouldBeFindWithPageable() {
        Pageable pageable = PageableBuilder.aPageable().build();
        dealAdminService.find(pageable);
        verify(mockDealRepository, times(1)).findAll(pageable);
    }

    @Test
    public void testShouldBeSaveDeals() {
        List<Deal> deals = Lists.newArrayList(DealBuilder.aDeal().build());
        dealAdminService.save(deals);
        verify(mockDealRepository, times(1)).save(deals);
    }

    @Test
    public void testShouldBeSaveDeal() {
        Deal deal = DealBuilder.aDeal().build();
        dealAdminService.save(deal);
        verify(mockDealRepository, times(1)).save(deal);
    }

    @Test
    public void testShouldBeDeleteDeal() {
        Deal deal = DealBuilder.aDeal().withDeleted(Yn.N).build();
        when(mockDealRepository.findOne(1L)).thenReturn(deal);

        dealAdminService.delete(1L);
        assertThat(deal.getDeleted(), is(Yn.Y));
    }
}