package com.minimerce.core.object.deal;

import com.minimerce.core.domain.deal.DealStatus;

/**
 * Created by gemini on 10/07/2017.
 */
public class FindDealRequest {
    private DealStatus status;

    public FindDealRequest(DealStatus status) {
        this.status = status;
    }

    public boolean hasStatus() {
        return status != null;
    }

    public DealStatus getStatus() {
        return status;
    }
}
