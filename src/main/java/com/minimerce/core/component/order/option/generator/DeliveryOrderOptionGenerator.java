package com.minimerce.core.component.order.option.generator;

import com.minimerce.core.domain.deal.option.delivery.DeliveryOption;
import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.domain.order.option.delivery.DeliveryOrderOption;
import com.minimerce.core.domain.order.option.delivery.DeliveryStatus;
import com.minimerce.core.object.order.status.CancelStatus;
import com.minimerce.core.object.order.status.OrderStatus;
import org.springframework.stereotype.Component;

/**
 * Created by gemini on 18/07/2017.
 */
@Component
public class DeliveryOrderOptionGenerator implements OrderOptionGeneratorComponent<DeliveryOption> {
    @Override
    public OrderOption generate(Long clientId, DeliveryOption option) {
        DeliveryOrderOption orderOption = new DeliveryOrderOption();
        orderOption.setClientId(clientId);
        orderOption.setDeal(option.getDeal());
        orderOption.setTitle(option.getName());
        orderOption.setType(option.getType());
        orderOption.setStatus(OrderStatus.ORDERED);
        orderOption.setCancelStatus(CancelStatus.NOT_CANCEL);
        orderOption.setDeliveryStatus(DeliveryStatus.WAIT);
        orderOption.setSalePrice(option.getSalePrice());
        orderOption.setCostPrice(option.getCostPrice());
        orderOption.setOption(option);
        return orderOption;
    }
}
