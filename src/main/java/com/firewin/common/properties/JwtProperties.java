package com.firewin.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//注入jwt对应属性的类
@Component
@ConfigurationProperties(prefix = "firewin.jwt")
@Data
public class JwtProperties {

    private String adminSecretKey;

    private long adminTtl;

    private String adminTokenName;
}
