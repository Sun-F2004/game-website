package com.firewin.server.service.impl;

import com.firewin.common.constant.CategoryConstant;
import com.firewin.common.constant.GameConstant;
import com.firewin.common.exception.BaseException;
import com.firewin.pojo.entity.Game;
import com.firewin.server.mapper.CommentMapper;
import com.firewin.server.mapper.GameMapper;
import com.firewin.server.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GameServiceImpl implements GameService {

    @Autowired
    private GameMapper gameMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Game getHighestScoreGame() {
        return gameMapper.getHighestScoreGame();
    }

    @Override
    public Game getMostCommentGame() {
        //先获取最多评论的gameId
        Integer gameId = commentMapper.getMostCommentGameId();

        return gameMapper.getById(gameId);
    }

    @Override
    public List<Game> getGamesByCategoryId(Integer cateId) {
        List<Game> gameList = gameMapper.getGamesByCategoryId(cateId);
        if(gameList == null || gameList.isEmpty()) {
            throw new BaseException(CategoryConstant.CATEGORY_NO_GAME);
        }
        return gameMapper.getGamesByCategoryId(cateId);
    }

    @Override
    public Game getById(Integer gameId) {
        Game game = gameMapper.getById(gameId);
        if(game == null) {
            throw new BaseException(GameConstant.GAME_NO_EXIST);
        }
        return game;
    }
}
