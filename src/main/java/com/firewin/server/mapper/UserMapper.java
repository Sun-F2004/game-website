package com.firewin.server.mapper;

import com.firewin.pojo.entity.User;
import com.firewin.pojo.vo.UserInfoVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    void insert(User user);

    @Select("select * from user where uname = #{username}")
    User getByUsername(String username);

    @Select("select uname, avatar from user where uId = #{id}")
    UserInfoVO getInfoById(Integer id);
}
