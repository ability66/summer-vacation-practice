package com.system.summervacationpractice.entity;

public class User {
    private int user_id  ;//'用户编号'
    private String username ;//'用户名',
    private String password ;//'密码，用md5码存储',
    private String power    ;//'teacher/admin/student',
    private int tea_no   ;//'教师工号，为教师时填写',
    private int stu_no   ;//'学生学号，为学生时填写',

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public int getTea_no() {
        return tea_no;
    }

    public void setTea_no(int tea_no) {
        this.tea_no = tea_no;
    }

    public int getStu_no() {
        return stu_no;
    }

    public void setStu_no(int stu_no) {
        this.stu_no = stu_no;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", power='" + power + '\'' +
                ", tea_no=" + tea_no +
                ", stu_no=" + stu_no +
                '}';
    }
}
