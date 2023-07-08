package com.example.summer.entity;

public class ClassTable {
    private int class_no;// '班级号',
    private int class_order;//'第几节课',
    private String class_weekday;// '周几',
    private int sub_no;// '课程号',
    private int tea_no;//'教师工号',

    public int getClass_no() {
        return class_no;
    }

    public void setClass_no(int class_no) {
        this.class_no = class_no;
    }

    public int getClass_order() {
        return class_order;
    }

    public void setClass_order(int class_order) {
        this.class_order = class_order;
    }

    public String getClass_weekday() {
        return class_weekday;
    }

    public void setClass_weekday(String class_weekday) {
        this.class_weekday = class_weekday;
    }

    public int getSub_no() {
        return sub_no;
    }

    public void setSub_no(int sub_no) {
        this.sub_no = sub_no;
    }

    public int getTea_no() {
        return tea_no;
    }

    public void setTea_no(int tea_no) {
        this.tea_no = tea_no;
    }

    @Override
    public String toString() {
        return "ClassTable{" +
                "class_no=" + class_no +
                ", class_order=" + class_order +
                ", class_weekday='" + class_weekday + '\'' +
                ", sub_no=" + sub_no +
                ", tea_no=" + tea_no +
                '}';
    }
}
