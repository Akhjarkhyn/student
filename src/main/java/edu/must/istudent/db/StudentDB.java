/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.must.istudent.db;

import edu.must.istudent.entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HiTech
 */
public class StudentDB {

    public static Boolean validate(String username, String password) {

        Boolean ret = false;
        String sql = "SELECT * FROM student WHERE Student_code = ? AND password = ?";
        System.out.println(sql);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = DB.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                ret = true;
            }
        } catch (SQLException ex) {
            System.out.println("Exception validate| " + ex.getMessage());
        } finally {
            DB.closeConnection(conn);
        }

        return ret;
    }

    public static Student populate(String username) {
        Student ret = new Student();
        String sql = "SELECT * FROM student WHERE Student_code = ?";
        System.out.println(sql);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = DB.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                ret.setStudentCode(username);
                ret.setFirstName(rs.getString("First_name"));
                ret.setLastName(rs.getString("Last_name"));
                ret.setPassword(rs.getString("password"));
                ret.setDateOfBirth(rs.getDate("date_of_birth"));
                ret.setCurrent_studying_subject(rs.getString("current_studing_subjects"));
            }
        } catch (SQLException ex) {
            System.out.println("Exception populate| " + ex.getMessage());
        } finally {
            DB.closeConnection(conn);
        }
        //ret.toString();
        return ret;
    }

    public static Boolean changePassword(String newpass, String studentCode) {
        Boolean ret = false;
        String sql = "UPDATE student SET password = ? WHERE Student_code = ?";
        System.out.println(sql);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = DB.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, newpass);
            ps.setString(2, studentCode);
            ps.executeUpdate();
            ret = true;
        } catch (SQLException ex) {
            System.out.println("Exception populate| " + ex.getMessage());
        } finally {
            DB.closeConnection(conn);
        }
        return ret;
    }

    public static void test() {
        String sql = "Select * from student where Last_name='Gantumur'";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = DB.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            System.out.println("rs" + rs);
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println("Exception validate| " + ex);
        } finally {
            DB.closeConnection(conn);
        }

    }
}
