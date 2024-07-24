package org.example.notification.service;


import lombok.RequiredArgsConstructor;
import org.example.clients.notification.dto.NotificationDto;
import org.example.notification.entity.Notification;
import org.example.notification.mappers.NotificationMapper;
import org.example.notification.repo.NotificationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    public NotificationDto notifcate(String name) {

        Notification notification = Notification.builder()
                .customerName(name)
                .text("You are not fraudster !")
                .build();

        notificationRepository.save(notification);

        return notificationMapper.toDto(notification);
    }

    @RabbitListener(queues = "myQueue")
    public void receiveMessage(String msg) {
        System.out.println(msg);
    }

}
