package com.minimerce.core.domain.order.option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gemini on 25/03/2017.
 */
@Repository
public interface OrderOptionRepository extends JpaRepository<OrderOption, Long> {
    List<OrderOption> findByClientIdAndOrderId(Long clientId, Long orderId);
    List<OrderOption> findByClientIdAndOrderIdAndIdIn(Long clientId, Long orderId, List<Long> ids);
}
