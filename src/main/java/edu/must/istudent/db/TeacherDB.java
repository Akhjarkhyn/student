/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.must.istudent.db;

import edu.must.istudent.entity.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HiTech
 */
public class TeacherDB {

    public static Boolean insertScore(String lessonCode, String studentCode, int dun) {

        Boolean ret = false;
        String sql = "INSERT INTO score(student_code, subject_code, score) VALUES(?,?,?)";
        System.out.println(sql);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = DB.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, studentCode);
            ps.setString(2, lessonCode);
            ps.setInt(3, dun);
            ps.executeUpdate();
            ret = true;
        } catch (SQLException ex) {
            System.out.println("Exception insertScore| " + ex.getMessage());
        } finally {
            DB.closeConnection(conn);
        }

        return ret;
    }

    public static String validate(String username, String password) {
        Teacher t = get(username);
        String str = "";
        if(t.getFirst_name() == null){
            str =  "user does not exists";
        } else if (!password.equals(t.getPassword())){
            str = "Invalid Password";
        } else str="ok";
        return str;
    }

    public static Teacher get(String id) {
        
        Teacher t = new Teacher();
        
        Boolean ret = false;
        String sql = "SELECT * FROM teacher WHERE teacher_id = ?";
        System.out.println(sql);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
 
        conn = DB.getConnection();
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                t.setTeacher_id(rs.getString("teacher_id"));
                t.setFirst_name(rs.getString("First_name"));
                t.setLast_name(rs.getString("Last_name"));
                t.setMobile(rs.getInt("mobile"));
                t.setDate_of_birth(rs.getDate("date_of_birth"));
                t.setSubject(rs.getString("subject"));
                t.setPassword(rs.getString("password"));
            }           
        } catch (SQLException ex) {
            System.out.println("Exception validate| " + ex.getMessage());
        } finally {
            DB.closeConnection(conn);
        }
 
        return t;
    }
    
    public static boolean updatePassword(String id,String pass) {
        
        Boolean ret = false;
        String sql = "update `teacher` set password = ? where teacher_id = ?";
        System.out.println(sql);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = DB.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, id);
            ps.executeUpdate();
            ret = true;
        } catch (SQLException ex) {
            System.out.println("Exception insertScore| " + ex.getMessage());
        } finally {
            DB.closeConnection(conn);
        }

        return ret;
    }
    

}
