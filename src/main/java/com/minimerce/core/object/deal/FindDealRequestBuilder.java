package com.minimerce.core.object.deal;

import com.minimerce.core.domain.deal.DealStatus;

/**
 * Created by gemini on 10/07/2017.
 */
public final class FindDealRequestBuilder {
    private DealStatus status;

    private FindDealRequestBuilder() {
    }

    public static FindDealRequestBuilder aFindDealRequest() {
        return new FindDealRequestBuilder();
    }

    public FindDealRequestBuilder withStatus(DealStatus status) {
        this.status = status;
        return this;
    }

    public FindDealRequest build() {
        return new FindDealRequest(status);
    }
}
