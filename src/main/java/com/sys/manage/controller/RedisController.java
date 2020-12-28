package com.sys.manage.controller;

import com.sys.common.entity.Result;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/redis")
public class RedisController {


    @RequestMapping(value = "/first", method = RequestMethod.GET)
//    @ApiOperation(value = "用户保存", notes = "测试接口详细描述")
    public Result save(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("request Url", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        return Result.ok(map);
    }

//    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
//    public Object sessions (HttpServletRequest request){
//        Map<String, Object> map = new HashMap<>();
//        map.put("sessionId", request.getSession().getId());
//        map.put("message", request.getSession().getAttribute("map"));
//        return map;
//    }

}