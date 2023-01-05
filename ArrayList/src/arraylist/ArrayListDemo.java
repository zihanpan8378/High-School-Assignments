/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import java.util.ArrayList;

/**
 *
 * @author 44869
 */
public class ArrayListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        int total = 0;

        list.add(12);
        list.add(20);
        list.add(30);
        list.add(1, 33);
        list.add(45);
        list.add(67);
        list.set(0, 11);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if (i % 2 == 0) {
                list.remove(i);
            }
        }
        System.out.println(list.size());
        
        for (int i = 0; i < list.size(); i++) {
            total+=list.get(i);
            
        }
        System.out.println(total);
        System.out.println(list);
        
        System.out.println("zwer".compareTo("we"));
    }

}
