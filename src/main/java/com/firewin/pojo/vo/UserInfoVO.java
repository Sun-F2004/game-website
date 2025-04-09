package com.firewin.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoVO implements Serializable {

    private Integer uId;

    private String uname;

    private String avatar;
}
