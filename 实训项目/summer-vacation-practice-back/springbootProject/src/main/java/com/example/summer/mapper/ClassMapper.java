package com.example.summer.mapper;

import com.example.summer.entity.Class;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassMapper {
    int selectClassByStu_no(int stu_no);

}
