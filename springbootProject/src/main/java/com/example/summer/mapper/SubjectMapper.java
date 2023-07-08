package com.example.summer.mapper;


import com.example.summer.entity.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectMapper {
    List<Integer> selectSub_noByTea_no(int tea_no);

    void insertSubject(Subject subject);
    void deleteSubjectBySub_nameAndTea_no(int tea_no,String sub_name);
}
