/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hanoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 44869
 */
public class DBHelper {

    static public String name = "com.mysql.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:3306/loginInfo?zeroDateTimeBehavior=convertToNull";

      public static final String user = "root";  
    public static final String password = "Pnsutm3986";  
 
    public Connection conn = null;  
    public PreparedStatement pst = null;  

    public DBHelper(String sql) {  
        try {  
            Class.forName(name);//指定连接类型  
            conn = (Connection) DriverManager.getConnection(url,user,password);//获取连接  
            pst = conn.prepareStatement(sql);//准备执行语句  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
 
    public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }
}