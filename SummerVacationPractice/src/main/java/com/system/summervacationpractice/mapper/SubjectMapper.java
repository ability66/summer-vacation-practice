package com.system.summervacationpractice.mapper;

import com.system.summervacationpractice.entity.Subject;

public interface SubjectMapper {
    int selectSub_noByTea_no(int tea_no);
    void insertSubject(Subject subject);
}
