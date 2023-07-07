package com.example.summer.mapper;


import com.example.summer.entity.ClassTable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassTableMapper {
    List<ClassTable> selectClassTableByStu_no(int class_no);

    List<Integer> selectClass_noBySub_no(int sub_no);

    void insertClassTable(ClassTable classTable);
}
