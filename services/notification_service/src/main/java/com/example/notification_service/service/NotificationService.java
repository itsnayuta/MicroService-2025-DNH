package com.example.notification_service.service;

import com.example.notification_service.dto.NotificationDTO;
import com.example.notification_service.mapper.NotificationMapper;
import com.example.notification_service.models.Notification;
import com.example.notification_service.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;
    public List<NotificationDTO> getNotificationsByUserId(Integer userId) {
        return notificationRepository.findByUserId(userId)
                .stream()
                .map(NotificationMapper::mapToNotificationDTO)
                .collect(Collectors.toList());
    }

    public NotificationDTO saveNotification(NotificationDTO notiDTO) {
        Notification toSave = NotificationMapper.mapToNotificationEntity(notiDTO);
        Notification saved = notificationRepository.save(toSave);
        return NotificationMapper.mapToNotificationDTO(saved);

    }

    public NotificationDTO updateNotification(NotificationDTO NotificationDTO) {
        Optional<Notification> NotificationOptional = notificationRepository.findById(NotificationDTO.getId());

        Notification Notification = NotificationOptional.get();
        updateNotificationFromDTO(Notification, NotificationDTO);
        notificationRepository.save(Notification);
        return NotificationMapper.mapToNotificationDTO(Notification);
    }

    private void updateNotificationFromDTO(Notification notification, NotificationDTO notificationDTO) {
        if (notificationDTO.getId()!=null) {
            notification.setId(notificationDTO.getId());
        }
        if (notificationDTO.getUserId()!=null) {
            notification.setUserId(notificationDTO.getUserId());
        }
        if (notificationDTO.getMessage()!=null) {
            notification.setMessage(notificationDTO.getMessage());
        }
        if (notificationDTO.getCreatedAt()!=null) {
            notification.setCreatedAt(notificationDTO.getCreatedAt());
        }
    }


}
