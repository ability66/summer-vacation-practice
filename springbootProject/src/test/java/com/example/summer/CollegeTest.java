package com.example.summer;

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

    @Test
    public void test(){
     subjectService.deleteSubjectBySub_nameAndTea_no(3,"马原");

    }

}
