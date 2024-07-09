package com.dhotels.hotelsbackend.repositories;

import com.dhotels.hotelsbackend.modules.Business;
import com.dhotels.hotelsbackend.modules.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRespository extends JpaRepository<Room, Integer> {

    abstract public Optional<List<Room>> findAllByBusiness(Business business);
}
