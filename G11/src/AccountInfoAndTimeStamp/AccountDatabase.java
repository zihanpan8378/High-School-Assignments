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
public class AccountDatabase {

    Account[] a = new Account[10];
    int count = 0;

    public void setDatabace(String un, String pw) {
        if (count < this.a.length) {
            a[count] = new Account(un, pw);
            count++;
        } else {
            System.out.println("Out of range");
        }
    }

    @Override
    public String toString() {
        String print = "";
        for (int i = 0; i < a.length; i++) {
            if(a[i]!=null){
            print += a[i].username + "\t" + a[i].password + "\n";}
        }
        return print;
    }

}
