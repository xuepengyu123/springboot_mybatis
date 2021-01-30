package com.sys.manage.service;

import com.sys.manage.model.License;

import javax.annotation.Resource;

@Resource
public interface LicenseService {

    License selectByPrimaryKey(Integer id);
}
