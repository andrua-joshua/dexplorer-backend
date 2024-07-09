package com.dhotels.hotelsbackend.repositories;

import com.dhotels.hotelsbackend.modules.FavouriteDiningItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteDiningItemRepository extends JpaRepository<FavouriteDiningItem, Integer> {
}
