package com.minimerce.core.domain.item.usable;

import com.minimerce.IntegrationTest;
import com.minimerce.builder.StockBuilder;
import com.minimerce.builder.UsableItemBuilder;
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
public class UsableItemDslRepositoryIntegrationTest extends IntegrationTest {
    @Inject private UsableItemDslRepository usableItemDslRepository;
    @Inject private UsableItemRepository usableItemRepository;
    private final StockBuilder stockBuilder = StockBuilder.aStock();

    private UsableItem testItem;

    @Before
    public void setup() {
        testItem = UsableItemBuilder.anUsableItem().withId(null).withStock(1).build();
        usableItemRepository.save(testItem);
    }

    @Test
    public void testShouldBeSuccessDecreaseStock() {
        Stock stock = stockBuilder.withItemId(testItem.getId()).withQuantity(1).build();
        usableItemDslRepository.decreaseStock(stock);

        UsableItem resultItem = usableItemRepository.findOne(testItem.getId());
        assertThat(resultItem.getStock(), is(0));
    }

    @Test
    public void testShouldBeThrowsExceptionBySHORTAGE_STOCK_ERROR() {
        try {
            Stock stock = stockBuilder.withItemId(testItem.getId()).withQuantity(2).build();
            usableItemDslRepository.decreaseStock(stock);
            fail();
        } catch (MinimerceSpecificException e) {
            assertThat(e.getError(), is(ErrorCode.SHORTAGE_STOCK));
        }
    }

}