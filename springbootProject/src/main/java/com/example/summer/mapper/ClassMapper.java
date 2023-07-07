package com.example.summer.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface ClassMapper {
    int selectClassByStu_no(int stu_no);
}
