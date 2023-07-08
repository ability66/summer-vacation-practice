package com.example.summer.mapper;


import com.example.summer.entity.Subject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectMapper {
    List<Integer> selectSub_noByTea_no(int tea_no);

    void insertSubject(Subject subject);
    void deleteSubjectBySub_nameAndTea_no(int tea_no,String sub_name);
    void updateSubject(@Param("oldSub")Subject oldSub,@Param("newSub")Subject newSub);
    int selectSubjectByPK(String sub_name,int tea_no);
}
