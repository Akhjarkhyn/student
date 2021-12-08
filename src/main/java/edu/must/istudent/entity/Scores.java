/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.must.istudent.entity;

/**
 *
 * @author Akhjarkhyn
 */
public class Scores {
    private String st_code;
    private String sub_code;
    private int score;
    
    public Scores(){}

    public Scores(String studentCode, String subjectCode, int score){
        st_code = studentCode;
        sub_code = subjectCode;
        this.score = score;
    }
    
    public String getStudentCode(){
        return st_code;
    }
    
    public String getSubjectCode(){
        return sub_code;
    }
    
    public int getScore(){
        return score;
    }
}
