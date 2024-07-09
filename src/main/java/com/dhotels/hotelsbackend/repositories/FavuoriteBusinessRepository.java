package com.dhotels.hotelsbackend.repositories;

import com.dhotels.hotelsbackend.modules.FavouriteBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FavuoriteBusinessRepository extends JpaRepository<FavouriteBusiness, Integer> {
}
