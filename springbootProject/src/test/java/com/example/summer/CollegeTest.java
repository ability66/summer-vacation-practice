package com.example.summer;

import com.example.summer.entity.ClassTable;
import com.example.summer.entity.College;
import com.example.summer.entity.Terminology;
import com.example.summer.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CollegeTest {
    @Autowired
    private TerminologyService terminologyService;
    @Autowired
    private CollegeService collegeService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ReportService reportService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ClassTableService classTableService;

    @Test
    public void test(){
        ClassTable c1=new ClassTable();
        c1.setTea_no(1);
        c1.setSub_no(1);
        c1.setClass_weekday("周三");

    }

}
