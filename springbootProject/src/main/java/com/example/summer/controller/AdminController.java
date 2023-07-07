package com.example.summer.controller;

import com.example.summer.entity.ClassTable;
import com.example.summer.entity.Student;
import com.example.summer.entity.Teacher;
import com.example.summer.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Autowired
    StudentService studentService;
    ClassTableService classTableService;
    ClassService classService;
    ReportService reportService;
    GradeService gradeService;
    TeacherService teacherService;
    SubjectService subjectService;

    @RequestMapping("/setTeacher")
    public void setTeacher(@RequestBody Teacher teacher) {
        teacherService.insertTeacher(teacher);
    }

    @RequestMapping("/setStudent")
    public void setTeacher(@RequestBody Student student) {
        studentService.insertStudent(student);
    }

    @RequestMapping("/setClasstable")
    public void setTeacher(@RequestBody ClassTable classTable) {
        classTableService.insertClassTable(classTable);
    }
}
