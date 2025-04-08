package com.firewin.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

//用户类
@Data
@Builder //允许通过builder方式创建对象
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer uId;

    private String uname;

    private Date joinDate;

    private String password;

    private String avatar;
}
