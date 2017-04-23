package com.minimerce.service.deal;

import com.minimerce.builder.DealOptionItemBuilder;
import com.minimerce.domain.deal.option.item.DealOptionItem;
import com.minimerce.domain.deal.option.item.DealOptionItemRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by gemini on 24/04/2017.
 */
public class DealOptionItemServiceTest {
    private DealOptionItemService optionItemService;
    private DealOptionItemRepository mockOptionItemRepository;

    @Before
    public void setUp() {
        mockOptionItemRepository = mock(DealOptionItemRepository.class);
        optionItemService = new DealOptionItemService(mockOptionItemRepository);
    }

    @Test
    public void testShouldBeSaveNewOptionItem() {
        DealOptionItem optionItem = DealOptionItemBuilder.aDealOptionItem().withId(null).build();
        optionItemService.newDeal(1L, optionItem);
        verify(mockOptionItemRepository, times(1)).save(optionItem);
    }

    @Test
    public void testShouldBeUpdateOptionItem() {
        DealOptionItem optionItem = DealOptionItemBuilder.aDealOptionItem().withId(1L).build();
        optionItemService.updateDeal(1L, optionItem);
        verify(mockOptionItemRepository, times(1)).save(optionItem);
    }
}