package com.system.summervacationpractice.mapper;

import com.system.summervacationpractice.entity.ClassTable;

public interface ClassTableMapper {
    ClassTable selectClassTableByStu_no(int class_no);
    int selectClass_noBySub_no(int sub_no);
    void insertClassTableByClass_no(ClassTable classTable,int class_no);
}
