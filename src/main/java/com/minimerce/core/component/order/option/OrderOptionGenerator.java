package com.minimerce.core.component.order.option;

import com.minimerce.core.domain.deal.option.Option;
import com.minimerce.core.domain.order.option.OrderOption;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by gemini on 14/06/2017.
 */
@Component
public class OrderOptionGenerator {
    private final OrderOptionGeneratorFactory generatorFactory;

    @Inject
    public OrderOptionGenerator(OrderOptionGeneratorFactory generatorFactory) {
        this.generatorFactory = generatorFactory;
    }

    public OrderOption generate(Long clientId, Option option) {
        return generatorFactory.getGenerator(option.getType()).generate(clientId, option);
    }
}
