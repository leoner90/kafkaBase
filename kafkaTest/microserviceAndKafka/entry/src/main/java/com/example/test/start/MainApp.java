package com.example.test.start;

import org.platformlambda.core.annotations.MainApplication;
import org.platformlambda.core.models.EntryPoint;

@MainApplication
public class MainApp implements EntryPoint {

    @Override
    public void start(String[] args) {
        System.out.println("Mercury MainApp started");
    }
}