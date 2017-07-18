package com.minimerce.core.component.order.option;

import com.minimerce.core.component.order.option.delivery.DeliveryOrderOptionGenerator;
import com.minimerce.core.component.order.option.usable.UsableOrderOptionGenerator;
import com.minimerce.core.object.deal.type.ProductType;
import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.response.ErrorCode;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by gemini on 18/07/2017.
 */
@Component
public class OrderOptionGeneratorFactory {
    private final UsableOrderOptionGenerator usableOrderOptionGenerator;
    private final DeliveryOrderOptionGenerator deliveryOrderOptionGenerator;

    @Inject
    public OrderOptionGeneratorFactory(UsableOrderOptionGenerator usableOrderOptionGenerator, DeliveryOrderOptionGenerator deliveryOrderOptionGenerator) {
        this.usableOrderOptionGenerator = usableOrderOptionGenerator;
        this.deliveryOrderOptionGenerator = deliveryOrderOptionGenerator;
    }

    public OrderOptionGeneratorComponent getGenerator(ProductType type) {
        if(ProductType.USABLE == type) return usableOrderOptionGenerator;
        if(ProductType.DELIVERY == type) return deliveryOrderOptionGenerator;
        throw new MinimerceException(ErrorCode.NOT_SUPPORTED_PRODUCT_TYPE);
    }
}
