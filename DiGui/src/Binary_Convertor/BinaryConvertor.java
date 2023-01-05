/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Binary_Convertor;

/**
 *
 * @author 44485
 */
public class BinaryConvertor {

    public static void main(String[] args) {
        b(1234719);
        System.out.println("");
    }

    public static void b(int a) {
        if (a < 2) {
        } else {
            b((a / 2));
        }
        System.out.print(a % 2+" ");
    }
    
}
