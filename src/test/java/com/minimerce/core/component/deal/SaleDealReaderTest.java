package com.minimerce.core.component.deal;

import com.minimerce.builder.DealBuilder;
import com.minimerce.builder.OptionBuilder;
import com.minimerce.core.domain.deal.Deal;
import com.minimerce.core.domain.deal.DealRepository;
import com.minimerce.core.domain.deal.option.Option;
import com.minimerce.core.domain.deal.option.OptionRepository;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by gemini on 15/06/2017.
 */
public class SaleDealReaderTest {
    private SaleDealReader reader;
    private final DealRepository mockDealRepository = mock(DealRepository.class);
    private final OptionRepository mockOptionRepository = mock(OptionRepository.class);

    @Before
    public void setup() {
        when(mockDealRepository.findOne(1L)).thenReturn(buildTestOption().getDeal());
        when(mockOptionRepository.findOne(2L)).thenReturn(buildTestOption());

        reader = new SaleDealReader(mockDealRepository, mockOptionRepository);
    }

    private Option buildTestOption() {
        Deal deal = DealBuilder.aDeal().build();
        return OptionBuilder.anOption().withId(2L)
                                        .withDeal(deal)
                                        .build();
    }

    @Test
    public void testShouldBeReadSaleDeal() {
        Deal deal = reader.findBySaleDeal(1L);
        assertThat(deal.getId(), is(1L));
    }

    @Test
    public void testShouldBeReadSaleOption() {
        Option option = reader.findBySaleOption(2L);
        assertThat(option.getId(), is(2L));
    }
}