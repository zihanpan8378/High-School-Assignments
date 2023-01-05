/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessPhrase;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Game g = new Game();
        int choice1;
        String choice2;
        do {
            System.out.print("\n1 - phrase database"
                    + "\n2 - play"
                    + "\n0 - quit"
                    + "\n>> ");
            choice1 = in.nextInt();
            if (choice1 == 1) {
                do {
                    System.out.print("\n\tA - add phrase to list"
                            + "\n\tB - display list"
                            + "\n\tC - remove phrase from list"
                            + "\n\tQ - quit"
                            + "\n\t>> ");
                    choice2 = in.next().toLowerCase();
                    if (choice2.equals("a")) {
                        System.out.print("\t\tEnter new phrase: "
                                + "\n\t\t>> ");
                        String a = in.nextLine();
                        String phrase = in.nextLine();
                        g.d.add(new Phrase(phrase));
                    } else if (choice2.equals("b")) {
                        g.d.displayDatabase();
                    } else if (choice2.equals("c")) {
                        System.out.print("\t\tEnter the phrase you want to remove: ");
                        String a = in.nextLine();
                        String phrase = in.nextLine();
                        g.d.remove(phrase);
                    } else if (choice2.equals("q")) {
                        break;
                    } else {
                        System.out.println("\t\tWrong choice!");
                    }
                } while (choice2 != "q");
            } else if (choice1 == 2) {
                do {
                    System.out.print("\n\tG - guess"
                            + "\n\tQ - quit"
                            + "\n\t>> ");
                    choice2 = in.next().toLowerCase();
                    if (choice2.equals("g")) {
                        g.guess();
                    } else if (choice2.equals("q")) {
                        break;
                    } else {
                        System.out.println("\t\tWrong choice!");
                    }
                } while (choice2 != "q");
            } else if (choice1 == 0) {
                System.out.println("Thank you...");
                break;
            } else {
                System.out.println("\t\tWrong choice!");
            }
        } while (choice1 != 0);
    }
}
