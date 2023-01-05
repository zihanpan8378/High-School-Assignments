/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankApp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class Bank {

    ArrayList<Account> list = new ArrayList();
    Scanner in = new Scanner(System.in);

    Bank() {
        addAccount("Mathew", "Smith", 120104, 1000000);
        addAccount("Jenny", "Lee", 234123, 500500);
        addAccount("Maria", "Gomez", 455500, 2000001);
    }

    public void sort(ArrayList<Account> list) {
        boolean changed;
        int len = list.size();
        Account temp = list.get(0);
        do {
            changed = false;
            len--;
            for (int i = 0; i < len; i++) {
                if (list.get(i).getlName().compareTo(list.get(i + 1).getlName()) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    changed = true;
                }
            }
        } while (changed);
    }

    public static void boobleSort(ArrayList<Account> list, int choice) {
        for (int i = 0; i < (list.size() - 1); i++) {
            for (int k = 1; k < (list.size() - i); k++) {
                boolean check = true;
                if (choice == 1) {
                    if (list.get(k - 1).lName.compareTo(list.get(k).lName) > 0) {
                        check = false;
                    }
                } else if (choice == 2) {
                    if (list.get(k - 1).fName.compareTo(list.get(k).fName) > 0) {
                        check = false;
                    }
                } else if (choice == 3) {
                    if (list.get(k - 1).age > list.get(k).age) {
                        check = false;
                    }
                }
                if (check == false) {
                    Account temp = list.get(k - 1);
                    list.set(k - 1, list.get(k));
                    list.set(k, temp);
                }
            }
        }
    }

    public void addAccount(String fName, String lName, int num, double balance) {
        int i;
        for (i = 0; i < list.size(); i++) {
            if (list.get(i).getaNum() == num) {
                break;
            }
        }
        if (i == list.size()) {
            list.add(new Account(fName, lName, num, balance));
        } else {
            System.out.println("\t\tthe account is already here!!");
        }

    }

    public void displayDatabace() {
        sort(list);
        System.out.println("\t\tAcctnum\tfName\tlName\tBalance");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\t\t" + list.get(i));
        }
    }

    public void deleteAccount(int num) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getaNum() == num) {
                int c;
                do {
                    System.out.print("\t\tAre you sure you want to delete this account(1-Y|2-N)?");
                    c = in.nextInt();
                    if (c == 1) {
                        list.remove(i);
                        System.out.println("\t\tAccount deleted successfully...");
                    } else if (c == 2) {
                        System.out.println("\t\tDoesn't delet");
                    } else {
                        System.out.println("\t\tWrong choice!!");
                    }
                } while (c != 1 && c != 2);
            }
        }
    }

    public void editAccount(int num) {
        int i;
        for (i = 0; i < list.size(); i++) {
            if (list.get(i).getaNum() == num) {
                break;
            }
        }
        if (i == list.size()) {
            System.out.println("\t\tCannot find account number " + num);
        } else {
            System.out.print("\t\tEnter new first name: ");
            String fName = in.next();
            System.out.print("\t\tEnter new last name: ");
            String lName = in.next();
            list.get(i).fName = fName;
            list.get(i).lName = lName;
            System.out.println("\t\tAccount info updated successfully...");
        }
    }

    public void accountInfo(int num) {
        int i;
        for (i = 0; i < list.size(); i++) {
            if (list.get(i).getaNum() == num) {
                break;
            }
        }
        if (i == list.size()) {
            System.out.println("\t\tCannot find account number " + num);
        } else {
            System.out.println("\t\tAcctnum\tfName\tlName\tBalance");
            System.out.println("\t\t" + list.get(i));
        }
    }

    public void inquiry(int num) {
        int i;
        for (i = 0; i < list.size(); i++) {
            if (list.get(i).getaNum() == num) {
                break;
            }
        }
        if (i == list.size()) {
            System.out.println("\t\tCannot find account number " + num);
        } else {
            System.out.println("\t\tCurrent balance: " + list.get(i).getaBalance());
        }
    }

    public void withDraw(int num) {
        int i;
        for (i = 0; i < list.size(); i++) {
            if (list.get(i).getaNum() == num) {
                break;
            }
        }
        if (i == list.size()) {
            System.out.println("\t\tCannot find account number " + num);
        } else {
            System.out.print("\t\tEnter amount to withdraw: ");
            double withdraw = in.nextDouble();
            if (withdraw >= list.get(i).aBalance) {
                System.out.println("\t\tWithdrawal exceeds current balance!");
            } else {
                list.get(i).aBalance -= withdraw;
                System.out.println();
                System.out.println("\t\tCurrent balance: "
                        + list.get(i).getaBalance()
                        + "\t\tWithdraw successful\n"
                        + "\t\tPlease take your money…");
            }
        }
    }

    public void deposit(int num) {
        int i;
        for (i = 0; i < list.size(); i++) {
            if (list.get(i).getaNum() == num) {
                break;
            }
        }
        if (i == list.size()) {
            System.out.println("\t\tCannot find account number " + num);
        } else {
            System.out.print("\t\tEnter amount to deposit: ");
            double deposit = in.nextDouble();
            list.get(i).aBalance += deposit;
            System.out.println("\t\tCurrent balance: " + list.get(i).getaBalance());
            System.out.println("\t\tMoney successfully deposited");
        }
    }
}
