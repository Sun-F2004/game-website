package com.firewin.server.service.impl;

import com.firewin.entity.dto.UserRegLoginDTO;
import com.firewin.server.mapper.UserMapper;
import com.firewin.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(UserRegLoginDTO userRegLoginDTO) {

    }
}
