package com.example.test.controller;

import com.example.test.entities.TestUser;
import com.example.test.services.TestUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestUserController
{
    private final TestUserService testUserService;

    @GetMapping("/user/create")
    public TestUser createUser(@RequestParam String name)
    {
        return  testUserService.createUser(name);
    }
}
