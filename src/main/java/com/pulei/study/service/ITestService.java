package com.pulei.study.service;

import com.pulei.study.entity.UserEntity;

import java.util.List;

public interface ITestService {
    List<UserEntity> findAll();

    UserEntity addUser(UserEntity userEntity);
}
