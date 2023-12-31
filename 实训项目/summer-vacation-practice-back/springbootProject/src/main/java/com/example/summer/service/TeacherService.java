package com.example.summer.service;

import com.example.summer.entity.Teacher;
import com.example.summer.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public Teacher selectByTea_no(int tea_no) {
        return teacherMapper.selectByTea_no(tea_no);
    }

    public void insertTeachers(Teacher[] teachers) {
        teacherMapper.insertTeachers(teachers);
    }

    public void insertTeacher(Teacher teacher) {
        teacherMapper.insertTeacher(teacher);
    }
    public void deleteTeacherByTea_no(int tea_no){
        teacherMapper.deleteTeacherByTea_no(tea_no);
    }
    public List<Teacher> selectAll() {
        return teacherMapper.selectAll();
    }
}
