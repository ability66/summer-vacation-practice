package com.example.summer.controller;

import com.example.summer.service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
@Slf4j
public class ClassController {
    @Autowired
    ClassService classService;

}
