package com.minimerce.builder;

import com.minimerce.core.component.stock.Stock;
import com.minimerce.core.object.type.ProductType;

/**
 * Created by gemini on 07/06/2017.
 */
public final class StockBuilder {
    private ProductType type = ProductType.USABLE;
    private long optionId = 1L;
    private int quantity = 1;

    private StockBuilder() {
    }

    public static StockBuilder aStock() {
        return new StockBuilder();
    }

    public StockBuilder withType(ProductType type) {
        this.type = type;
        return this;
    }

    public StockBuilder withOptionId(long optionId) {
        this.optionId = optionId;
        return this;
    }

    public StockBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public Stock build() {
        Stock stock = new Stock(type, optionId, quantity);
        return stock;
    }
}
