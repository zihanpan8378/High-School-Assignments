/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JISEmployee;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author 44869
 */
public class Teacher extends JISEmployee {

    double yearlySalary;

    Teacher(String f, String l, double s) {
        super(f, l);
        yearlySalary = s;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    @Override
    double pay(double period) {
        return getYearlySalary() / 52 * period;
    }

    @Override
    public String toString() {
        return super.toString() + "Teacher\n"
                + "Yearly Salary, $" + getYearlySalary();
        
    }

    public static void main(String[] args) {
        NumberFormat nf = new DecimalFormat("0.00");
        Teacher t = new Teacher("Jack", "Dorsey", 70000);
        System.out.println(t);
        System.out.println("Sample 1-week pay: " + nf.format(t.pay(1)));
        System.out.println("Sample 4-week pay: " + t.pay(4));

    }

}
