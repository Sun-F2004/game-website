package com.firewin.server.controller;

import com.firewin.common.result.Result;
import com.firewin.pojo.entity.Game;
import com.firewin.server.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "*") //允许跨域访问
@CacheConfig(cacheNames = "game") //统一缓存名称
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/highestscore")
    @Cacheable(key = "'HighestScoreGame'")
    public Result<Game> getHighestScoreGame() {
        return Result.success(gameService.getHighestScoreGame());
    }

    @GetMapping("mostcomment")
    @Cacheable(key = "'MostCommentGame'")
    public Result<Game> getMostCommentGame() {
        return Result.success(gameService.getMostCommentGame());
    }

    @GetMapping("/category")
    @Cacheable(key = "'category' + #cateId")
    public Result<List<Game>> getGamesByCategoryId(Integer cateId) {
        return Result.success(gameService.getGamesByCategoryId(cateId));
    }

    @GetMapping
    @Cacheable(key = "'game' + #gameId")
    public Result<Game> getById(Integer gameId) {
        return Result.success(gameService.getById(gameId));
    }
}
