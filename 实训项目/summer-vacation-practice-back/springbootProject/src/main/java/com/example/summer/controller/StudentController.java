package com.example.summer.controller;

import com.example.summer.entity.*;
import com.example.summer.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
@Slf4j
@CrossOrigin("*")
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
    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/getMessage", method = RequestMethod.POST)
    public Student getMessage(@RequestBody int stu_no) {
        return studentService.selectByStu_no(stu_no);
    }

    @RequestMapping(value = "/getClassTable", method = RequestMethod.POST)
    public List<ClassTable> getClassTableByStu_no(@RequestBody int stu_no) {
        int cla = classService.selectClassByStu_no(stu_no);
        return classTableService.selectClassTableByStu_no(cla);
    }

    @RequestMapping("/upload")
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file,
                                      @RequestParam(value = "stu_no",required = false) Integer stu_no,
                                      @RequestParam(value = "tea_no",required = false) Integer tea_no) throws IOException {
        Map<String, Object> map = new HashMap<>();
        stu_no=123022;
        tea_no=222;

        if (null != file) {
            String myFileName = file.getOriginalFilename();// 文件原名称

            String pat = "D:/tempFile/";//获取文件保存路径

            String sqlPath = System.currentTimeMillis() + "/";
            File fileDir = new File(pat + sqlPath);
            if (!fileDir.exists()) { //如果不存在 则创建
                fileDir.mkdirs();
            }
            String path = pat + sqlPath + myFileName;
            File localFile = new File(path);
            try {
                file.transferTo(localFile);
                map.put("path", path);
                //将文件路径存储到数据库
                Report report = new Report();

                report.setRe_location(path);
                report.setStu_no(stu_no);
                report.setUpload_date(new Date());
                report.setTea_no(tea_no);
                reportService.insertReport(report);
                return map;
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件为空");
        }
        return map;
    }

    @RequestMapping(value = "/getGrade", method = RequestMethod.POST)
    public List<Grade> getGrade(@RequestBody int stu_no) {
        return gradeService.selectByStu_no(stu_no);
    }
    @RequestMapping(value = "/getTeachers", method = RequestMethod.POST)
    public List<Teacher> getTeachers() {
        return teacherService.selectAll();
    }
}
