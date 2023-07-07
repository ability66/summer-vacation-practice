package com.example.summer.service;

import com.example.summer.entity.ClassTable;
import com.example.summer.mapper.ClassTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassTableService {
    @Autowired
    ClassTableMapper classTableMapper;

    public List<ClassTable> getClassTable(int cla_no) {
        return classTableMapper.selectClassTableByStu_no(cla_no);
    }
}
