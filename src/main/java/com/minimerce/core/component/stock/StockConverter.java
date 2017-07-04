package com.minimerce.core.component.stock;

import com.google.common.collect.Lists;
import com.minimerce.core.domain.order.option.OrderOption;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by gemini on 03/06/2017.
 */
@Component
public class StockConverter {
    public List<Stock> convert(List<OrderOption> options) {
        List<Stock> stocks = Lists.newArrayList();
        options.stream()
                .collect(groupingBy(e -> e.getId()))
                .forEach((k, v) -> stocks.add(new Stock(v.get(0).getType(), k, v.size())));
        return stocks;
    }
}
