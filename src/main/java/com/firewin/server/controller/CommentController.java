package com.firewin.server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.firewin.common.result.Result;
import com.firewin.pojo.dto.AddCommentDTO;
import com.firewin.pojo.entity.Comment;
import com.firewin.server.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "*") //允许跨域访问
@CacheConfig(cacheNames = "comment") //统一缓存名称
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/game")
    public Result<List<Comment>> getCommentsByGameId(Integer gameId) throws JsonProcessingException {
        return Result.success(commentService.getCommentsByGameId(gameId));
    }

    @PutMapping
    public Result<String> addComment(@RequestBody AddCommentDTO addCommentDTO) {
        commentService.addComment(addCommentDTO);
        return Result.success();
    }

    @DeleteMapping
    public Result<String> deleteComment(Integer comId){
        commentService.deleteComment(comId);
        return Result.success();
    }
}
