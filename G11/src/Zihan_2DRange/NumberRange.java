/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zihan_2DRange;

/**
 *
 * @author 44869
 */
public class NumberRange {

    int[] range;
    NumberRange(int min, int max){
        range = numberRange(min, max);
    }

    public int[] numberRange(int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
            System.out.println("the min is greater than max, the min and max are swiched.");
        }
        int[] nums = new int[max - min + 1];
        int index = 0;
        for (int i = min; i <= max; i++) {
            nums[index] = i;
            index++;
        }
        return nums;
    }
}

class testNumberRange {

    public static void main(String[] args) {
        NumberRange nr = new NumberRange(3, 7);
        for (int i = 0; i < nr.range.length; i++) {
            System.out.print(nr.range[i] + " ");
        }
    }
}
