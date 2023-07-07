package com.example.summer.service;

import com.example.summer.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {
    @Autowired
    ClassMapper classMapper;

    public int getCla_noByStu_no(int stu_no) {
        return classMapper.selectClassByStu_no(stu_no);
    }
}
