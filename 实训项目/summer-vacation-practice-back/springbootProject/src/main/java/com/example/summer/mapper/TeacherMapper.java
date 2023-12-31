package com.example.summer.mapper;


import com.example.summer.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {
    Teacher selectByTea_no(int tea_no);

    void insertTeachers(Teacher[] teachers);

    void insertTeacher(Teacher teacher);
    void deleteTeacherByTea_no(int tea_no);
    void updateTeacher(@Param("oldTea") Teacher oldTea, @Param("newTea") Teacher newTea);
    List<Teacher> selectAll();
}
