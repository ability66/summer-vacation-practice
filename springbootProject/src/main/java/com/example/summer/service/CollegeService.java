package com.example.summer.service;

import com.example.summer.mapper.CollegeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;

}
