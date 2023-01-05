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
public class AccountDatabase {

    Account[] accounts;

    public AccountDatabase(Account[] accounts) {
        this.accounts = accounts;
    }

    public AccountDatabase() {
        this.accounts = new Account[3];
    }

    /*public void setAccounts() {
        accounts[0] = new Account("rem", "12345");
        accounts[1] = new Account("r0m", "12345");
        accounts[2] = new Account("rim", "12345");

    }

    public Account[] getAccounts() {
        return accounts;
    }*/

    public void printDB() {
        System.out.println("DATABASE"
                + "\nUsearname\tPassword");
        for (Account a : accounts) {
            if (a != null ){
                System.out.println(a);
            }
        }
    }
}
