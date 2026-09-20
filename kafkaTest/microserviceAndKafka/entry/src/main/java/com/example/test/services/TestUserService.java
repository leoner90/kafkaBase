package com.example.test.services;

import com.example.test.entities.TestUser;
import com.example.test.kafka.UserProducer;
import com.example.test.repository.TestUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // no need dependency inject this == this
public class TestUserService {

    private final TestUserRepository repository;
    private final UserProducer userProducer;


    public TestUser createUser(String name)
    {
        TestUser user = new TestUser();
        user.setName(name);

        TestUser savedUser = repository.save(user);

        userProducer.sendUserName(savedUser.getName());

        return savedUser;
    }
}