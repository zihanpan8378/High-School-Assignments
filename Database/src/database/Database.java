/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 44869
 */
public class Database {

    public static void main(String[] args) {
        Connection myconObj = null;
        Statement mystatObj = null;
        ResultSet myresObj = null;
        ResultSetMetaData mymeta = null;
        String query = "Select * from Zihan.untitled";
        
        try {
            myconObj = DriverManager.getConnection("jdbc:derby://localhost:1527/LoginPage", "Zihan", "123456");
            mystatObj = myconObj.createStatement();
            myresObj = mystatObj.executeQuery(query);
            mymeta = myresObj.getMetaData();
            
            int columnNo = mymeta.getColumnCount();
            for (int i = 1; i <= columnNo; i++) {
                System.out.print(mymeta.getColumnName(i) + "\t");
            }
            System.out.println("");
            while (myresObj.next()) {
                for (int i = 1; i <= columnNo; i++) {
                    System.out.print(myresObj.getObject(i) + "\t\t");                    
                }
                System.out.println("");

                /*int id = myresObj.getInt("ID");//int id = myresObj.getInt(1);
                String name = myresObj.getString("Name");//String name = myresObj.getString(2);
                Date date = myresObj.getDate(3);
                String phone = myresObj.getString("PhoneNumber");
                System.out.println(id + "\t" + name + "\t" + date + "\t" + phone);*/

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
