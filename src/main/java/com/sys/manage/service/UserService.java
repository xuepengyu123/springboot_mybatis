package com.sys.manage.service;

import com.sys.manage.model.TUser;

import javax.annotation.Resource;

@Resource
public interface UserService {

    TUser selectByPrimaryKey(Integer id);


}
