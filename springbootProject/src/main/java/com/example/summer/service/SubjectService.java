package com.example.summer.service;

import com.example.summer.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectMapper subjectMapper;

    public List<Integer> getClass_no(int tea_no){
        return Collections.singletonList(subjectMapper.selectSub_noByTea_no(tea_no));
    }
}
