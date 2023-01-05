/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import java.util.Scanner;

/**
 *
 * @author 44869
 */
public class testPhone2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Phone2 A = new Phone2();
        Phone2 B = new Phone2();
        Phone2 C = new Phone2();

        System.out.println("Phone 1");
        System.out.print("Enter storageSize: ");
        int le = in.nextInt();
        A.setStorageSize(le);
        System.out.print("Enter yearRelease: ");
        int lz = in.nextInt();
        A.setYearRelease(lz);
        System.out.print("Enter price: ");
        int lx = in.nextInt();
        A.setPrice(lx);
        System.out.print("Enter model: ");
        String la = in.next();
        A.setPhone(la);

        System.out.println("Phone 2");

        System.out.print("Enter storageSize: ");
        int lb = in.nextInt();
        B.setStorageSize(lb);
        System.out.print("Enter yearRelease: ");
        int lv = in.nextInt();
        B.setYearRelease(lv);
        System.out.print("Enter price: ");
        int lq = in.nextInt();
        B.setPrice(lq);
        System.out.print("Enter model: ");
        String lc = in.next();
        B.setPhone(lc);

        System.out.println("Phone 3");
        System.out.print("Enter storageSize: ");
        int ld = in.nextInt();
        C.setStorageSize(ld);
        System.out.print("Enter yearRelease: ");
        int lw = in.nextInt();
        C.setYearRelease(lw);
        System.out.print("Enter price: ");
        int lt = in.nextInt();
        C.setPrice(lt);
        System.out.print("Enter model: ");
        String lf = in.next();
        C.setPhone(lf);

        {
            if (A.getStorageSize() > B.getStorageSize()) {
                if (C.getStorageSize() > A.getStorageSize()) {
                    System.out.println("Phone with highest memory:" + C.getPhone());
                } else if (C.getStorageSize() == A.getStorageSize()) {
                    System.out.println("Phone with highest memory:" + A.getPhone() + "and" + C.getPhone());
                } else {
                    System.out.println("Phone with highest memory:" + A.getPhone());
                }
            }
            if (B.getStorageSize() > A.getStorageSize()) {
                if (C.getStorageSize() > B.getStorageSize()) {
                    System.out.println("Phone with highest memory:" + C.getPhone());
                } else if (C.getStorageSize() == B.getStorageSize()) {
                    System.out.println("Phone with highest memory:" + B.getPhone() + "and" + C.getPhone());
                } else {
                    System.out.println("Phone with highest memory:" + B.getPhone());
                }
            }
            if (B.getStorageSize() == A.getStorageSize()) {
                if (C.getStorageSize() > B.getStorageSize()) {
                    System.out.println("Phone with highest memory:" + C.getPhone());
                } else if (C.getStorageSize() < B.getStorageSize()) {
                    System.out.println("Phone with highest memory:" + A.getPhone() + "and" + B.getPhone());
                } else {
                    System.out.println("Phone with highest memory:" + "same");
                }
            }
        }

        {
            if (A.getYearRelease() < B.getYearRelease()) {
                if (C.getYearRelease() < A.getYearRelease()) {
                    System.out.println("Oldest phone::" + C.getPhone());
                } else if (C.getYearRelease() == A.getYearRelease()) {
                    System.out.println("Oldest phone::" + A.getPhone() + "and" + C.getPhone());
                } else {
                    System.out.println("Oldest phone::" + A.getPhone());
                }
            }
            if (B.getYearRelease() < A.getYearRelease()) {
                if (C.getYearRelease() < B.getYearRelease()) {
                    System.out.println("Oldest phone::" + C.getPhone());
                } else if (C.getYearRelease() == B.getYearRelease()) {
                    System.out.println("Oldest phone::" + B.getPhone() + "and" + C.getPhone());
                } else {
                    System.out.println("Oldest phone::" + B.getPhone());
                }
            }
            if (B.getYearRelease() == A.getYearRelease()) {
                if (C.getYearRelease() < B.getYearRelease()) {
                    System.out.println("Oldest phone::" + C.getPhone());
                } else if (C.getYearRelease() > B.getYearRelease()) {
                    System.out.println("Oldest phone::" + A.getPhone() + "and" + B.getPhone());
                } else {
                    System.out.println("Oldest phone::" + "same");
                }
            }
        }

        {
            if (A.getPrice() > B.getPrice()) {
                if (C.getPrice() > A.getPrice()) {
                    System.out.println("Most expensive:" + C.getPhone());
                } else if (C.getPrice() == A.getPrice()) {
                    System.out.println("Most expensive:" + A.getPhone() + "and" + C.getPhone());
                } else {
                    System.out.println("Most expensive:" + A.getPhone());
                }
            }
            if (B.getPrice() > A.getPrice()) {
                if (C.getPrice() > B.getPrice()) {
                    System.out.println("Most expensive:" + C.getPhone());
                } else if (C.getPrice() == B.getPrice()) {
                    System.out.println("Most expensive:" + B.getPhone() + "and" + C.getPhone());
                } else {
                    System.out.println("Most expensive:" + B.getPhone());
                }
            }
            if (B.getPrice() == A.getPrice()) {
                if (C.getPrice() > B.getPrice()) {
                    System.out.println("Most expensive:" + C.getPhone());
                } else if (C.getPrice() < B.getPrice()) {
                    System.out.println("Most expensive:" + A.getPhone() + "and" + B.getPhone());
                } else {
                    System.out.println("Most expensive:" + "same");
                }
            }
        }
    }
}

