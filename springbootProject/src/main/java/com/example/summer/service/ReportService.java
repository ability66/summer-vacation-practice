package com.example.summer.service;

import com.example.summer.entity.Report;
import com.example.summer.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    ReportMapper reportMapper;

    public void updateReport(Report report) {
        int stu_no=report.getStu_no();
        int tea_no= report.getTea_no();
        String re_location= report.getRe_location();
        Date date = new Date();

        reportMapper.insertReport(stu_no,tea_no,re_location,date);
    }

//    public List<Report> getReportByTea_no(int tea_no) {
//
//        return reportMapper.selectByStu_nos();
//    }
}
