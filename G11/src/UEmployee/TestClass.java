/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UEmployee;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class TestClass {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1 - UEmployee" + "\n2 - Faculty" + "\n3 - Staff");
            System.out.println("Enter your choice");
            choice = input.nextInt();
            System.out.println("Enter name: ");
            String name = input.next();
            System.out.println("Enter salary: ");
            double salary = input.nextDouble();
            if (choice == 1) {
                UEmployee ue;

                ue = new UEmployee(name, salary);
                System.out.println(ue);
            } else if(choice == 2){
                Faculty f;
                System.out.println("Enter department: ");
                String department = input.next();
                f = new Faculty(name, salary, department);
            }
            else if(choice == 3){
                Staff s;
                System.out.println("Enter job title: ");
                String jobTitle = input.next();
                s = new Staff(name, salary, jobTitle);
            }
        } while (choice != 0);
    }
}
