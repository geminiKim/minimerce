package com.minimerce.core.component.order.option.usable;

import com.minimerce.core.component.order.option.OrderOptionGeneratorComponent;
import com.minimerce.core.domain.deal.option.usable.UsableOption;
import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.domain.order.option.usable.UsableOrderOption;
import com.minimerce.core.object.order.status.CancelStatus;
import com.minimerce.core.object.order.status.OrderStatus;
import org.springframework.stereotype.Component;

/**
 * Created by gemini on 14/06/2017.
 */
@Component
public class UsableOrderOptionGenerator implements OrderOptionGeneratorComponent<UsableOption> {
    @Override
    public OrderOption generate(Long clientId, UsableOption option) {
        UsableOrderOption orderOption = new UsableOrderOption();
        orderOption.setClientId(clientId);
        orderOption.setDeal(option.getDeal());
        orderOption.setTitle(option.getName());
        orderOption.setType(option.getType());
        orderOption.setStatus(OrderStatus.ORDERED);
        orderOption.setCancelStatus(CancelStatus.NOT_CANCEL);
        orderOption.setSalePrice(option.getSalePrice());
        orderOption.setCostPrice(option.getCostPrice());
        orderOption.setOption(option);
        orderOption.setUsedCount(0);
        orderOption.setUsableCount(option.getUsableCount());
        orderOption.setAvailableStartAt(option.getAvailableStartAt());
        orderOption.setAvailableEndAt(option.getAvailableEndAt());
        return orderOption;
    }
}
