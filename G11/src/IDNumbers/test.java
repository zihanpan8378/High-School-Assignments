/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDNumbers;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StudentAccounts sa = new StudentAccounts();
        int choice1, choice2;
        do {
            System.out.print("1 - add"
                    + "\n2 - remove"
                    + "\n3 - edit"
                    + "\n4 - sort"
                    + "\n5 - display"
                    + "\n0 - quit"
                    + "\n>>");
            choice1 = in.nextInt();

            if (choice1 == 1) {
                System.out.print("Enter first name: ");
                String fName = in.next();
                System.out.print("Enter middle name: ");
                String mName = in.next();
                System.out.print("Enter last name: ");
                String lName = in.next();
                sa.add(new IDNumber(fName, mName, lName));
            } else if (choice1 == 2) {
                System.out.print("Enter ID: ");
                String ID = in.next();
                sa.remove(ID);
            } else if (choice1 == 3) {
                System.out.print("Enter ID: ");
                String ID = in.next();
                System.out.print("Which one are you going to update?"
                        + "\n1 - first name"
                        + "\n2 - middle name"
                        + "\n3 - last name"
                        + "\n>>");
                choice2 = in.nextInt();
                System.out.print("Enter new name: ");
                String newName = in.next();
                sa.edit(ID, choice2, newName);
            } else if (choice1 == 4) {
                System.out.print("How do you want to sort?"
                        + "\n1 - by first name"
                        + "\n2 - by middle name"
                        + "\n3 - by last name"
                        + "\n>>");
                choice2 = in.nextInt();
                sa.boobleSort(sa.ids, choice2);
            } else if (choice1 == 5) {
                sa.display(sa.ids);
            } else if (choice1 == 0) {
                break;
            } else {
                System.out.println("Wrong choice!");
            }
        } while (choice1 != 0);
    }
}
