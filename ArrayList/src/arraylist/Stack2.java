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
public class Stack2 {

    ArrayList<Integer> data;
    int top;

    Stack2() {
        data = new ArrayList();
        top = -1;
    }

    public void push(int n) {
        data.add(n);
        top++;
    }

    public boolean empty() {
        return top < 0;
    }

    public int peak() {
        return data.indexOf(top);
    }

    public int pop() {
        int pop = 0;
        if (top >= 0) {
            pop = data.get(top);
            //data.set(top, 0);
            top--;
        }
        return pop;
    }

    public int size() {
        return top - 1;
    }

    public int search(int n) {
        int i;
        for (i = 0; i <= top; i++) {
            if(data.get(i) == n){
                break;
            }
        }
        
        
            return top-i+1;
        
    }
}

class testStack2 {

    public static void main(String[] args) {
        Stack2 s = new Stack2();
        s.push(9);
        s.push(7);
        s.push(10);
        s.push(3);
        s.push(5);

        System.out.println("top: " + s.peak());
        

        System.out.println("\n" + s.search(9));
        System.out.println();

        while (s.empty() != true) {
            if (s.empty() == true) {
                break;
            } else {
                System.out.print(s.pop() + " ");
            }
        }

        
    }
}
