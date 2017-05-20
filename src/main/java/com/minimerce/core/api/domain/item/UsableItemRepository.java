package com.minimerce.core.api.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gemini on 25/03/2017.
 */
@Repository
public interface UsableItemRepository extends JpaRepository<UsableItem, Long> {
    List<UsableItem> findByIdIn(List<Long> ids);
}
