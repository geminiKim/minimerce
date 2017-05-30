package com.minimerce.core.admin.order;

import com.minimerce.core.api.component.order.item.UsableOrderProcessor;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by gemini on 30/05/2017.
 */
@Service
public class UsableOrderItemAdminService {
    private final UsableOrderProcessor processor;

    @Inject
    public UsableOrderItemAdminService(UsableOrderProcessor processor) {
        this.processor = processor;
    }

    public void consume(Long clientId, Long orderItemId) {
        processor.consume(clientId, orderItemId);
    }

    public void restore(Long clientId, Long orderItemId) {
        processor.restore(clientId, orderItemId);
    }
}
