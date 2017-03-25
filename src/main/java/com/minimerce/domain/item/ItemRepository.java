package com.minimerce.domain.item;

import com.minimerce.domain.order.item.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gemini on 25/03/2017.
 */
@Repository
public interface ItemRepository extends JpaRepository<OrderItem, Long> {
}
