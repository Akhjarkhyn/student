/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.must.istudent.entity;

import java.sql.Date;

/**
 *
 * @author HiTech
 */
public class Teacher {

    private String teacher_id;
    private String first_name;
    private String last_name;
    private Date date_of_birth;
    private int mobile;
    private String subject;
    private String password;

    public Teacher() {
    }

    public Teacher(String teacher_id, String first_name, String last_name,String password,int mobile,Date date_of_birth, String subject) {
        this.teacher_id = teacher_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.subject = subject;
        this.mobile = mobile;
        this.password = password;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMobile(){
        return mobile;
    }
    
    public void setMobile(int number){
        mobile = number;
    }
    
    public void setPassword(String pass){
        password = pass;
    }
    
    public String getPassword(){
        return password;
    }
    
    @Override
    public String toString() {
        return "Teacher{" + "teacher_id=" + teacher_id + ", first_name=" + first_name + ", last_name=" + last_name + ",Mobile=" + mobile + ", date_of_birth=" + date_of_birth + ", subject=" + subject + '}';
    }

}
