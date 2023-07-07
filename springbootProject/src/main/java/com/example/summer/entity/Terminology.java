package com.example.summer.entity;

public class Terminology {
    private int ter_no;//'专业号'
    private String ter_name;//'专业名称'

    public int getTer_no() {
        return ter_no;
    }

    public void setTer_no(int ter_no) {
        this.ter_no = ter_no;
    }

    public String getTer_name() {
        return ter_name;
    }

    public void setTer_name(String ter_name) {
        this.ter_name = ter_name;
    }

    @Override
    public String toString() {
        return "Terminology{" +
                "ter_no=" + ter_no +
                ", ter_name='" + ter_name + '\'' +
                '}';
    }
}
