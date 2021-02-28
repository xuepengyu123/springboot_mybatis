package com.sys.manage.service.impl;

import com.sys.manage.dao.XueTest3Mapper;
import com.sys.manage.model.XueTest3;
import com.sys.manage.service.Test3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Test3Impl implements Test3Service {

    @Autowired
    private XueTest3Mapper userMapper;

    @Override
    public XueTest3 selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);

    }


}
