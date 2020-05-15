package com.pulei.study.service;

import com.pulei.study.entity.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserEntity> findAll();

    UserEntity addUser(UserEntity userEntity);

    void delUser(Integer id);

    UserEntity findById (Integer id);
}
