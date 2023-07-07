package com.example.summer.service;

import com.example.summer.entity.ClassTable;
import com.example.summer.mapper.ClassTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassTableService {
    @Autowired
    private ClassTableMapper classTableMapper;
    public  ClassTable selectClassTableByStu_no(int class_no){
        return classTableMapper.selectClassTableByStu_no(class_no);
    }
    public int selectClass_noBySub_no(int sub_no){
        return classTableMapper.selectClass_noBySub_no(sub_no);
    }
    public void insertClassTableByClass_no(ClassTable classTable,int class_no){
        classTableMapper.insertClassTableByClass_no(classTable,class_no);
    }


}
