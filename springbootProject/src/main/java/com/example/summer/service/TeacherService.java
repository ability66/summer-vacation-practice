package com.example.summer.service;

import com.example.summer.entity.Teacher;
import com.example.summer.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    public Teacher selectByTea_no(int tea_no){
        return teacherMapper.selectByTea_no(tea_no);
    }
    public void insertTeachers(Teacher teacher){
        teacherMapper.insertTeachers(teacher);
    }
}
