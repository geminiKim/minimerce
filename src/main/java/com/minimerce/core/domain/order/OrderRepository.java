package com.minimerce.core.domain.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gemini on 25/03/2017.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByClientIdAndId(Long clientId, Long id);
    Order findByClientIdAndClientOrderId(Long clientId, Long clientOrderId);
    Page<Order> findByClientIdAndCustomerId(Long clientId, Long customerId, Pageable page);
}
