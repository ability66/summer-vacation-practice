package com.system.summervacationpractice.mapper;

import com.system.summervacationpractice.entity.User;

import java.util.List;

public interface UserMapper {
    void insertUser(User user);
    User selectByUsername(String username);
}
