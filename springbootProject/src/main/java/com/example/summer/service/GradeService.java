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

    public List<Grade> getGradeByStu_no(int stu_no) {
        return gradeMapper.selectByStu_no(stu_no);
    }

    public void setGradeByPK(Grade grade) {
        Grade[] grades=new Grade[1];
        grades[0]=grade;
        gradeMapper.insertGrades(grades);
    }
}
