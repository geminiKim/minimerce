package com.minimerce.domain.deal.option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gemini on 23/03/2017.
 */
@Repository
public interface DealOptionRepository extends JpaRepository<DealOption, Long> {
    List<DealOption> findByClientIdAndId(Long clientId, Long id);
}
