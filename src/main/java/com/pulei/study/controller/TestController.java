package com.pulei.study.controller;

import com.pulei.study.entity.UserEntity;
import com.pulei.study.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    final ITestService iTestService;

    @Autowired
    public TestController(ITestService iTestService) {
        this.iTestService = iTestService;
    }

    @GetMapping("/find_all")
    private  ResponseEntity<List<UserEntity>> sayHello () {
        return ResponseEntity.ok(iTestService.findAll());
    }

}
