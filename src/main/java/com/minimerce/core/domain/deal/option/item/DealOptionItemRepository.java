package com.minimerce.core.domain.deal.option.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gemini on 23/03/2017.
 */
@Repository
public interface DealOptionItemRepository extends JpaRepository<DealOptionItem, Long> {
    Page<DealOptionItem> findByOptionId(Pageable pageable, Long optionId);
    DealOptionItem findByOptionIdAndId(Long optionId, Long itemId);
}
