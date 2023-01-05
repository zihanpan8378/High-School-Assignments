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
public class boobleSortDemo {

    public static void bubbleSortMethod(int[] arr) {
        int i, temp, len = arr.length;
        boolean changed;
        do {
            changed = false;
            len -= 1;
            for (i = 0; i < len; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    changed = true;
                }
            }
        } while (changed);
    }

}

class test {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 2};
        boobleSortDemo d = new boobleSortDemo();
        d.bubbleSortMethod(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
