package com.example.summer.controller;

import com.example.summer.entity.ClassTable;
import com.example.summer.entity.Student;
import com.example.summer.entity.Teacher;
import com.example.summer.entity.User;
import com.example.summer.service.ClassTableService;
import com.example.summer.service.StudentService;
import com.example.summer.service.TeacherService;
import com.example.summer.service.UserService;
import com.example.summer.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/setClasstable", method = RequestMethod.POST)
    public void setClassTable(@RequestBody ClassTable classTable) {
        classTableService.insertClassTable(classTable);
    }
}
