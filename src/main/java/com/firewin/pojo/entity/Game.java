package com.firewin.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//游戏内容
@Data
@Builder //允许通过builder方式创建对象
@AllArgsConstructor
@NoArgsConstructor
public class Game implements Serializable {

    private Integer gameId;

    private String gameName;

    private String pubDate;

    private String publisher;

    private String intro;

    private Integer cateId;

    private Integer score;

    private String language;

    private String platform;

    private String url;
}
