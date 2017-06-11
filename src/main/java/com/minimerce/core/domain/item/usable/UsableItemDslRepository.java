package com.minimerce.core.domain.item.usable;

import com.minimerce.core.component.item.Stock;
import com.minimerce.core.support.exception.MinimerceSpecificException;
import com.minimerce.core.support.object.response.ErrorCode;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gemini on 25/03/2017.
 */
@Repository
public class UsableItemDslRepository extends QueryDslRepositorySupport {
    public UsableItemDslRepository() {
        super(UsableItem.class);
    }

    @Transactional
    public void decreaseStock(Stock stock) {
        long execute = update(QUsableItem.usableItem)
                .set(QUsableItem.usableItem.stock, QUsableItem.usableItem.stock.subtract(stock.getQuantity()))
                .where(QUsableItem.usableItem.stock.goe(stock.getQuantity()))
                .execute();
        if(execute == 0) throw new MinimerceSpecificException(ErrorCode.SHORTAGE_STOCK, stock);
    }
}
