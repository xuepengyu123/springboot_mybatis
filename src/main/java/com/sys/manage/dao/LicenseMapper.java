package com.sys.manage.dao;

import com.sys.manage.model.License;
import java.util.List;

public interface LicenseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(License record);

    License selectByPrimaryKey(Integer id);

    List<License> selectAll();

    int updateByPrimaryKey(License record);
}