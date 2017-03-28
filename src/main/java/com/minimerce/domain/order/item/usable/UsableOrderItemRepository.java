package com.minimerce.domain.order.item.usable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gemini on 25/03/2017.
 */
@Repository
public interface UsableOrderItemRepository extends JpaRepository<UsableOrderItem, Long> {
}
