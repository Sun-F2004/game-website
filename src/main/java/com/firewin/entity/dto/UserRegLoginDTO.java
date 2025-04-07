package com.firewin.entity.dto;

import lombok.Data;

//用户注册或者登录传来的数据
@Data
public class UserRegLoginDTO {

    private String username;

    private String password;
}
