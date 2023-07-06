package com.example.summer.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface ClassMapper {
    Class selectClassByStu_no(int stu_no);
}
