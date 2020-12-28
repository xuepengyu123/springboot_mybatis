package com.sys.manage.controller;

import com.sys.common.entity.Result;
import com.sys.manage.model.User;
import com.sys.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/user")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/login")
    public Result login(HttpServletRequest request, int id) {

        request.getSession().setAttribute("request Url", request.getRequestURL());

        User user = userService.selectByPrimaryKey(id);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUserId", user.getId());
            redisTemplate.opsForValue().set("loginUser:" + user.getId(), session.getId());
            Map<String, Object> map = new HashMap<>();

            map.put("request Url", request.getRequestURL());
            map.put("sessionId", session.getId());
            map.put("user", user);
            return Result.ok(map);
        } else {
            return Result.error("失败");
        }
    }

    @RequestMapping(value = "/getUserInfo")
    public Result get(int userId) {
        User user = userService.selectByPrimaryKey(userId);
        if (user != null) {
            return Result.ok("成功");
        } else {
            return Result.error("失败");
        }
    }

    @RequestMapping(value = "/sessions")
    public Result sessions(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("message", request.getSession().getAttribute("map"));
        return Result.ok(map);
    }
}