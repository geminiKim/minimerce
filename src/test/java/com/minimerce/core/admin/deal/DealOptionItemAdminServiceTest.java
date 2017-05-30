package com.minimerce.core.admin.deal;

import com.minimerce.builder.DealOptionBuilder;
import com.minimerce.builder.DealOptionItemBuilder;
import com.minimerce.builder.PageableBuilder;
import com.minimerce.core.api.domain.deal.option.DealOption;
import com.minimerce.core.api.domain.deal.option.DealOptionRepository;
import com.minimerce.core.api.domain.deal.option.item.DealOptionItem;
import com.minimerce.core.api.domain.deal.option.item.DealOptionItemRepository;
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
 * Created by gemini on 24/04/2017.
 */
public class DealOptionItemAdminServiceTest {
    private DealOptionItemAdminService optionItemService;
    private DealOptionRepository mockOptionRepository;
    private DealOptionItemRepository mockOptionItemRepository;

    @Before
    public void setUp() {
        mockOptionRepository = mock(DealOptionRepository.class);
        mockOptionItemRepository = mock(DealOptionItemRepository.class);
        optionItemService = new DealOptionItemAdminService(mockOptionRepository, mockOptionItemRepository);
    }

    @Test
    public void testShouldBeFind() {
        optionItemService.find(1L, 1L);
        verify(mockOptionItemRepository, times(1)).findByOptionIdAndId(1L, 1L);
    }

    @Test
    public void testShouldBeFindWithPageable() {
        Pageable pageable = PageableBuilder.aPageable().build();
        optionItemService.find(1L, pageable);
        verify(mockOptionItemRepository, times(1)).findByOptionId(pageable, 1L);
    }

    @Test
    public void testShouldBeSaveOptionItems() {
        DealOption option = DealOptionBuilder.aDealOption().build();
        when(mockOptionRepository.findOne(1L)).thenReturn(option);

        List<DealOptionItem> optionItems = Lists.newArrayList(DealOptionItemBuilder.aDealOptionItem().withId(null).build());
        optionItemService.save(1L, optionItems);
        verify(mockOptionRepository, times(1)).findOne(1L);
        verify(mockOptionItemRepository, times(1)).save(optionItems);
    }

    @Test
    public void testShouldBeSaveOptionItem() {
        DealOption option = DealOptionBuilder.aDealOption().build();
        when(mockOptionRepository.findOne(1L)).thenReturn(option);

        DealOptionItem optionItem = DealOptionItemBuilder.aDealOptionItem().withId(null).build();
        optionItemService.save(1L, optionItem);
        verify(mockOptionRepository, times(1)).findOne(1L);
        verify(mockOptionItemRepository, times(1)).save(optionItem);
    }

    @Test
    public void testShouldBeDeleteOptionItem() {
        DealOptionItem optionItem = DealOptionItemBuilder.aDealOptionItem().withDeleted(Yn.N).build();
        when(mockOptionItemRepository.findByOptionIdAndId(1L,1L)).thenReturn(optionItem);

        optionItemService.delete(1L, 1L);
        assertThat(optionItem.getDeleted(), is(Yn.Y));
    }
}