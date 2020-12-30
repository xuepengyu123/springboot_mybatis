package com.sys.manage.controller;

import com.sys.common.entity.Result;
import com.sys.common.filter.RedisSessionInterceptor;
import com.sys.common.utils.PasswordUtil;
import com.sys.manage.model.User;
import com.sys.manage.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/manage/user")
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisSessionInterceptor.class);

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/login")
    public Result login(HttpServletRequest request, String username, String password) {
        request.getSession().setAttribute("request Url", request.getRequestURL());
        LOGGER.info("对明文密码进行加密");
        byte[] salt = PasswordUtil.getStaticSalt();
        String ciphertext = PasswordUtil.encrypt(username, password, salt);
        LOGGER.debug("加密后的密码为：{}", ciphertext);
        User user = userService.selectByUserNameAndPassword(username,ciphertext);
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