package com.firewin.server.controller;

import com.firewin.common.result.Result;
import com.firewin.pojo.dto.UserRegLoginDTO;
import com.firewin.pojo.vo.UserInfoVO;
import com.firewin.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

//和用户有关的操作
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*") //允许跨域访问
@CacheConfig(cacheNames = "user") //统一缓存名称
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/reg")
    public Result<String> register(@RequestBody UserRegLoginDTO userRegLoginDTO) {
        userService.register(userRegLoginDTO);
        return Result.success();
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody UserRegLoginDTO userRegLoginDTO) {
        return Result.success(userService.login(userRegLoginDTO));
    }

    @GetMapping("/userinfo")
    public Result<UserInfoVO> getInfo() {
        return Result.success(userService.getInfo());
    }

    @GetMapping
    @Cacheable(key = "'userInfo' + #id")
    public Result<UserInfoVO> getInfoById(Integer id) {
        return Result.success(userService.getInfoById(id));
    }
}
