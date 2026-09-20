package com.example.test.kafka;

import com.example.test.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConsumer {

    private final NotificationService notificationService;

    @KafkaListener(
            topics = "user-created",
            groupId = "notification-service"
    )
    public void consume(String name) {
        notificationService.notifyUser(name);
    }
}