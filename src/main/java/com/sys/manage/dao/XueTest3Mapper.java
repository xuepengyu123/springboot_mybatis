package com.sys.manage.dao;

import com.sys.manage.model.XueTest3;
import java.util.List;

public interface XueTest3Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XueTest3 record);

    XueTest3 selectByPrimaryKey(Integer id);

    List<XueTest3> selectAll();

    int updateByPrimaryKey(XueTest3 record);
}