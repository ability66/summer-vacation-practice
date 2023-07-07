package com.example.summer.controller;

import com.example.summer.entity.Class;
import com.example.summer.entity.*;
import com.example.summer.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {
    @Autowired
    StudentService studentService;
    ClassTableService classTableService;
    ClassService classService;
    ReportService reportService;
    GradeService gradeService;

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public Student getMessage(int stu_no) {
        return studentService.selectByStu_no(stu_no);
    }

    @RequestMapping(value = "/getClassTable", method = RequestMethod.GET)
    public List<ClassTable> getClassTableByStu_no(int stu_no) {
        Class cla = classService.selectClassByStu_no(stu_no);
        return classTableService.selectClassTableByStu_no(cla.getClass_no());
    }

    @RequestMapping(value = "/updateReport")
    public void updateReport(@RequestBody Report report) {
        reportService.insertReport(report);
    }

    @RequestMapping(value = "/getGrade", method = RequestMethod.GET)
    public List<Grade> getGrade(int stu_no) {
        return gradeService.selectByStu_no(stu_no);
    }
}
