package com.example.summer.mapper;


import com.example.summer.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    void insertUser(User user);

    User selectByUsername(String username);

    List<User> list();
    void updatePassword(@Param("password") String password,@Param("user") User user);
}
