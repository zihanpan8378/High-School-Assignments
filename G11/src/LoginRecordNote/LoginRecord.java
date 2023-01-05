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
public class LoginRecord {

    Login[] logins;
    int count;
    Login l;

    public LoginRecord() {
        logins = new Login[10];
        count = 0;
    }

    public void verifyLogin(Account a, Account[] accounts) {
        boolean t = false;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null
                    && a.getUserName().equalsIgnoreCase(accounts[i].getUserName())
                    && a.getPassword().equalsIgnoreCase(accounts[i].getPassword())) {
                if (count < logins.length) {
                    l = new Login(a);
                    logins[count] = l;
                    count++;
                    System.out.println("Account added to record...");
                    t = true;
                }
            }
        }
        if (t == false) {
            System.out.println("Usearname and Password don't match or exist!!!");
        }
    }

    public void printAllLogins() {
        int num = 0;
        System.out.println("Usearname\tPassword\tTimeStamp");
        for (Login lo : logins) {
            if (lo != null) {
                num++;
                System.out.println(lo);
            }
        }
        if (num == 0){
            System.out.println("No login record to show...");
        }
    }
}
