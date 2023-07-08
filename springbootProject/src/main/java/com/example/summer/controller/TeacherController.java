package com.example.summer.controller;

import com.example.summer.entity.Grade;
import com.example.summer.entity.Report;
import com.example.summer.entity.Student;
import com.example.summer.entity.Teacher;
import com.example.summer.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {
    @Autowired
    StudentService studentService;
    @Autowired
    ClassTableService classTableService;
    @Autowired
    ReportService reportService;
    @Autowired
    GradeService gradeService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    SubjectService subjectService;

    @RequestMapping(value = "/getMessage", method = RequestMethod.POST)
    public Teacher getMessage(@RequestBody int tea_no) {
        return teacherService.selectByTea_no(tea_no);
    }
//
//    @RequestMapping(value = "/getReport", method = RequestMethod.POST)
//    public List<Report> getReport(@RequestBody int tea_no) {
////        List<Integer> sub_nos = subjectService.selectSub_noByTea_no(tea_no);
////        List<Integer> stu_nos = null;
////        for (int i = 0; i < sub_nos.size(); i++) {
////            List<Integer> tmp = studentService.selectStu_noByClass_no(sub_nos.get(i));
////            stu_nos.addAll(tmp);
////        }
////
////        List<Report> reports = reportService.selectByStu_nos(stu_nos.stream().mapToInt(i -> i).toArray());
////        return reports;
//    }

//    @RequestMapping(value = "/checkReport",method = RequestMethod.GET)
//    public List<Report> getReport(int tea_no) {
//        List<Integer> sub_nos=subjectService.selectSub_noByTea_no(tea_no);
//        List<Integer>stu_nos=null;
//        for (int i = 0; i < sub_nos.size(); i++) {
//            List<Integer> tmp = studentService.selectStu_noByClass_no(sub_nos.get(i));
//            stu_nos.addAll(tmp);
//        }
//
//        List<Report>reports=reportService.selectByStu_nos(stu_nos.stream().mapToInt(i->i).toArray());
//        return reports;
//    }

    @RequestMapping(value = "/getStudent", method = RequestMethod.POST)
    public List<Student> getGrade(@RequestBody int tea_no) {
        List<Integer> sub_nos = subjectService.selectSub_noByTea_no(tea_no);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < sub_nos.size(); i++) {
            List<Integer> tmp = classTableService.selectClass_noBySub_no(sub_nos.get(i));
            list.addAll(tmp);
        }
        List<Integer> stu_nos = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            List<Integer> tmp = studentService.selectStu_noByClass_no(list.get(i));
            stu_nos.addAll(tmp);
        }
        List<Student> res = new ArrayList<Student>();
        for (int i = 0; i < stu_nos.size(); i++) {
            if (studentService.selectByStu_no(stu_nos.get(i)) != null) {
                res.add(studentService.selectByStu_no(stu_nos.get(i)));
            }
        }

        return res;
    }

    @RequestMapping(value = "/setStudentGrade", method = RequestMethod.POST)
    public void setGrade(@RequestBody Grade grade) {
        gradeService.insertGrade(grade);
    }

//    @RequestMapping(value = "/getStudentGrades")
//    public List<Grade> getGrade(int tea_no,int sub_no) {
//
//    }
}
