package com.pulei.study.controller;

import com.pulei.study.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    final ITestService iTestService;

    @Autowired
    public TestController(ITestService iTestService) {
        this.iTestService = iTestService;
    }

    @GetMapping("/say_hello")
    private String sayHello () {
        return iTestService.sayHello();
    }

}
