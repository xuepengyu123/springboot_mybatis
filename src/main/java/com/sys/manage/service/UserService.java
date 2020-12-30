package com.sys.manage.service;

import com.sys.manage.model.User;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface UserService {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    /**
     * 查询用户
     *
     * @param username
     * @param password
     * @return
     */
    User selectByUserNameAndPassword(String username, String password);
}
