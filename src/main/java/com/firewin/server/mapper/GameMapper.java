package com.firewin.server.mapper;

import com.firewin.pojo.entity.Game;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GameMapper {

    @Select("select * from game where score = (select MAX(score) from game) limit 1")
    Game getHighestScoreGame();

    @Select("select * from game where gameId = #{id}")
    Game getById(Integer id);

    @Select("select * from game where cateId = #{cateId}")
    List<Game> getGamesByCategoryId(Integer cateId);
}
