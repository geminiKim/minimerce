package com.minimerce.service.deal;

import com.minimerce.builder.DealOptionBuilder;
import com.minimerce.domain.deal.option.DealOption;
import com.minimerce.domain.deal.option.DealOptionRepository;
import com.minimerce.support.util.Yn;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by gemini on 23/04/2017.
 */
public class DealOptionServiceTest {
    private DealOptionService optionService;
    private DealOptionRepository mockOptionRepository;

    @Before
    public void setUp() {
        mockOptionRepository = mock(DealOptionRepository.class);
        optionService = new DealOptionService(mockOptionRepository);
    }

    @Test
    public void testShouldBeSaveNewOption() {
        DealOption option = DealOptionBuilder.aDealOption().withId(null).build();
        optionService.save(option);
        verify(mockOptionRepository, times(1)).save(option);
    }

    @Test
    public void testShouldBeUpdateOption() {
        DealOption option = DealOptionBuilder.aDealOption().withId(1L).build();
        optionService.update(option);
        verify(mockOptionRepository, times(1)).save(option);
    }

    @Test
    public void testShouldBeDeleteOption() {
        DealOption option = DealOptionBuilder.aDealOption().withDeleted(Yn.N).build();
        when(mockOptionRepository.findOne(1L)).thenReturn(option);

        optionService.delete(1L);
        assertThat(option.getDeleted(), is(Yn.Y));
    }
}