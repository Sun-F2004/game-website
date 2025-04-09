package com.firewin.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddCommentDTO implements Serializable {

    private Integer comId;

    private Integer gameId;

    private String content;
}
