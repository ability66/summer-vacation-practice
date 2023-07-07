package com.example.summer.service;

import com.example.summer.entity.Report;
import com.example.summer.mapper.ReportMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportMapper reportMapper;
    public void insertReport(int stu_no, int tea_no, String re_location, Date datetime){
        reportMapper.insertReport(stu_no,tea_no,re_location,datetime);
    }
    public List<Report> selectByStu_nos(int[] stu_nos){
        return reportMapper.selectByStu_nos(stu_nos);
    }
}
