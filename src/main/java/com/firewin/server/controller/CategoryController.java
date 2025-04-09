package com.firewin.server.controller;

import com.firewin.common.result.Result;
import com.firewin.pojo.entity.Category;
import com.firewin.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*")
@CacheConfig(cacheNames = "category") //统一缓存名称
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @Cacheable(key = "'categories'")
    public Result<List<Category>> getAllCategory() {
        return Result.success(categoryService.getAllCategory());
    }
}
