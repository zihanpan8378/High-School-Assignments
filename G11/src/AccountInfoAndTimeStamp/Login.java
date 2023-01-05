/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountInfoAndTimeStamp;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author 44869
 */
public class Login extends Account {

    Calendar cal = Calendar.getInstance();
    Date date = cal.getTime();

    Login(String u, String p) {
        super(u, p);
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + getDate();
    }

}

class testLogin {

    public static void main(String[] args) {
        Login l = new Login("qwer", "1234");
        System.out.println(l);

    }
}
