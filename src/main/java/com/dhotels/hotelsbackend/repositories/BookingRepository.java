package com.dhotels.hotelsbackend.repositories;

import com.dhotels.hotelsbackend.modules.Booking;
import com.dhotels.hotelsbackend.modules.Room;
import com.dhotels.hotelsbackend.modules.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    abstract public Optional<List<Booking>> findByClient(User client);
    abstract public Optional<List<Booking>> findByCreatedAt(Date createdAt);
    abstract public Optional<List<Booking>> findByRoom(Room room);
    @Query("SELECT i FROM bookings WHERE i.createdAt BETWEEN :startDate AND :endDate")
    abstract public Optional<List<Booking>> findByCreatedBetween(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate);
}
