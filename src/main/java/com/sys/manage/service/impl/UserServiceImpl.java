package com.sys.manage.service.impl;

import com.sys.manage.dao.TUserMapper;
import com.sys.manage.model.TUser;
import com.sys.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public TUser selectByPrimaryKey(Integer id) {
        TUser tUser = tUserMapper.selectByPrimaryKey(id);
        return tUser;

    }


}
