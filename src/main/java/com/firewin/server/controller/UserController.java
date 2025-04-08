package com.firewin.server.controller;

import com.firewin.common.exception.BaseException;
import com.firewin.common.result.Result;
import com.firewin.pojo.dto.UserRegLoginDTO;
import com.firewin.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//和用户有关的操作
@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin(origins = "*") //允许跨域访问
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/reg")
    public Result<String> reg(@RequestBody UserRegLoginDTO userRegLoginDTO) {
        userService.reg(userRegLoginDTO);
        return Result.success();
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody UserRegLoginDTO userRegLoginDTO) {
        return Result.success(userService.login(userRegLoginDTO));
    }
}
