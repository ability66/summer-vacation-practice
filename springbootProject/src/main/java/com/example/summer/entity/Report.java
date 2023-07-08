package com.example.summer.entity;

import java.util.Date;

public class Report {
    private int re_no;//'报告号'
    private int stu_no;//'学号',
    private int tea_no;//'教师工号',
    private String re_location;//'文件地址（相对）',
    private Date upload_date;//'上传时间',

    public int getRe_no() {
        return re_no;
    }

    public void setRe_no(int re_no) {
        this.re_no = re_no;
    }

    public int getStu_no() {
        return stu_no;
    }

    public void setStu_no(int stu_no) {
        this.stu_no = stu_no;
    }

    public int getTea_no() {
        return tea_no;
    }

    public void setTea_no(int tea_no) {
        this.tea_no = tea_no;
    }

    public String getRe_location() {
        return re_location;
    }

    public void setRe_location(String re_location) {
        this.re_location = re_location;
    }

    public Date getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(Date upload_date) {
        this.upload_date = upload_date;
    }

    @Override
    public String toString() {
        return "Report{" +
                "re_no=" + re_no +
                ", stu_no=" + stu_no +
                ", tea_no=" + tea_no +
                ", re_location='" + re_location + '\'' +
                ", upload_date=" + upload_date +
                '}';
    }
}
