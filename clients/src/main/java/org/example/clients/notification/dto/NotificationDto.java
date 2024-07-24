package org.example.clients.notification.dto;


import java.time.LocalDateTime;


public record NotificationDto(
        String customerName,
        LocalDateTime createdAt,
        String text
) {
}