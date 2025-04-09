package com.firewin.server.service;

import com.firewin.common.exception.BaseException;
import com.firewin.pojo.dto.UserRegLoginDTO;
import com.firewin.pojo.entity.Game;
import com.firewin.pojo.vo.UserInfoVO;

import java.util.List;

public interface UserService {

    void register(UserRegLoginDTO userRegLoginDTO);

    String login(UserRegLoginDTO userRegLoginDTO);

    UserInfoVO getInfo();

    UserInfoVO getInfoById(Integer id);
}
