package com.example.test.tasks;

import com.example.test.entities.TestUser;
import com.example.test.services.TestUserService;
import org.platformlambda.core.annotations.PreLoad;
import org.platformlambda.core.models.TypedLambdaFunction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@PreLoad(route = "create.user")
public class CreateUserTask implements TypedLambdaFunction<Map<String, Object>, Map<String, Object>>
{
    @Autowired
    private TestUserService userService;

    @Override
    public Map<String, Object> handleEvent(Map<String, String> headers, Map<String, Object> input, int instance)
    {
        String name = (String) input.get("name");
        TestUser user = userService.createUser(name);

        return Map.of("id", user.getId(), "name", user.getName());
    }
}