/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JISEmployee;

/**
 *
 * @author 44869
 */
public class Staff extends JISEmployee {

    double hourlyPayRate;

    Staff(String f, String l, double p) {
        super(f, l);
        hourlyPayRate = p;
    }

    public double getRate() {
        return hourlyPayRate;
    }

    @Override
    double pay(double period) {
        if (period <= 40) {
            return ((int)((hourlyPayRate * period)*100))*0.01;
        } else {
            return ((int)((hourlyPayRate * ((period - 40) * 1.5 + 40))*100))*0.01;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Staff\n"
                + "Hourly Rate, $" + getRate();
    }

    public static void main(String[] args) {
        Staff s = new Staff("Sergey", "Brin", 10);
        System.out.println(s);
        System.out.println("Sample 35-hour worked pay: " + s.pay(35));
        System.out.println("Sample 40-hour worked pay: " + s.pay(40));
        System.out.println("Sample 42-hour worked pay: " + s.pay(42));

    }

}
