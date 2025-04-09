package com.firewin.server.service.impl;

import com.firewin.pojo.entity.Category;
import com.firewin.server.mapper.CategoryMapper;
import com.firewin.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.getAllCategory();
    }
}
