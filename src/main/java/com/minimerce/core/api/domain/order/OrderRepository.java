package com.minimerce.core.api.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gemini on 25/03/2017.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByClientIdAndId(Long clientId, Long id);
    Order findByClientIdAndClientOrderId(Long clientId, Long clientOrderId);
    List<Order> findByClientIdAndCustomerId(Long clientId, Long customerId);
}
