package com.dhotels.hotelsbackend.repositories;

import com.dhotels.hotelsbackend.modules.DiningOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiningOrderRepository extends JpaRepository<DiningOrder, Integer> {
}
