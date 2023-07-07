package com.example.summer.service;

import com.example.summer.entity.Subject;
import com.example.summer.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;

    public List<Integer> selectSub_noByTea_no(int tea_no) {
        return subjectMapper.selectSub_noByTea_no(tea_no);
    }

    public void insertSubject(Subject subject) {
        subjectMapper.insertSubject(subject);
    }
}
