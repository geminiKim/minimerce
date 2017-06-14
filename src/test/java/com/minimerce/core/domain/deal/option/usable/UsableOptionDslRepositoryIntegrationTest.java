package com.minimerce.core.domain.deal.option.usable;

import com.minimerce.IntegrationTest;
import com.minimerce.builder.DealBuilder;
import com.minimerce.builder.StockBuilder;
import com.minimerce.builder.UsableOptionBuilder;
import com.minimerce.core.component.item.Stock;
import com.minimerce.core.support.exception.MinimerceSpecificException;
import com.minimerce.core.support.object.response.ErrorCode;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by gemini on 11/06/2017.
 */
public class UsableOptionDslRepositoryIntegrationTest extends IntegrationTest {
    @Inject private UsableOptionDslRepository usableOptionDslRepository;
    @Inject private UsableOptionRepository usableOptionRepository;
    private final StockBuilder stockBuilder = StockBuilder.aStock();
    private Long testOptionId;

    @Before
    public void setup() {
        testOptionId = usableOptionRepository.save(buildTestOption(1)).getId();
    }


    private UsableOption buildTestOption(int stockCount) {
        DealBuilder dealBuilder = DealBuilder.aDeal();
        UsableOptionBuilder optionBuilder = UsableOptionBuilder.anUsableOption();
        return optionBuilder.withId(null)
                            .withStock(stockCount)
                            .withDeal(dealBuilder.build())
                            .build();
    }

    @Test
    public void testShouldBeSuccessDecreaseStock() {
        Stock stock = stockBuilder.withOptionId(testOptionId).withQuantity(1).build();
        usableOptionDslRepository.decreaseStock(stock);

        UsableOption option = usableOptionRepository.findOne(testOptionId);
        assertThat(option.getStock(), is(0));
    }

    @Test
    public void testShouldBeThrowsExceptionBySHORTAGE_STOCK_ERROR() {
        try {
            Stock stock = stockBuilder.withOptionId(testOptionId).withQuantity(2).build();
            usableOptionDslRepository.decreaseStock(stock);
            fail();
        } catch (MinimerceSpecificException e) {
            assertThat(e.getError(), is(ErrorCode.SHORTAGE_STOCK));
        }
    }
}