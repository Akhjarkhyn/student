/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.must.istudent.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HiTech
 */
public class DB {

    public  static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Database!");
        } catch (SQLException ex) {
            System.out.println("Oops Error! SQLException | " + ex);
        }
        return conn;
    }
    
    public  static void closeConnection(Connection connection) {
        if(connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed!");
            } catch (SQLException ex) {
                System.out.println("Exception closeConnection| " + ex);
            }
        }
    }
    
    
}
