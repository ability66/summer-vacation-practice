package com.example.summer.service;

import com.example.summer.entity.Student;
import com.example.summer.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public Student getMessage(int stu_no) {
        return studentMapper.selectByStu_no(stu_no);
    }

    public List<Integer> getAllStu_no(int class_no) {
        return studentMapper.selectStu_noByClass_no(class_no);
    }
}
