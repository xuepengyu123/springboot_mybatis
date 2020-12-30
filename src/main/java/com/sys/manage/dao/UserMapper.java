package com.sys.manage.dao;

import com.sys.manage.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    /**
     *
     * @param username
     * @param password
     * @return
     */
    User selectByUserNameAndPassword(@Param("username") String username, @Param("password") String password);
}