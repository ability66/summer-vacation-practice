package com.example.summer.controller;

import com.example.summer.entity.*;
import com.example.summer.service.*;
import com.example.summer.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Autowired
    StudentService studentService;
    @Autowired
    ClassTableService classTableService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    UserService userService;
    @Autowired
    SubjectService subjectService;

    @RequestMapping(value = "/setTeacher", method = RequestMethod.POST)
    public void setTeacher(@RequestBody Teacher teacher) {
        teacherService.insertTeacher(teacher);
        User user = new User();
        user.setUsername(String.valueOf(teacher.getTea_no()));
        user.setPassword(MD5Util.MD5EncodeUtf8(String.valueOf(teacher.getTea_no())));
        user.setTea_no(teacher.getTea_no());
        user.setPower("teacher");
        userService.insertUser(user);
    }

    @RequestMapping(value = "/getTeachers", method = RequestMethod.POST)
    public List<Teacher> getTeachers() {
        return teacherService.selectAll();
    }

    @RequestMapping(value = "/setStudent", method = RequestMethod.POST)
    public void setStudent(@RequestBody Student student) {
        studentService.insertStudent(student);
        User user = new User();
        user.setUsername(String.valueOf(student.getStu_no()));
        user.setPassword(MD5Util.MD5EncodeUtf8(String.valueOf(student.getStu_no())));
        user.setStu_no(student.getStu_no());
        user.setPower("student");
        userService.insertUser(user);
    }

    @RequestMapping(value = "/getStudents", method = RequestMethod.POST)
    public List<Student> getStudents() {
        return studentService.selectAll();
    }

    @RequestMapping(value = "/setClasstable", method = RequestMethod.POST)
    public void setClassTable(@RequestBody ClassTable classTable,@RequestBody String sub_name,@RequestBody int tea_no) {
        classTable.setClass_no(subjectService.selectSub_noByPK(sub_name,tea_no));
        classTableService.insertClassTable(classTable);
    }

    @RequestMapping(value = "/addClass", method = RequestMethod.GET)
    public void addClass(int stu_no,int class_no) {
        studentService.insertStudentClass(stu_no,class_no);
    }
}
