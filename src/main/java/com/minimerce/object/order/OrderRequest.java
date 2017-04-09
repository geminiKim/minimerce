package com.minimerce.object.order;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by gemini on 03/04/2017.
 */
@Getter
@Setter
public class OrderRequest {
    private Long clientOrderId;
    private Long customerId;
    private int price;
    private LocalDateTime orderedAt;
    private List<OrderRequestDetail> details;

    public void addDetail(OrderRequestDetail detail) {
        this.details.add(detail);
    }
}
