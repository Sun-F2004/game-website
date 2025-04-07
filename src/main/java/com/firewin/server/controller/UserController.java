package com.firewin.server.controller;

import com.firewin.common.result.Result;
import com.firewin.entity.dto.UserRegLoginDTO;
import com.firewin.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//和用户有关的操作
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    public Result<String> reg(@RequestBody UserRegLoginDTO userRegLoginDTO) {
        userService.reg(userRegLoginDTO);
        return Result.success();
    }
}
