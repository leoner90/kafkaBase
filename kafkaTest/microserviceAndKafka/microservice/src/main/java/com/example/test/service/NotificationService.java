package com.example.test.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void notifyUser(String name) {
        System.out.println("Received user from Kafka: " + name);
    }
}