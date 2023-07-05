package com.system.summervacationpractice.entity;

public class Teacher {
    private int tea_no     ;//'教师工号'
    private int tea_col_no ;//'学院号',
    private String tea_name   ;//'教师姓名',
    private String tea_level  ;//'教师职称'

    public int getTea_no() {
        return tea_no;
    }

    public void setTea_no(int tea_no) {
        this.tea_no = tea_no;
    }

    public int getTea_col_no() {
        return tea_col_no;
    }

    public void setTea_col_no(int tea_col_no) {
        this.tea_col_no = tea_col_no;
    }

    public String getTea_name() {
        return tea_name;
    }

    public void setTea_name(String tea_name) {
        this.tea_name = tea_name;
    }

    public String getTea_level() {
        return tea_level;
    }

    public void setTea_level(String tea_level) {
        this.tea_level = tea_level;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tea_no=" + tea_no +
                ", tea_col_no=" + tea_col_no +
                ", tea_name='" + tea_name + '\'' +
                ", tea_level='" + tea_level + '\'' +
                '}';
    }
}
