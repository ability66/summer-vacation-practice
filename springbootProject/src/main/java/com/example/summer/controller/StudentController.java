package com.example.summer.controller;

import com.example.summer.entity.ClassTable;
import com.example.summer.entity.Grade;
import com.example.summer.entity.Report;
import com.example.summer.entity.Student;
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
    @Autowired
    ClassTableService classTableService;
    @Autowired
    ClassService classService;
    @Autowired
    ReportService reportService;
    @Autowired
    GradeService gradeService;

    @RequestMapping(value = "/getMessage", method = RequestMethod.POST)
    public Student getMessage(@RequestBody int stu_no) {
        return studentService.selectByStu_no(stu_no);
    }

    @RequestMapping(value = "/getClassTable", method = RequestMethod.POST)
    public List<ClassTable> getClassTableByStu_no(@RequestBody int stu_no) {
        System.out.println(stu_no);
        int cla = classService.selectClassByStu_no(stu_no);
        System.out.println(cla);
        return classTableService.selectClassTableByStu_no(cla);
    }

    @RequestMapping(value = "/updateReport", method = RequestMethod.POST)
    public void updateReport(@RequestBody Report report) {
        reportService.insertReport(report);
    }

    @RequestMapping(value = "/getGrade", method = RequestMethod.POST)
    public List<Grade> getGrade(@RequestBody int stu_no) {
        return gradeService.selectByStu_no(stu_no);
    }
}
