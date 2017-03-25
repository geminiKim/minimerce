package com.minimerce.domain.deal.option.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gemini on 25/03/2017.
 */
@Repository
public interface DealOptionItemRepository extends JpaRepository<DealOptionItem, Long> {
}
