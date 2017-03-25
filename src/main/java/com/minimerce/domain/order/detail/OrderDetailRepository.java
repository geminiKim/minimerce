package com.minimerce.domain.order.detail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gemini on 25/03/2017.
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
