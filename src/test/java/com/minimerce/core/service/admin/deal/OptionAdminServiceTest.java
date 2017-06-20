package com.minimerce.core.service.admin.deal;

import com.minimerce.builder.DealBuilder;
import com.minimerce.builder.OptionBuilder;
import com.minimerce.builder.PageableBuilder;
import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.DealRepository;
import com.minimerce.core.domain.deal.option.Option;
import com.minimerce.core.domain.deal.option.OptionRepository;
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
 * Created by gemini on 23/04/2017.
 */
public class OptionAdminServiceTest {
    private OptionAdminService optionService;
    private final DealRepository mockDealRepository = mock(DealRepository.class);
    private final OptionRepository mockOptionRepository = mock(OptionRepository.class);

    @Before
    public void setUp() {
        optionService = new OptionAdminService(mockDealRepository, mockOptionRepository);
    }

    @Test
    public void testShouldBeFind() {
        optionService.find(1L, 1L);
        verify(mockOptionRepository).findByDealIdAndId(1L, 1L);
    }

    @Test
    public void testShouldBeFindWithPageable() {
        Pageable pageable = PageableBuilder.aPageable().build();
        optionService.find(1L, pageable);
        verify(mockOptionRepository).findByDealId(pageable, 1L);
    }

    @Test
    public void testShouldBeSaveOptions() {
        Deal deal = DealBuilder.aDeal().build();
        when(mockDealRepository.findOne(1L)).thenReturn(deal);

        List<Option> options = Lists.newArrayList(OptionBuilder.anOption().build());
        optionService.save(1L, options);
        verify(mockDealRepository).findOne(1L);
        verify(mockOptionRepository).save(options);
    }

    @Test
    public void testShouldBeSaveOption() {
        Deal deal = DealBuilder.aDeal().build();
        when(mockDealRepository.findOne(1L)).thenReturn(deal);

        Option option = OptionBuilder.anOption().build();
        optionService.save(1L, option);
        verify(mockDealRepository).findOne(1L);
        verify(mockOptionRepository).save(option);
    }

    @Test
    public void testShouldBeDeleteOption() {
        Option option = OptionBuilder.anOption().withDeleted(Yn.N).build();
        when(mockOptionRepository.findByDealIdAndId(1L,1L)).thenReturn(option);

        optionService.delete(1L, 1L);
        assertThat(option.getDeleted(), is(Yn.Y));
    }
}