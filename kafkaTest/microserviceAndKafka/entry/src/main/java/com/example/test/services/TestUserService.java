package com.example.test.services;

import com.example.test.entities.TestUser;
import com.example.test.kafka.UserProducer;
import com.example.test.repository.TestUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestUserService
{

    private final TestUserRepository repository;
    private final UserProducer userProducer;

    public String validateName(String name) {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Name is required");
        }
        return name;
    }

    public TestUser createUser(String name)
    {
        TestUser user = new TestUser();
        user.setName(name);

        return repository.save(user);
    }

    public void sendUserNameToKafka(Long userId)
    {
        TestUser user = repository.findById(userId).orElseThrow();
        userProducer.sendUser(user.getName());
    }


}