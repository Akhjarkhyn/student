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
public class Student {

    private String studentCode;
    private String firstName;
    private String lastName;
    private String password;
    private Date dateOfBirth;
    private String current_studying_subject;

    public Student() {
    }

    public Student(String studentCode, String firstName, String lastName, String password, Date dateOfBirth, String current_studying_subject) {
        this.studentCode = studentCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.current_studying_subject = current_studying_subject;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCurrent_studying_subject() {
        return current_studying_subject;
    }

    public void setCurrent_studying_subject(String current_studying_subject) {
        this.current_studying_subject = current_studying_subject;
    }

    @Override
    public String toString() {
        return "Student{" + "studentCode=" + studentCode + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", current_studying_subject=" + current_studying_subject + '}';
    }

}
