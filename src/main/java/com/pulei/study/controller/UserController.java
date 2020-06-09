package com.pulei.study.controller;

import com.pulei.study.entity.UserEntity;
import com.pulei.study.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    final IUserService iTestService;

    @Autowired
    public UserController(IUserService iTestService) {
        this.iTestService = iTestService;
    }

    @GetMapping("/find_user")
    private ResponseEntity<UserEntity> findByIdUser(@PathParam(value = "id") int id) {
        return ResponseEntity.ok(iTestService.findById(id));
    }

    @GetMapping("/find_all")
    private ResponseEntity<List<UserEntity>> findAllUser () {
        return ResponseEntity.ok(iTestService.findAll());
    }

    @PostMapping("/add_user")
    private ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity) {
        UserEntity userEntity1 = iTestService.addUser(userEntity);
        return ResponseEntity.ok(userEntity1);
    }

    @DeleteMapping("/del_user")
    private ResponseEntity<Void> delUser(@PathParam(value = "id") int id) {
        iTestService.delUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/login_user")
    private ResponseEntity<HashMap<String, Object>> login(@PathParam(value = "id") int id) {
        HashMap<String, Object> hashMap = new HashMap<>();

        UserEntity userEntity = iTestService.findById(id);
        if (StringUtils.isEmpty(userEntity)) {
            hashMap.put("message", "登陆失败");
            hashMap.put("code", 201);
            hashMap.put("data", userEntity);
        } else {
            hashMap.put("message", "登录成功");
            hashMap.put("code", 200);
            hashMap.put("data", userEntity);
        }
        return ResponseEntity.ok(hashMap);
    }

    @GetMapping("/login_user")
    private ResponseEntity<HashMap<String, Object>> login() {
        UserEntity userEntity = iTestService.findById(1);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("message", "登录成功");
        hashMap.put("code", 201);
        hashMap.put("data", userEntity);
        return ResponseEntity.ok(hashMap);
    }

}
