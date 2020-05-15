package com.pulei.study.service;

import com.pulei.study.dto.IUserRepository;
import com.pulei.study.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService implements ITestService {

    final
    IUserRepository iUserRepository;

    @Autowired
    public TestService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public List<UserEntity> findAll() {
        return iUserRepository.findAll();
    }
}
