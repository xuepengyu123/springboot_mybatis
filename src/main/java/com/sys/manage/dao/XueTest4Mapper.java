package com.sys.manage.dao;

import com.sys.manage.model.XueTest4;
import java.util.List;

public interface XueTest4Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XueTest4 record);

    XueTest4 selectByPrimaryKey(Integer id);

    List<XueTest4> selectAll();

    int updateByPrimaryKey(XueTest4 record);
}