package com.system.summervacationpractice.mapper;

import com.system.summervacationpractice.entity.Teacher;

public interface TeacherMapper {
    Teacher selectByTea_no(int tea_no);
    void insertTeachers(Teacher teacher);
}
