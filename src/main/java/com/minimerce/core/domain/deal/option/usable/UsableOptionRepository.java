package com.minimerce.core.domain.deal.option.usable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gemini on 13/06/2017.
 */
@Repository
public interface UsableOptionRepository extends JpaRepository<UsableOption, Long> {
}
