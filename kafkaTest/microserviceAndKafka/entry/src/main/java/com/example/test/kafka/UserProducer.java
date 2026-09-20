package com.example.test.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendUserName(String name) {
        kafkaTemplate.send("user-created", name);
    }

    public void sendUserName(String userId, String name) {

        kafkaTemplate
                .send("user-created", userId, name)
                .addCallback(
                        result -> {
                            System.out.println(
                                    "Message sent to partition " +
                                            result.getRecordMetadata().partition() +
                                            " with offset " +
                                            result.getRecordMetadata().offset()
                            );
                        },
                        ex -> {
                            System.err.println(
                                    "Failed to send message: " +
                                            ex.getMessage()
                            );
                        }
                );
    }
}


