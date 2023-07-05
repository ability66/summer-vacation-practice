package com.system.summervacationpractice.entity;

public class Subject {
    private int sub_no  ;//'课程号'
    private int tea_no  ;//'教师工号',
    private String sub_name;//'课程名',

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

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "sub_no=" + sub_no +
                ", tea_no=" + tea_no +
                ", sub_name='" + sub_name + '\'' +
                '}';
    }
}
