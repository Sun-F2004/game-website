package com.firewin.server.mapper;

import com.firewin.pojo.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("select gameId from comment group by gameId order by count(*) desc limit 1")
    Integer getMostCommentGameId();

    @Select("select * from comment where gameId = #{gameId}")
    List<Comment> getCommentsByGameId(Integer gameId);

    void insert(Comment comment);

    @Delete("delete from comment where comId = #{id}")
    void deleteById(Integer id);
}
