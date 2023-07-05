package com.system.summervacationpractice.entity;

public class Class {
    private int class_no;//'班级号'
    private int ter_no  ;//'专业号'
    private int co_no   ;//'学院号'

    public int getClass_no() {
        return class_no;
    }

    public void setClass_no(int class_no) {
        this.class_no = class_no;
    }

    public int getTer_no() {
        return ter_no;
    }

    public void setTer_no(int ter_no) {
        this.ter_no = ter_no;
    }

    public int getCo_no() {
        return co_no;
    }

    public void setCo_no(int co_no) {
        this.co_no = co_no;
    }

    @Override
    public String toString() {
        return "Class{" +
                "class_no=" + class_no +
                ", ter_no=" + ter_no +
                ", co_no=" + co_no +
                '}';
    }
}
