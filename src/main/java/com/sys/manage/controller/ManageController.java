package com.sys.manage.controller;

import com.sys.common.entity.Result;
import com.sys.manage.model.User;
import com.sys.manage.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/api/user")
public class ManageController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ApiOperation(value="用户保存", notes="测试接口详细描述")
    public Result save() {
        User user = new User();
        user.setUserName("xuepengyu");
        user.setPhone("12312312");
        int result = userService.insert(user);
        if(result>0){
            return Result.ok("插入成功");
        }else{
            return Result.error("插入失败");
        }
    }

    @RequestMapping(value = "findAll",method = RequestMethod.GET)
    public Result findAll() {
        List<User> userList = userService.selectAll();
        return Result.ok(userList);
    }

    @RequestMapping(value = "findOne",method = RequestMethod.GET)
    public Result findOne(int id) {
        User user = userService.selectByPrimaryKey(id);
        return Result.ok(user);
    }

    @RequestMapping(value = "deleteOne",method = RequestMethod.GET)
    public Result deleteOne() {
        int id = 1;
        userService.deleteByPrimaryKey(id);
        return Result.ok();
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Result update() {
        int id = 1;
        User user = userService.selectByPrimaryKey(id);
        user.setUserName("这是一个更新数据");
        user.setPhone("9876543");
        userService.updateByPrimaryKey(user);
        return Result.ok();
    }
}