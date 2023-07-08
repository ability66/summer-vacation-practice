package com.example.summer.mapper;


import com.example.summer.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    Student selectByStu_no(int stu_no);

    List<Integer> selectStu_noByClass_no(int class_no);

    void insertStudent(Student student);

    void insertStudentClass(int stu_no, int class_no);

    void deleteStudentByStu_no(int stu_no);
}
