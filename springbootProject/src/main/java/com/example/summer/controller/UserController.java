package com.example.summer.controller;

import com.example.summer.entity.User;
import com.example.summer.service.UserService;
import com.example.summer.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")


public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    //登录请求
    @RequestMapping(value = "/loginIn", method = RequestMethod.GET)
    public String login(String username, String password) {
        User user = new User();
        password = MD5Util.MD5EncodeUtf8(password);

        user.setUsername(username);
        user.setPassword(password);

        User ruser = userService.LoginIn(username);
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
            return "admin";
        }
        if (ruser == null) {
            return "not exist!";
        }

        if (ruser.getPassword().equals(user.getPassword())) {
            if (ruser.getStu_no() != 0) {
                return "student";
            } else {
                return "teacher";
            }
        }
        return "password error";
    }
}
