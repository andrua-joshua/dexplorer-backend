package com.dhotels.hotelsbackend.repositories;

import com.dhotels.hotelsbackend.modules.DiningItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiningItemRepository extends JpaRepository<DiningItem, Integer> {
}
