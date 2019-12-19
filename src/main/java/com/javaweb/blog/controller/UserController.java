package com.javaweb.blog.controller;

import com.javaweb.blog.entity.Result;
import com.javaweb.blog.entity.StatusCode;
import com.javaweb.blog.pojo.User;
import com.javaweb.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", userService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody User user) {
        userService.add(user);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user) {
        User u = userService.login(user);
        if(u != null) {
            return new Result(true, StatusCode.OK, "登录成功", u);
        } else {
            return new Result(false, StatusCode.ERROR, "登录失败");
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Result findByUsername(String username) {
        return new Result(true, StatusCode.OK, "查询成功", userService.findByUsername(username));
    }

}
