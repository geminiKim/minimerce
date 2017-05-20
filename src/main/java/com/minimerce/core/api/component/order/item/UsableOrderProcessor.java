package com.minimerce.core.api.component.order.item;

import com.minimerce.core.api.domain.order.item.usable.UsableOrderItem;
import com.minimerce.core.api.domain.order.item.usable.UsableOrderItemRepository;
import com.minimerce.core.api.support.exception.MinimerceException;
import com.minimerce.core.api.support.exception.NotFoundOrderException;
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
    public void consume(Long clientId, Long orderItemId) throws MinimerceException {
        UsableOrderItem usableOrder = usableOrderItemRepository.findByClientIdAndId(clientId, orderItemId);
        if(null == usableOrder) throw new NotFoundOrderException("Not Found Order");
        usableOrder.use();
    }

    public void restore(Long clientId, Long orderItemId) throws MinimerceException {
        UsableOrderItem usableOrder = usableOrderItemRepository.findByClientIdAndId(clientId, orderItemId);
        if(null == usableOrder) throw new NotFoundOrderException("Not Found Order");
        usableOrder.restore();
    }
}
