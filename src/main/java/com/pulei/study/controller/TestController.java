package com.pulei.study.controller;

import com.pulei.study.entity.UserEntity;
import com.pulei.study.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class TestController {

    final IUserService iTestService;

    @Autowired
    public TestController(IUserService iTestService) {
        this.iTestService = iTestService;
    }

    @GetMapping("/find_user")
    private ResponseEntity<UserEntity> findById(@PathParam(value = "id") int id) {
        return ResponseEntity.ok(iTestService.findById(id));
    }

    @GetMapping("/find_all")
    private ResponseEntity<List<UserEntity>> sayHello () {
        return ResponseEntity.ok(iTestService.findAll());
    }

    @PostMapping("/add_user")
    private ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity) {
        UserEntity userEntity1 = iTestService.addUser(userEntity);
        return ResponseEntity.ok(userEntity1);
    }

    @DeleteMapping("/del_user")
    private void delUser(@PathParam(value = "id") int id) {
        iTestService.delUser(id);
    }

}
