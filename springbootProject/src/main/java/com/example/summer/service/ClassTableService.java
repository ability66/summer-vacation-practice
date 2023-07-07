package com.example.summer.service;

import com.example.summer.entity.ClassTable;
import com.example.summer.mapper.ClassTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassTableService {
    @Autowired
    private ClassTableMapper classTableMapper;

    public List<ClassTable> selectClassTableByStu_no(int class_no) {
        return classTableMapper.selectClassTableByStu_no(class_no);
    }

    public List<Integer> selectClass_noBySub_no(int sub_no) {
        return classTableMapper.selectClass_noBySub_no(sub_no);
    }

    public void insertClassTable(ClassTable classTable) {
        classTableMapper.insertClassTable(classTable);
    }


}
