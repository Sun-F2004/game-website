package com.firewin.server.service;

import com.firewin.pojo.entity.Game;

import java.util.List;

public interface GameService {

    Game getHighestScoreGame();

    Game getMostCommentGame();

    List<Game> getGamesByCategoryId(Integer cateId);

    Game getById(Integer gameId);
}
