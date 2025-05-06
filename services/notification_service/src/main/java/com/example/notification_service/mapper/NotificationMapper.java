package com.example.notification_service.mapper;

import com.example.notification_service.dto.NotificationDTO;
import com.example.notification_service.models.Notification;

public class NotificationMapper {

    public  static NotificationDTO mapToNotificationDTO(Notification noti) {
        NotificationDTO notiDTO = new NotificationDTO();
        notiDTO.setId(noti.getId());
        notiDTO.setUserId(noti.getUserId());
        notiDTO.setMessage(noti.getMessage());
        notiDTO.setCreatedAt(noti.getCreatedAt());
        return notiDTO;
    }

    public static Notification mapToNotificationEntity(NotificationDTO notiDTO) {
        Notification noti = new Notification();
        noti.setId(notiDTO.getId());
        noti.setUserId(notiDTO.getUserId());
        noti.setMessage(notiDTO.getMessage());
        noti.setCreatedAt(notiDTO.getCreatedAt());
        return noti;
    }
}
