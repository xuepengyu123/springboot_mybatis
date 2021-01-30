package com.sys.manage.service.impl;

import com.sys.manage.dao.LicenseMapper;
import com.sys.manage.model.License;
import com.sys.manage.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LicenseServiceImpl implements LicenseService {
    @Autowired
    private LicenseMapper licenseMapper;

    @Override
    public License selectByPrimaryKey(Integer id) {
        return licenseMapper.selectByPrimaryKey(id);

    }

}
