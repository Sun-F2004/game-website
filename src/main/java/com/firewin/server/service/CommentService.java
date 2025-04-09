package com.firewin.server.service;

import com.firewin.common.result.Result;
import com.firewin.pojo.dto.AddCommentDTO;
import com.firewin.pojo.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentsByGameId(Integer gameId);

    void addComment(AddCommentDTO addCommentDTO);

    void deleteComment(Integer comId);
}
