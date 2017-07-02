package com.minimerce.core.domain.deal.option.usable;

import com.minimerce.core.component.stock.Stock;
import com.minimerce.core.support.exception.MinimerceSpecificException;
import com.minimerce.core.support.response.ErrorCode;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gemini on 25/03/2017.
 */
@Repository
public class UsableOptionDslRepository extends QueryDslRepositorySupport {
    private final QUsableOption usableOption;

    public UsableOptionDslRepository() {
        super(UsableOption.class);
        this.usableOption = QUsableOption.usableOption;
    }

    @Transactional
    public void decrease(Stock stock) {
        long execute = update(usableOption)
                .set(usableOption.stock, usableOption.stock.subtract(stock.getQuantity()))
                .where(usableOption.stock.goe(stock.getQuantity()))
                .execute();
        if(execute == 0) throw new MinimerceSpecificException(ErrorCode.SHORTAGE_STOCK, stock);
    }
}
