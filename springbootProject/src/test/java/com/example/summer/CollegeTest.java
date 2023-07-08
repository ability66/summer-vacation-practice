package com.example.summer;

import com.example.summer.entity.*;
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
    @Autowired
    private GradeService gradeService;
    @Autowired
    private UserService userService;

    @Test
    public void test(){
    Teacher t1=new Teacher();
    Teacher t2=new Teacher();
    //0000000003,1,adsadasda,3
    t1.setTea_col_no(1);
    t1.setTea_level("3");
    t1.setTea_name("adsadasda");
    t1.setTea_no(3);
        t2.setTea_col_no(8);
        t2.setTea_level("10");
        t2.setTea_name("qqq");
        t2.setTea_no(3);
        teacherService.updateTeacher(t1,t2);
    }

}
