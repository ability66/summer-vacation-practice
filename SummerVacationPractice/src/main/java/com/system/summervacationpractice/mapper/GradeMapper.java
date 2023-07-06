package com.system.summervacationpractice.mapper;

import com.system.summervacationpractice.entity.Grade;
import com.system.summervacationpractice.entity.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeMapper {
    List<Grade> selectByStu_no(int stu_no);
    Grade selectByStu_noClass_no(int stu_no,int sub_no);
    void insertGrades(Grade[] grades);
}
