package com.firewin.pojo.entity;

//用户的评论

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@Builder //允许通过builder方式创建对象
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

    private Integer comId;

    private Integer gameId;

    private Integer uId;

    private String content;

    private Date comDate;
}
