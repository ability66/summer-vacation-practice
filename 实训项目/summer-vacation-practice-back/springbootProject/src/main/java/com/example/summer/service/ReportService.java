package com.example.summer.service;

import com.example.summer.entity.Report;
import com.example.summer.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportMapper reportMapper;

    public void insertReport(Report report) {
        int stu_no = report.getStu_no();
        int tea_no = report.getTea_no();
        String re_location = report.getRe_location();
        Date upload_date = new Date();
        reportMapper.insertReport(stu_no, tea_no, re_location, upload_date);
    }

    public List<Report> selectByTea_no(int tea_no) {
        return reportMapper.selectByTea_no(tea_no);
    }
    public void deleteReportByStu_noAndTea_no(int stu_no,int tea_no){
        reportMapper.deleteReportByStu_noAndTea_no(stu_no,tea_no);
    }
    public List<Report> selectByStu_nos(int[] stu_nos) {
        return reportMapper.selectByStu_nos(stu_nos);
    }

    public String selctByStu_noAndTea_no(int stu_no, int tea_no) {
        return reportMapper.selectByStu_noAndTea_no(stu_no, tea_no);
    }

    public Report getReportByStu_noAndTea_no(int stu_no, int tea_no) {
        return reportMapper.getReportByStu_noAndTea_no(stu_no, tea_no);
    }

    public List<Report> getAllFileLocations() {
        return reportMapper.getAllFileLocations();
    }
}
