package com.firewin.server.interceptor;

import com.firewin.common.constant.JwtClaimsConstant;
import com.firewin.common.properties.JwtProperties;
import com.firewin.common.util.JwtUtil;
import com.firewin.common.context.ThreadLocalContext;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//jwt令牌的校验器
@Component
@Slf4j
public class JwtTokenAdminInterceptor implements HandlerInterceptor {

    //之前设置的属性
    @Autowired
    private JwtProperties jwtProperties;

    //校验jwt
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            return true;
        }

        //1、从请求头中获取令牌
        String token = request.getHeader(jwtProperties.getAdminTokenName());

        //2、校验令牌
        try {
            log.info("jwt校验:{}", token);
            Claims claims = JwtUtil.parseJWT(jwtProperties.getAdminSecretKey(), token);
            Integer uId = Integer.valueOf(claims.get(JwtClaimsConstant.USER_ID).toString());
            log.info("当前用户id：{}", uId);
            //使用ThreadLocal来存储ID
            ThreadLocalContext.setCurrentId(uId);
            //3、通过，放行
            return true;
        } catch (Exception ex) {
            //4、不通过，响应401状态码
            response.setStatus(401);
            return false;
        }
    }
}
