package com.firewin.server.service;

import com.firewin.common.exception.BaseException;
import com.firewin.pojo.dto.UserRegLoginDTO;

public interface UserService {

    void reg(UserRegLoginDTO userRegLoginDTO);

    String login(UserRegLoginDTO userRegLoginDTO);
}
