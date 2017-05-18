package com.minimerce.core.object.order;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by gemini on 04/04/2017.
 */
@Getter
@Setter
public class OrderRequestDetail {
    private Long dealId;
    private Long optionId;
    private int price;
    private int unitPrice;
    private int quantity;
}
