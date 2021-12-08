/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.must.istudent.db;

/**
 *
 * @author Akhjarkhyn
 */

import edu.must.istudent.entity.Scores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScoreDB {
    
    public static Object[][] getScoreList(String subject_id,String order){
        
        int n = getRow(subject_id);
        Object[][] list = new Object[n][3];
        
        String sql = "select * from score where subject_code = ? Order by " + order;
          
        System.out.println(sql);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DB.getConnection();
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, subject_id);
            rs = ps.executeQuery();
            int index = 0;
            while (rs.next()) {
                list[index][0] = rs.getString("student_code");
                list[index][1] = rs.getString("subject_code");
                list[index][2] = rs.getString("score");
                index++;
            }
        } catch (SQLException ex) {
            System.out.println("Exception validate| " + ex.getMessage());
        } finally {
            DB.closeConnection(conn);
        }
            return list;
    } 
    
    public static int getRow(String subject_id) {
        
        int ret = 0;
        String sql = "select count(*) from score where subject_code = ?";
        System.out.println(sql);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = DB.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, subject_id);
             rs = ps.executeQuery();
            while (rs.next()) {
                ret = rs.getInt("count(*)");
            }
        } catch (SQLException ex) {
            System.out.println("Exception insertScore| " + ex.getMessage());
        } finally {
            DB.closeConnection(conn);
        }
        return ret;
    }
    
    
    
}
