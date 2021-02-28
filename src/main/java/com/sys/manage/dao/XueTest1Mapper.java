package com.sys.manage.dao;

import com.sys.manage.model.XueTest1;
import java.util.List;

public interface XueTest1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XueTest1 record);

    XueTest1 selectByPrimaryKey(Integer id);

    List<XueTest1> selectAll();

    int updateByPrimaryKey(XueTest1 record);
}