package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({
        "org.platformlambda",
        "com.example.test"
})
@SpringBootApplication
public class SpringBootApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootApp.class, args);
    }
}