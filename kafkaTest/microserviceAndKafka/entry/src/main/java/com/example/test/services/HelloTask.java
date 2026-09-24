package com.example.test.services;

import org.platformlambda.core.annotations.PreLoad;
import org.platformlambda.core.models.TypedLambdaFunction;

import java.util.HashMap;
import java.util.Map;

@PreLoad(route = "test.hello")
public class HelloTask implements TypedLambdaFunction<Map<String, Object>, Map<String, Object>> {

    @Override
    public Map<String, Object> handleEvent(
            Map<String, String> headers,
            Map<String, Object> input,
            int instance) {

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Mercury works!");

        return response;
    }
}