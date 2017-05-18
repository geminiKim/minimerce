package com.minimerce.core.domain.order.option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gemini on 25/03/2017.
 */
@Repository
public interface OrderOptionRepository extends JpaRepository<OrderOption, Long> {
}
