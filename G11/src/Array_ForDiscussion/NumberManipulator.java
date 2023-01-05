/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array_ForDiscussion;

/**
 *
 * @author 44869
 */
public class NumberManipulator {

    int num;

    public NumberManipulator(int num) {
        this.num = num;
    }

    public int[] numToArray() {
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = (i + 1);
        }
        return nums;
    }
    
    public double getAverage(){
        double sum = 0;
        for (int i = 0; i < num; i++) {
            sum = sum + numToArray()[i];
        }
        return sum/num;
        
    }
}

class testNM{
    public static void main(String[] args) {
        NumberManipulator nm = new NumberManipulator(10);
    }
}
