/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginRecordNote;

import java.util.Date;

/**
 *
 * @author 44869
 */
public class Login {
    Account a;
    Date d;

    public Login(Account a) {
        this.a = a;
        d = new Date();
    }

    public Account getA() {
        return a;
    }

    public void setA(Account a) {
        this.a = a;
    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public String toString(){
        return a + "\t" + d;
    }
    
}
