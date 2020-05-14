package com.pulei.study.service;

import org.springframework.stereotype.Service;

@Service
public class TestService implements ITestService {
    @Override
    public String sayHello() {
        return "SayHello";
    }
}
