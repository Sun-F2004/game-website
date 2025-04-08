package com.firewin.server.service.impl;

import com.firewin.common.constant.JwtClaimsConstant;
import com.firewin.common.constant.UserConstant;
import com.firewin.common.exception.BaseException;
import com.firewin.common.properties.JwtProperties;
import com.firewin.common.util.JwtUtil;
import com.firewin.pojo.entity.User;
import com.firewin.pojo.dto.UserRegLoginDTO;
import com.firewin.server.mapper.UserMapper;
import com.firewin.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtProperties jwtProperties;

    @Override
    public void reg(UserRegLoginDTO userRegLoginDTO) {
        //赋值
        String password = userRegLoginDTO.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes()); //进行md5加密

        User user = User.builder()
                .uname(userRegLoginDTO.getUsername())
                .password(password).build();

        //设置添加日期
        Date date = new Date(new java.util.Date().getTime());
        user.setJoinDate(date);
        //使用默认头像
        user.setAvatar(UserConstant.DEFAULT_AVATAR);

        userMapper.insert(user);
    }

    @Override
    public String login(UserRegLoginDTO userRegLoginDTO) {
        String username = userRegLoginDTO.getUsername();
        String password = DigestUtils.md5DigestAsHex(userRegLoginDTO.getPassword().getBytes());


        User user = userMapper.getByUsername(username);
        //用户不存在
        if (user == null) {
            throw new BaseException(UserConstant.USER_NO_EXIST);
        }

        //密码错误
        String passwordGot = user.getPassword();
        if(!password.equals(passwordGot)) {
            throw new BaseException(UserConstant.ERROR_PASSWORD);
        }

        //进行加密
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getUId());

        return JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);
    }
}
