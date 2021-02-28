package com.sys.manage.service;

import com.sys.manage.model.XueTest1;

import javax.annotation.Resource;

@Resource
public interface Test1Service {

    XueTest1 selectByPrimaryKey(Integer id);


}
