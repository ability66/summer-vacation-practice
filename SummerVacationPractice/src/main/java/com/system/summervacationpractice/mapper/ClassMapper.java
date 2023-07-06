package com.system.summervacationpractice.mapper;

import com.system.summervacationpractice.entity.Class;

import java.util.List;

public interface ClassMapper {
    Class selectClassByStu_no(int stu_no);
}
