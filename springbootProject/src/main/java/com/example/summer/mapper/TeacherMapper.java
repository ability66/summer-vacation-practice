package com.example.summer.mapper;


import com.example.summer.entity.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper {
    Teacher selectByTea_no(int tea_no);
    void insertTeachers(Teacher teacher);
}