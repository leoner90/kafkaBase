package com.example.test.tasks;

import com.example.test.services.TestUserService;
import org.platformlambda.core.annotations.PreLoad;
import org.platformlambda.core.models.TypedLambdaFunction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@PreLoad(route = "validate.user")
public class ValidateUserTask implements TypedLambdaFunction<Map<String, Object>, Map<String, Object>>
{
    @Autowired
    private TestUserService testUserService;

    @Override
    public Map<String, Object> handleEvent(Map<String, String> headers, Map<String, Object> input, int instance)
    {
        String name = (String) input.get("name");
        String validatedName = testUserService.validateName(name);
        return Map.of("name", validatedName);
    }
}