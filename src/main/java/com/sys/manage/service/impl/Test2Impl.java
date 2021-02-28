package com.sys.manage.service.impl;

import com.sys.manage.dao.XueTest2Mapper;
import com.sys.manage.model.XueTest2;
import com.sys.manage.service.Test2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Test2Impl implements Test2Service {

    @Autowired
    private XueTest2Mapper userMapper;

    @Override
    public XueTest2 selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);


    }


}
