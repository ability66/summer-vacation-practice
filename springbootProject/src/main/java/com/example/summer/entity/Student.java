package com.example.summer.entity;

public class Student {
    private int stu_no;
    private String stu_name;
    private String stu_sex;
    private int stu_year;
    private int ter_no;

    public int getStu_no() {
        return stu_no;
    }

    public void setStu_no(int stu_no) {
        this.stu_no = stu_no;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_sex() {
        return stu_sex;
    }

    public void setStu_sex(String stu_sex) {
        this.stu_sex = stu_sex;
    }

    public int getStu_year() {
        return stu_year;
    }

    public void setStu_year(int stu_year) {
        this.stu_year = stu_year;
    }

    public int getTer_no() {
        return ter_no;
    }

    public void setTer_no(int ter_no) {
        this.ter_no = ter_no;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_no=" + stu_no +
                ", stu_name='" + stu_name + '\'' +
                ", stu_sex='" + stu_sex + '\'' +
                ", stu_year=" + stu_year +
                ", ter_no=" + ter_no +
                '}';
    }
}

