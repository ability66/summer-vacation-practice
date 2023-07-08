package com.example.summer.mapper;

import com.example.summer.entity.Grade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeMapper {
    List<Grade> selectByStu_no(int stu_no);

    List<Grade> selectByStu_noClass_no(int stu_no, int class_no);

    void insertGrades(Grade[] grades);

    void insertGrade(Grade grade);
}
