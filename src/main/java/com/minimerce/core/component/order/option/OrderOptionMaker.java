package com.minimerce.core.component.order.option;

import com.google.common.collect.Lists;
import com.minimerce.core.component.deal.DealFinder;
import com.minimerce.core.domain.deal.option.Option;
import com.minimerce.core.domain.order.option.OrderOption;
import com.minimerce.core.object.order.OrderRequestDetail;
import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.response.ErrorCode;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 01/04/2017.
 */
@Component
public class OrderOptionMaker {
    private final DealFinder dealFinder;
    private final OrderOptionGenerator orderOptionGenerator;

    @Inject
    public OrderOptionMaker(DealFinder dealFinder, OrderOptionGenerator orderOptionGenerator) {
        this.dealFinder = dealFinder;
        this.orderOptionGenerator = orderOptionGenerator;
    }

    public List<OrderOption> make(Long clientId, List<OrderRequestDetail> requestDetails) {
        List<OrderOption> orders = Lists.newArrayList();
        for(OrderRequestDetail each : requestDetails) {
            Option option = dealFinder.findBySaleOption(each.getOptionId());

            OrderOption orderOption = orderOptionGenerator.generate(clientId, option);
            if(each.getUnitPrice() != orderOption.getSalePrice()) throw new MinimerceException(ErrorCode.NOT_EQUAL_UNIT_PRICE);
            if(each.getPrice() != orderOption.getSalePrice() * each.getQuantity()) throw new MinimerceException(ErrorCode.NOT_EQUAL_UNIT_PRICE);

            for (int i = 0; i < each.getQuantity(); i++) {
                orders.add(ObjectUtils.clone(orderOption));
            }
        }
        return orders;
    }
}
