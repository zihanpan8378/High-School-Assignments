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
public class MentorTeacher extends Teacher {

    double yearlyMentoringAllowance;

    MentorTeacher(String f, String l, double s, double a) {
        super(f, l, s);
        yearlyMentoringAllowance = a;
    }

    double getYearlyMentoringAllowance() {
        return yearlyMentoringAllowance;
    }

    @Override
    double pay(double period) {
        return ((int) ((getYearlySalary() / 52 * period + getYearlyMentoringAllowance() / 52 * period) * 100)) * 0.01;
    }

    @Override
    public String toString() {
        return "JISEmployee\n" + super.getName() + ", " 
                + "Mentor Teacher\n" 
                + "Yearly Salary, $" + getYearlySalary()
                + "\nYearly Mentoring llowance, $" + getYearlyMentoringAllowance();
    }

    public static void main(String[] args) {
        MentorTeacher t = new MentorTeacher("Steve", "Wozniak", 70000, 10000);
        System.out.println(t);
        System.out.println("Sample 1-week pay: " + t.pay(1));
        System.out.println("Sample 4-week pay: " + t.pay(4));

    }
}
