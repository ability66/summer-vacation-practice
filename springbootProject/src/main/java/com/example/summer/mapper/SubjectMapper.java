package com.example.summer.mapper;


import com.example.summer.entity.Subject;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectMapper {
    int selectSub_noByTea_no(int tea_no);
    void insertSubject(Subject subject);
}
