package com.firewin.pojo.dto;

import lombok.Data;

import java.io.Serializable;

//用户注册或者登录传来的数据
@Data
public class UserRegLoginDTO implements Serializable {

    private String username;

    private String password;
}
