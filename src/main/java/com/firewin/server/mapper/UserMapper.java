package com.firewin.server.mapper;

import com.firewin.pojo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    void insert(User user);

    @Select("select * from user where uname = #{username}")
    User getByUsername(String username);
}
