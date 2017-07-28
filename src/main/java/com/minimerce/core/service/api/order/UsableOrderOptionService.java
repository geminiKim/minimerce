package com.minimerce.core.service.api.order;

import com.minimerce.core.domain.order.option.usable.UsableOrderOption;
import com.minimerce.core.domain.order.option.usable.UsableOrderOptionRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UsableOrderOptionService {
    private final UsableOrderOptionRepository usableOrderOptionRepository;

    @Inject
    public UsableOrderOptionService(UsableOrderOptionRepository usableOrderOptionRepository) {
        this.usableOrderOptionRepository = usableOrderOptionRepository;
    }

    public void use(long usableOrderId) {
        UsableOrderOption usableOrder = usableOrderOptionRepository.findOne(usableOrderId);
        usableOrder.use();
    }
}
