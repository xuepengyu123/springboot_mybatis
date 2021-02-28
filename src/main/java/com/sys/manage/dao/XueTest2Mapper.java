package com.sys.manage.dao;

import com.sys.manage.model.XueTest2;
import java.util.List;

public interface XueTest2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XueTest2 record);

    XueTest2 selectByPrimaryKey(Integer id);

    List<XueTest2> selectAll();

    int updateByPrimaryKey(XueTest2 record);
}