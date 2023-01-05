/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabonacci_Sequence;

/**
 *
 * @author 44485
 */
public class FabonacciSequence {

    static int count = 0;

    public static void main(String[] args) {
        int a = 5;
        //System.out.println("吓得我抱起了");
        //xiaoyu(2);
        //System.out.println("");
        //System.out.println(f(8));
        //System.out.println("hehe: "+count);
        yang(4);
        System.out.println("");
    }

    public static void yang(int a) {
        if (a == 0) {
            System.out.print("the center");
        } else {
            yang(a - 1);
        }
        System.out.print(" of the onion");
    }

    public static void xiaoyu(int depth) {
        System.out.print("抱着");
        if (depth == 0) {
            System.out.print("我的小鲤鱼");
        } else {
            xiaoyu(--depth);
        }
        System.out.print("的我");
    }

    public static int f(int a) {
        if (a <= 2) {
            System.out.println("count is " + count);
            count++;
            return 1;
        } else {
            return f(a - 1) + f(a - 2);
        }
    }
}
