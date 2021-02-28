package com.sys.manage.service.impl;

import com.sys.manage.dao.XueTest1Mapper;
import com.sys.manage.model.XueTest1;
import com.sys.manage.service.Test1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Test1Impl implements Test1Service {

    @Autowired
    private XueTest1Mapper userMapper;

    @Override
    public XueTest1 selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);

    }


}
