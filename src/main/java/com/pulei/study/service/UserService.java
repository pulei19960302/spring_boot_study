package com.pulei.study.service;

import com.pulei.study.dto.IUserRepository;
import com.pulei.study.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    final
    IUserRepository iUserRepository;

    @Autowired
    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public List<UserEntity> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public UserEntity addUser(UserEntity userEntity) {
        iUserRepository.save(userEntity);
        return userEntity;
    }

    @Override
    public void delUser(Integer id) {
        UserEntity userEntity = iUserRepository.findById(id).orElse(null);
        assert userEntity != null;
        iUserRepository.delete(userEntity);
    }

    @Override
    public UserEntity findById(Integer id) {
        return iUserRepository.findById(id).orElse(null);
    }


}
