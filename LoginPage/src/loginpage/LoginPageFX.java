/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author 44869
 */
public class LoginPageFX extends Application {

    Label lblPassword, lblUserName, lblResult;
    TextField txtPassword, txtUserName;
    Button btnEnter, btnSwitchBack;
    Scene senLogin, senSuccess;
    GridPane panLogin, panSuccess;
    Stage stage;
    PasswordField pwf;

    Connection myconObj = null;
    Statement mystatObj = null;
    ResultSet myresObj = null;
    ResultSetMetaData mymeta = null;

    public void connectWithDatabase() {
        try {
            myconObj = DriverManager.getConnection("jdbc:derby://localhost:1527/LoginPage", "Zihan", "123456");
            mystatObj = myconObj.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            
        }
    }

    public LoginPageFX() {
        lblPassword = new Label("Password");                
        lblUserName = new Label("User Name");
        lblResult = new Label("");
        pwf = new PasswordField();
        txtPassword = new TextField("");
        txtUserName = new TextField("");
        btnEnter = new Button("Enter");
        btnSwitchBack = new Button("Switch to database");
        panLogin = new GridPane();
        panSuccess = new GridPane();
        
        connectWithDatabase();
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        btnEnter.setOnAction(e -> btnEnter());
        btnSwitchBack.setOnAction(e -> btnSwitchBack());

        panLogin.setHgap(10);
        panLogin.setVgap(10);
        panSuccess.setHgap(10);
        panSuccess.setVgap(10);
        panLogin.setAlignment(Pos.CENTER);
        panSuccess.setAlignment(Pos.CENTER);

        panLogin.addRow(0, lblUserName, txtUserName);
        panLogin.addRow(1, lblPassword, txtPassword);
        panLogin.addRow(2, lblResult);
        panLogin.addRow(3, btnEnter);

        panSuccess.addRow(2, btnSwitchBack);

        senLogin = new Scene(panLogin, 500, 500);
        senSuccess = new Scene(panSuccess, 500, 500);

        primaryStage.setTitle("LoginPage");
        primaryStage.setScene(senLogin);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public boolean check(String un, String pw) {
        boolean result = false;
        try {
            myresObj = mystatObj.executeQuery("Select * from Zihan.untitled");
            //mystatObj.executeUpdate("insert into Untitled values('"+un+"','"+pw+"')");
            PreparedStatement st = myconObj.prepareStatement("insert into untitled(username, password)values(?,?)");
            st.setString(1, un);
            st.setString(2, pw);
            int a = st.executeUpdate();
            if (a>0) {
                System.out.println("Row Update");
            }
            
            
            /*while (myresObj.next() == true) {
                String userName = myresObj.getString(1);
                String password = myresObj.getString(2);
                
                System.out.println(userName + "\t" + password);
                System.out.println(un + "\t" + pw);
                
                if (un.equals(userName) && pw.equals(password)) {
                    result = true;
                    break;
                }
            }*/
        } catch (SQLException e) {
        }
        return result;
    }

    public void btnEnter() {
        if (txtUserName.getText().equals("") || txtPassword.getText().equals("")) {
        } else {
            String userName, password;
            userName = txtUserName.getText();
            password = txtPassword.getText();
            boolean enter = check(userName, password);
            if (enter == true) {
                stage.setScene(senSuccess);
                stage.show();
            } else {
                lblResult.setText("Wrong username or password");
                txtUserName.setText("");
                txtPassword.setText("");
            }
        }
    }

    private void btnSwitchBack() {
        stage.setScene(senLogin);
        stage.show();
        lblResult.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
    }

}
