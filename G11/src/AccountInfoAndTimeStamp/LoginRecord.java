/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountInfoAndTimeStamp;

/**
 *
 * @author 44869
 */
public class LoginRecord {

    AccountDatabase a = new AccountDatabase();
    Login[] l = new Login[10];
    int count = 0;

    public void addLoginToRecord(Login l) {
        if (verifyLogin(l.username, l.password) == true) {
            if (count < this.l.length) {
                this.l[count] = l;
                count++;
            } else {
                System.out.println("Out of range");
            }
        } else {

        }
    }

    public boolean verifyLogin(String u, String p) {
        boolean v = false;
        for (int i = 0; i < a.a.length; i++) {
            if (a.a[i] != null) {
                if (u.equals(a.a[i].username) && p.equals(a.a[i].password)) {
                    v = true;
                    break;
                }
            }
        }
        return v;
    }

    public void displayRecord(Login[] login) {
        System.out.println("Username\tPassword\tTimestamp");
        for (Login login1 : login) {
            if (login1 != null) {
                System.out.println(login1);
            }
        }
    }

}
