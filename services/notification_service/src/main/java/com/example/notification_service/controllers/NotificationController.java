package com.example.notification_service.controllers;

import com.example.notification_service.dto.NotificationDTO;
import com.example.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<NotificationDTO>> getResultsByUserId(@PathVariable("userId") Integer userId) {
        List<NotificationDTO> resultDTOS = new ArrayList<>();
        resultDTOS = notificationService.getNotificationsByUserId(userId);
        return new ResponseEntity<>(resultDTOS, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<NotificationDTO> saveResult(@RequestBody NotificationDTO dto) {
        return ResponseEntity.ok(notificationService.saveNotification(dto));
    }

    @PatchMapping("/{notificationId}")
    public ResponseEntity<NotificationDTO> updateResult(@PathVariable("notificationId") Integer notiId, @RequestBody NotificationDTO dto) {
        dto.setId(notiId);
        NotificationDTO savedDTO = notificationService.updateNotification(dto);
        return new ResponseEntity<>(savedDTO, HttpStatus.OK);
    }
}
