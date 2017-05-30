package com.minimerce.core.api.domain.deal.option;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gemini on 23/03/2017.
 */
@Repository
public interface DealOptionRepository extends JpaRepository<DealOption, Long> {
    Page<DealOption> findByDealId(Pageable pageable, Long dealId);
    DealOption findByDealIdAndId(Long dealId, Long optionId);
}
