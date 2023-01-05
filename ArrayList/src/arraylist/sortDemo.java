/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

/**
 *
 * @author 44869
 */
public class sortDemo {

    public static void boobleSort(int[] numbers) {//从小到大
        for (int i = 0; i < (numbers.length - 1); i++) {
            for (int k = 1; k < (numbers.length - i); k++) {
                if (numbers[k - 1] > numbers[k]) {
                    int temp = numbers[k - 1];
                    numbers[k - 1] = numbers[k];
                    numbers[k] = temp;
                }
            }
        }
    }

    public static void boobleSortString(String[] s) {//从a到z - unicode
        for (int i = 0; i < (s.length - 1); i++) {
            for (int k = 1; k < (s.length - i); k++) {
                if (s[k - 1].compareTo(s[k]) > 0) {
                    String temp = s[k - 1];
                    s[k - 1] = s[k];
                    s[k] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {9, 0, 1, 5, 2, 6};
        boobleSort(nums);
        for (int n : nums) {
            System.out.println(n);
        }

        char c= 'c';
        System.out.println(c+3);//102
        
        String cat = "cat", monkey = "monkey";
        int compare = cat.compareTo(monkey);//compare = -10
        System.out.println(compare);
        String[] sArray = {"cat", "dog", "monkey", "goat"};
        boobleSortString(sArray);
        for (String s : sArray) {
            System.out.println(s);
        }
    }
}
