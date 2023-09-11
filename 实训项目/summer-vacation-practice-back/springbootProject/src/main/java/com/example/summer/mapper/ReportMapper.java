package com.example.summer.mapper;

import com.example.summer.entity.Report;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportMapper {
    void insertReport(int stu_no, int tea_no, String re_location, Date upload_date);

    List<Report> selectByStu_nos(int[] stu_nos);

    String selectByStu_noAndTea_no(int stu_no, int tea_no);

    List<Report> getAllFileLocations();

    void deleteReportByStu_noAndTea_no(int stuNo, int teaNo);

    List<Report> selectByTea_no(int teaNo);

    Report getReportByStu_noAndTea_no(int stu_no, int tea_no);
}
