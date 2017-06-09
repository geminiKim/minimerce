package com.minimerce.core.component.item;

import com.google.common.collect.Lists;
import com.minimerce.core.component.deal.SaleDealReader;
import com.minimerce.core.domain.deal.option.DealOption;
import com.minimerce.core.domain.item.Item;
import com.minimerce.core.support.object.order.OrderRequestDetail;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gemini on 03/06/2017.
 */
public class StockConverter {
    private final SaleDealReader saleDealReader;

    @Inject
    public StockConverter(SaleDealReader saleDealReader) {
        this.saleDealReader = saleDealReader;
    }

    public List<Stock> convert(List<OrderRequestDetail> requests) {
        List<Stock> stocks = Lists.newArrayList();
        for(OrderRequestDetail request : requests) {
            DealOption option = saleDealReader.findBySaleDealOption(request.getOptionId());
            for (Item item : option.getOptionItems()) {
                stocks.add(new Stock(item.getType(), option.getId(), item.getId(), request.getQuantity()));
            }
        }
        return stocks;
    }
}
