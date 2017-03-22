package com.minimerce.domain.deal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gemini on 23/03/2017.
 */
@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {
}
