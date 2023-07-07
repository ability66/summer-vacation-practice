package com.example.summer.mapper;

import com.example.summer.entity.Report;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface ReportMapper {
    void insertReport(int stu_no, int tea_no, String re_location, Date datetime);
    List<Report> selectByStu_nos(int[] stu_nos);
}
