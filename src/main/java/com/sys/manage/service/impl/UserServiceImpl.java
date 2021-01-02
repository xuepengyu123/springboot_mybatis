package com.sys.manage.service.impl;

import com.sys.manage.dao.UserMapper;
import com.sys.manage.model.User;
import com.sys.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(Integer id) {
        User tUser = userMapper.selectByPrimaryKey(id);
        return tUser;

    }


}
