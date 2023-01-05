/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jiecheng;

/**
 *
 * @author 44869
 */
public class jiecheng {

    int n;

    public int times(int n) {
        int result = n;
        if (n == 1) {
            return result;
        } else {
            return result = result * times(n - 1);
        }
    }
    
    public static void main(String[] args) {
        jiecheng j = new jiecheng();
        System.out.println(j.times(5));
    }
}
