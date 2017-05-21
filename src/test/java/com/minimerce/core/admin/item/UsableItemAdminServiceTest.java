package com.minimerce.core.admin.item;

import com.minimerce.builder.UsableItemBuilder;
import com.minimerce.core.api.domain.item.usable.UsableItem;
import com.minimerce.core.api.domain.item.usable.UsableItemRepository;
import com.minimerce.core.api.support.util.Yn;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by gemini on 26/04/2017.
 */
public class UsableItemAdminServiceTest {
    private UsableItemAdminService itemService;
    private UsableItemRepository mockItemRepository;

    @Before
    public void setUp() {
        mockItemRepository = mock(UsableItemRepository.class);
        itemService = new UsableItemAdminService(mockItemRepository);
    }

    @Test
    public void testShouldBeSaveNewItem() {
        UsableItem item = UsableItemBuilder.anUsableItem().withId(null).build();
        itemService.save(item);
        verify(mockItemRepository, times(1)).save(item);
    }

    @Test
    public void testShouldBeUpdateItem() {
        UsableItem item = UsableItemBuilder.anUsableItem().withId(1L).build();
        itemService.update(item);
        verify(mockItemRepository, times(1)).save(item);
    }

    @Test
    public void testShouldBeDeleteItem() {
        UsableItem item = UsableItemBuilder.anUsableItem().withDeleted(Yn.N).build();
        when(mockItemRepository.findOne(1L)).thenReturn(item);

        itemService.delete(1L);
        assertThat(item.getDeleted(), is(Yn.Y));
    }
}