/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hanoi;

/**
 *
 * @author 44869
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Updater {

    public static void main(String args[]) throws SQLException {
        Connection myconObj = null;
        Statement mystatObj = null;
        ResultSet myresObj = null;

        myconObj = DriverManager.getConnection("jdbc:derby://localhost:1527/3DTic-Tac-Toe", "Zihan", "Pzhwl0207!");
        mystatObj = myconObj.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        myresObj = mystatObj.executeQuery("Select * from Zihan.USERINFORMATION");

        while (myresObj.next()) {

            //Updating the salary
            myresObj.updateString(1, "Tim");
            //Updating the address
            myresObj.updateInt(3, 2);
            //Updating the row
            myresObj.updateRow();

        }
        myresObj.beforeFirst();

    }
}
