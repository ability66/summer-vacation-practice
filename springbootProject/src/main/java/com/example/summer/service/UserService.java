package com.example.summer.service;

import com.example.summer.entity.User;
import com.example.summer.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> list() {
        return userMapper.list();
    }

    public User LoginIn(String username) {
        return userMapper.selectByUsername(username);
    }
}
