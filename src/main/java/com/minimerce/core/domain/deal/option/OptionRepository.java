package com.minimerce.core.domain.deal.option;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gemini on 23/03/2017.
 */
@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    Page<Option> findByDealId(Pageable pageable, Long dealId);
    Option findByDealIdAndId(Long dealId, Long optionId);
}
