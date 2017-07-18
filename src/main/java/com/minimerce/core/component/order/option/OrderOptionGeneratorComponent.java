package com.minimerce.core.component.order.option;

import com.minimerce.core.domain.deal.option.Option;
import com.minimerce.core.domain.order.option.OrderOption;

/**
 * Created by gemini on 18/07/2017.
 */
public interface OrderOptionGeneratorComponent<OPTION extends Option> {
    OrderOption generate(Long clientId, OPTION option);
}
