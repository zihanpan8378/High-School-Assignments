/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dependencies;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author 44869
 */
public class TimeAndDate {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        System.out.println(date);
        
        Date now = new Date();
        System.out.println(now);
        
        cal.set(2050, 01, 12);
        Date after = cal.getTime();
        System.out.println(after);
    }
}
