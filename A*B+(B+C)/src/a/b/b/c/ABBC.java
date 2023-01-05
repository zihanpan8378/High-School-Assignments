/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.b.b.c;

/**
 *
 * @author 44869
 */
public class ABBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    System.out.print("(0*0)+(0*0)'*0' = ");
    System.out.println((false && false) || !(false && false) && !(false));

    System.out.print("(0*0)+(0*1)'*1' = ");
    System.out.println((false && false) || !(false && true) && !(true));

    System.out.print("(0*1)+(1*0)'*0' = ");
    System.out.println((false && true) || !(true && false) && !(false));

    System.out.print("(0*1)+(1*1)'*1' = ");
    System.out.println((false && true) || !(true && true) && !(true));
    
    System.out.print("(1*0)+(0*0)'*0' = ");
    System.out.println((true && false) || !(false && false) && !(false));

    System.out.print("(1*0)+(0*1)'*1' = ");
    System.out.println((true && false) || !(false && true) && !(true));

    System.out.print("(1*1)+(1*0)'*0' = ");
    System.out.println((true && true) || !(true && false) && !(false));

    System.out.print("(1*1)+(1*1)'*1' = ");
    System.out.println((true && true) || !(true && true) && !(true));
    }
    
}
