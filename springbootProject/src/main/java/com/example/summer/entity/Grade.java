package com.example.summer.entity;

public class Grade {
    private int stu_no;//'学号',
    private int sub_no;//'课程号',
    private double grade;// '成绩',

    public int getStu_no() {
        return stu_no;
    }

    public void setStu_no(int stu_no) {
        this.stu_no = stu_no;
    }

    public int getSub_no() {
        return sub_no;
    }

    public void setSub_no(int sub_no) {
        this.sub_no = sub_no;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "stu_no=" + stu_no +
                ", sub_no=" + sub_no +
                ", grade=" + grade +
                '}';
    }
}
