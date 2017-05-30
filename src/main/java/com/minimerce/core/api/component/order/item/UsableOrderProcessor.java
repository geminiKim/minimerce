package com.minimerce.core.api.component.order.item;

import com.minimerce.core.api.domain.order.item.usable.UsableOrderItem;
import com.minimerce.core.api.domain.order.item.usable.UsableOrderItemRepository;
import com.minimerce.core.api.support.exception.MinimerceException;
import com.minimerce.core.api.support.object.response.ErrorCode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by gemini on 29/04/2017.
 */
@Component
public class UsableOrderProcessor {
    private final UsableOrderItemRepository usableOrderItemRepository;

    @Inject
    public UsableOrderProcessor(UsableOrderItemRepository usableOrderItemRepository) {
        this.usableOrderItemRepository = usableOrderItemRepository;
    }

    @Transactional
    public void consume(Long orderItemId) {
        UsableOrderItem usableOrder = usableOrderItemRepository.findOne(orderItemId);
        if(null == usableOrder) throw new MinimerceException(ErrorCode.NOT_FOUND_ORDER);
        usableOrder.use();
    }

    public void restore(Long orderItemId) {
        UsableOrderItem usableOrder = usableOrderItemRepository.findOne(orderItemId);
        if(null == usableOrder) throw new MinimerceException(ErrorCode.NOT_FOUND_ORDER);
        usableOrder.restore();
    }
}
