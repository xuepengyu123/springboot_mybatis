package com.sys.manage.controller;

import com.sys.common.entity.Result;
import com.sys.manage.model.License;
import com.sys.manage.model.User;
import com.sys.manage.service.LicenseService;
import com.sys.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class ManageController {

    @Autowired
    private UserService userService;
    @Autowired
    private LicenseService licenseService;

    @RequestMapping(value = "findOne", method = RequestMethod.GET)
    public Result findOne(int id) {
        User user = userService.selectByPrimaryKey(id);
        return Result.ok(user);
    }

    //    @RequestMapping(value = "save", method = RequestMethod.POST)
//    @ApiOperation(value = "用户保存", notes = "测试接口详细描述")
//    public Result save() {
//        return Result.ok("插入成功");
//
//    }

    @RequestMapping(value = "findLicenseOne", method = RequestMethod.GET)
    public Result findLicenseOne(int id) {
        License license = licenseService.selectByPrimaryKey(id);
        return Result.ok(license);
    }
}