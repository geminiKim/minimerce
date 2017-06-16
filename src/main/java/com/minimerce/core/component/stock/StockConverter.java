package com.minimerce.core.component.stock;

import com.google.common.collect.Lists;
import com.minimerce.core.domain.deal.option.Option;
import com.minimerce.core.domain.deal.option.OptionRepository;
import com.minimerce.core.support.exception.MinimerceException;
import com.minimerce.core.support.object.order.OrderRequestDetail;
import com.minimerce.core.support.object.response.ErrorCode;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 03/06/2017.
 */
@Component
public class StockConverter {
    private final OptionRepository optionRepository;

    @Inject
    public StockConverter(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    public List<Stock> convert(List<OrderRequestDetail> requests) {
        List<Stock> stocks = Lists.newArrayList();
        for(OrderRequestDetail request : requests) {
            Option option = optionRepository.findOne(request.getOptionId());
            if(null == option) throw new MinimerceException(ErrorCode.NOT_FOUND_OPTION);
            stocks.add(new Stock(option.getType(), option.getId(), request.getQuantity()));
        }
        return stocks;
    }
}
