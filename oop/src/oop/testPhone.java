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
public class testPhone {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        Phone p = new Phone();
        
    System.out.println("Phone 1");
    System.out.print("Enter storageSize: ");
    int le = in.nextInt();
        p.setStorageSize1(le);
    System.out.print("Enter yearRelease: ");
    int lz = in.nextInt();
        p.setYearRelease1(lz);
    System.out.print("Enter price: ");
    int lx = in.nextInt();
        p.setPrice1(lx);
    System.out.print("Enter model: ");
    String la = in.next();
    p.setPhone1(la);
    
    
    
    System.out.println("Phone 2");
   
    System.out.print("Enter storageSize: ");
    int lb = in.nextInt();
        p.setStorageSize2(lb);
    System.out.print("Enter yearRelease: ");
    int lv = in.nextInt();
        p.setYearRelease2(lv);
    System.out.print("Enter price: ");
    int lq = in.nextInt();
        p.setPrice2(lq);
    System.out.print("Enter model: ");
    String lc = in.next();
    p.setPhone2(lc);
    
    
    
    System.out.println("Phone 3");
    System.out.print("Enter storageSize: ");
    int ld = in.nextInt();
        p.setStorageSize3(ld);
    System.out.print("Enter yearRelease: ");
    int lw = in.nextInt();
        p.setYearRelease3(lw);
    System.out.print("Enter price: ");
    int lt = in.nextInt();
        p.setPrice3(lt);
    System.out.print("Enter model: ");
    String lf = in.next();
    p.setPhone3(lf);
    
    System.out.println();
    System.out.println("Phone with highest memory:" + p.getHighestmemory());
    System.out.println("Oldest phone:" + p.getOldest());
    System.out.println("Most expensive:" + p.getMostexpensive());
    }
}