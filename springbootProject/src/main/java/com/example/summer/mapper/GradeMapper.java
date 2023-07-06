package com.example.summer.mapper;

import com.example.summer.entity.Grade;
import com.example.summer.entity.Subject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GradeMapper {
    List<Subject> selectByStu_no(int stu_no);
    List<Subject> selectByStu_noClass_no(int stu_no,int class_no);
    void insertGrades(@Param("gardes") Grade[] grades);
}
