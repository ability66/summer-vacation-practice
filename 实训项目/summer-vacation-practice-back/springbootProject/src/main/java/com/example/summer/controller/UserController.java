package com.example.summer.controller;

import com.example.summer.entity.User;
import com.example.summer.service.UserService;
import com.example.summer.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    //登录请求
    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        String password= user.getPassword();
        String username= user.getUsername();
        password = MD5Util.MD5EncodeUtf8(password);

        user.setPassword(password);

        User ruser = userService.LoginIn(username);
        if (user.getUsername().equals("admin") && user.getPassword().equals(MD5Util.MD5EncodeUtf8("admin"))) {
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
