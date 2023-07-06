package com.system.summervacationpractice.mapper;

import com.system.summervacationpractice.entity.Grade;
import com.system.summervacationpractice.entity.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeMapper {
    List<Subject> selectByStu_no(int stu_no);
    List<Subject> selectByStu_noClass_no(int stu_no,int class_no);
    void insertGrades(@Param("gardes") Grade[] grades);
}
