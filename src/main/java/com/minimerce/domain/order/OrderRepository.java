package com.minimerce.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gemini on 25/03/2017.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
