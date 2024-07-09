package com.dhotels.hotelsbackend.repositories;

import com.dhotels.hotelsbackend.modules.DiningCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiningCartRepository extends JpaRepository<DiningCart, Integer> {
}
