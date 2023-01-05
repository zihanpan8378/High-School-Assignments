/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginRecordNote;

/**
 *
 * @author 44869
 */
public class Account {
    String userName;
    String password;

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passward) {
        this.password = passward;
    }

    public String toString(){
        return userName + "\t\t" + password;
    }
    
}
