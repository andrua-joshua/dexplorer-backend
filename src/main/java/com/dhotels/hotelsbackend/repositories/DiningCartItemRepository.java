package com.dhotels.hotelsbackend.repositories;

import com.dhotels.hotelsbackend.modules.DiningCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiningCartItemRepository extends JpaRepository<DiningCartItem, Integer> {
}
