/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.must.istudent.entity;

/**
 *
 * @author HiTech
 */
public class Subject {

    private String subject_id;
    private String subject_name;
    private int credit;

    public Subject() {
    }

    public Subject(String subject_id, String subject_name, int credit) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.credit = credit;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Subject{" + "subject_id=" + subject_id + ", subject_name=" + subject_name + ", credit=" + credit + '}';
    }

}
