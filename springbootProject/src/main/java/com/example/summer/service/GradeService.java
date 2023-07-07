package com.example.summer.service;

import com.example.summer.entity.Grade;
import com.example.summer.entity.Subject;
import com.example.summer.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeMapper gradeMapper;
    public List<Subject> selectByStu_no(int stu_no){
        return gradeMapper.selectByStu_no(stu_no);
    }
    public List<Subject> selectByStu_noClass_no(int stu_no,int class_no){
        return gradeMapper.selectByStu_noClass_no(stu_no,class_no);
    }
    public void insertGrades(Grade[] grades){
        gradeMapper.insertGrades(grades);
    }
}
