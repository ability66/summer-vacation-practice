package com.system.summervacationpractice.mapper;

import com.system.summervacationpractice.entity.Report;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ReportMapper {
    void insertReport(int stu_no, int tea_no, String re_location, Date datetime);
    List<Report> selectByStu_nos(@Param("stu_nos")int[] stu_nos);
}
