package com.example.test.kafka;

import com.example.test.entities.TestUser;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProducer
{
    private final KafkaTemplate<String, String > kafkaTemplate;

    public void sendUser(String  user)
    {
        System.out.println(user);
        kafkaTemplate.send("users", user);
    }



}