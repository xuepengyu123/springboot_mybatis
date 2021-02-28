package com.sys.manage.service.impl;

import com.sys.manage.dao.XueTest4Mapper;
import com.sys.manage.model.XueTest4;
import com.sys.manage.service.Test4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Test4Impl implements Test4Service {

    @Autowired
    private XueTest4Mapper userMapper;

    @Override
    public XueTest4 selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);

    }


}
