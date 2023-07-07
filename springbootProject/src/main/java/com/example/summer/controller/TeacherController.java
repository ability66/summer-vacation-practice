package com.example.summer.controller;

import com.example.summer.entity.Grade;
import com.example.summer.entity.Student;
import com.example.summer.entity.Teacher;
import com.example.summer.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {
    @Autowired
    StudentService studentService;
    ClassTableService classTableService;
    ClassService classService;
    ReportService reportService;
    GradeService gradeService;
    TeacherService teacherService;
    SubjectService subjectService;

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public Teacher getMessage(int tea_no) {
        return teacherService.selectByTea_no(tea_no);
    }

//    @RequestMapping(value = "/queryReport",method = RequestMethod.GET)
//    public List<Report> getReport(int tea_no) {
//        List<Integer> sub_nos=subjectService.getClass_no(tea_no);
//        List<Integer>list;
//        for(int sub_no:sub_nos) {
//            list.add()
//        }
//    }

    @RequestMapping(value = "/getStudent", method = RequestMethod.GET)
    public List<Student> getGrade(int tea_no) {
        List<Integer> list = subjectService.selectSub_noByTea_no(tea_no);
        List<Integer> stu_nos = null;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> tmp = studentService.selectStu_noByClass_no(list.get(i));
            stu_nos.addAll(tmp);
        }

        List<Student> res = null;
        for (int i = 0; i < stu_nos.size(); i++) {
            res.add(studentService.selectByStu_no(stu_nos.get(i)));
        }

        return res;
    }

    @RequestMapping(value = "/setStudentGrade")
    public void setGrade(@RequestBody Grade grade) {
        gradeService.insertGrade(grade);
    }

//    @RequestMapping(value = "/getStudentGrades")
//    public List<Grade> getGrade(int tea_no,int sub_no) {
//
//    }
}
