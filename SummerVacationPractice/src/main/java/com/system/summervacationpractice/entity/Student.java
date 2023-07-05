package com.system.summervacationpractice.entity;

import java.time.Year;

public class Student {
    private int stu_no;
    private String stuname;
    private String stusex;
    private int stuyear;
    private int terno;

    public int getStu_no() {
        return stu_no;
    }

    public void setStu_no(int stu_no) {
        this.stu_no = stu_no;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex;
    }

    public int getStuyear() {
        return stuyear;
    }

    public void setStuyear(int stuyear) {
        this.stuyear = stuyear;
    }

    public int getTerno() {
        return terno;
    }

    public void setTerno(int terno) {
        this.terno = terno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_no=" + stu_no +
                ", stuname='" + stuname + '\'' +
                ", stusex='" + stusex + '\'' +
                ", stuyear=" + stuyear +
                ", terno=" + terno +
                '}';
    }
}

