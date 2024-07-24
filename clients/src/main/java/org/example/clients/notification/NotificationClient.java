package org.example.clients.notification;


import org.example.clients.notification.dto.NotificationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "notification-service")
public interface NotificationClient {

    @GetMapping("/api/notification")
    NotificationDto notification(@RequestParam String name);

}
