package com.example.summer.entity;

public class College {
    private int co_no  ;//'学院号'
    private String co_name;//'学院名'

    public int getCo_no() {
        return co_no;
    }

    public void setCo_no(int co_no) {
        this.co_no = co_no;
    }

    public String getCo_name() {
        return co_name;
    }

    public void setCo_name(String co_name) {
        this.co_name = co_name;
    }

    @Override
    public String toString() {
        return "College{" +
                "co_no=" + co_no +
                ", co_name='" + co_name + '\'' +
                '}';
    }
}
