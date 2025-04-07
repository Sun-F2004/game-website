package com.firewin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//游戏分类
@Data
@Builder //允许通过builder方式创建对象
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private Integer cateId;

    private String cateName;

    private String url;
}
