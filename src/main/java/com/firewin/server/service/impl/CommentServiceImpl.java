package com.firewin.server.service.impl;

import com.firewin.common.context.ThreadLocalContext;
import com.firewin.common.exception.BaseException;
import com.firewin.common.result.Result;
import com.firewin.pojo.dto.AddCommentDTO;
import com.firewin.pojo.entity.Comment;
import com.firewin.server.mapper.CommentMapper;
import com.firewin.server.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentsByGameId(Integer gameId) {
        return commentMapper.getCommentsByGameId(gameId);
    }

    @Override
    public void addComment(AddCommentDTO addCommentDTO) {
        //获取对应的值
        Integer uId = ThreadLocalContext.getCurrentId();
        Integer gameId = addCommentDTO.getGameId();
        String content = addCommentDTO.getContent();
        Date date = new Date(new java.util.Date().getTime());

        Comment comment = Comment.builder()
                .uId(uId).gameId(gameId).content(content).comDate(date).build();

        commentMapper.insert(comment);
    }

    @Override
    public void deleteComment(Integer comId) {
        commentMapper.deleteById(comId);
    }
}
