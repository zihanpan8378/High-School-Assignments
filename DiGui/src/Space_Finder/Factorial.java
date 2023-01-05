/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Space_Finder;

/**
 *
 * @author 44485
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(f(4));
    }
    
    public static int f(int a){
        if(a==1){
            return 1;
        }
        else{
            return f(a-1)*a;
        }
    }
}
