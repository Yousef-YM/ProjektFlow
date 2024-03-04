/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.pf.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CC-Student
 */
public class DbConnection {
    private static String userName = "pm";
    private static String password = "pm";
    private static String dbUrl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
    
    
    public static Connection openConnection(){
         Connection conn = null;
        try {
           conn = DriverManager.getConnection(dbUrl, userName, password);
           conn.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }
    
    public static void main(String[] args) {
        openConnection();
    }
    
    
}








