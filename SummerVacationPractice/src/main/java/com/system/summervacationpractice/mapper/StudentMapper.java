package com.system.summervacationpractice.mapper;

import com.system.summervacationpractice.entity.Student;

import java.util.List;

public interface StudentMapper {
    Student selectByStu_no(int stu_no);
    List<Integer> selectStu_noByClass_no(int class_no);
    void insertStudent(Student student);
    void insertStudentClass(int stu_no,int class_no);
}
