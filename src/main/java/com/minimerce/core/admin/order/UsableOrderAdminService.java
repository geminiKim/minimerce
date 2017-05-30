package com.minimerce.core.admin.order;

import com.minimerce.core.api.component.order.item.UsableOrderProcessor;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by gemini on 30/05/2017.
 */
@Service
public class UsableOrderAdminService {
    private final UsableOrderProcessor processor;

    @Inject
    public UsableOrderAdminService(UsableOrderProcessor processor) {
        this.processor = processor;
    }

    public void consume(Long orderItemId) {
        processor.consume(orderItemId);
    }

    public void restore(Long orderItemId) {
        processor.restore(orderItemId);
    }
}
