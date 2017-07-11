package com.minimerce.core.domain.deal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gemini on 23/03/2017.
 */
@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {
    Page<Deal> findByStatus(DealStatus status, Pageable page);
}
