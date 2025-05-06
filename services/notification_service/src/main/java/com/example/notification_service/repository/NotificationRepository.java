package com.example.notification_service.repository;

import com.example.notification_service.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    Optional<Notification> findByUserId(Integer userId);
}
