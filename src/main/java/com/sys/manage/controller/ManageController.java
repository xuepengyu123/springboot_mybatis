package com.sys.manage.controller;

import com.sys.common.entity.Result;
import com.sys.manage.model.*;
import com.sys.manage.service.*;
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
    @Autowired
    private Test1Service test1Service;
    @Autowired
    private Test2Service test2Service;
    @Autowired
    private Test3Service test3Service;
    @Autowired
    private Test4Service test4Service;


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
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        License license = licenseService.selectByPrimaryKey(id);
        return Result.ok(license);
    }

    @RequestMapping(value = "findTest1One", method = RequestMethod.GET)
    public Result findTest1One(int id) {
        XueTest1 xueTest1 = test1Service.selectByPrimaryKey(id);
        return Result.ok(xueTest1);
    }

    @RequestMapping(value = "findTest2One", method = RequestMethod.GET)
    public Result findTest2One(int id) {
        XueTest2 xueTest1 = test2Service.selectByPrimaryKey(id);
        return Result.ok(xueTest1);
    }

    @RequestMapping(value = "findTest3One", method = RequestMethod.GET)
    public Result findTest3One(int id) {
        XueTest3 xueTest1 = test3Service.selectByPrimaryKey(id);
        return Result.ok(xueTest1);
    }

    @RequestMapping(value = "findTest4One", method = RequestMethod.GET)
    public Result findTest4One(int id) {
        XueTest4 xueTest1 = test4Service.selectByPrimaryKey(id);
        return Result.ok(xueTest1);
    }
}