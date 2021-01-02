package com.sys.manage.service;

import com.sys.manage.model.User;

import javax.annotation.Resource;

@Resource
public interface UserService {

    User selectByPrimaryKey(Integer id);


}
