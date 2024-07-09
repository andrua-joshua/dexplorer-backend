package com.dhotels.hotelsbackend.repositories;

import com.dhotels.hotelsbackend.modules.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
