package org.example.notification.controller;

import lombok.RequiredArgsConstructor;
import org.example.clients.notification.dto.NotificationDto;
import org.example.notification.service.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class NotificationController {


    private final NotificationService notificationService;

    @GetMapping
    public NotificationDto notification(@RequestParam String name) {
        return notificationService.notifcate(name);
    }

}
