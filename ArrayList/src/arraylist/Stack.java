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
public class Stack {

    //Integer y = new Integer(10);
    int[] data;
    int top;

    public Stack(int maxItems) {
        data = new int[maxItems];
        top = -1;
    }

    public void push(int num) {
        if (top < data.length - 1) {
            top++;
            data[top] = num;
        }
    }

    public boolean empty() {
        return top < 0;
    }

    public int peak() {
        if (empty() == false) {
            return data[top];
        } else {
            return 0;
        }
    }

    public int pop() {
        int pop = 0;
        if (top >= 0) {
            pop = data[top];
            data[top] = 0;
            top--;
        }
        return pop;
    }

    public int size() {
        if (empty() == false) {
            return top + 1;
        } else {
            return 0;
        }
    }

    public int search(int n) {
        int i;
        for (i = 0; i < top; i++) {
            if (data[i] == n) {
                break;
            }
        }
        if (i == top) {
            return -1;
        } else {
            return i+1;
        }
    }

}

class testStack {

    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push(9);
        s.push(7);
        s.push(10);
        s.push(3);

        System.out.println("top: " + s.peak());
        for (int i = 0; i < s.size(); i++) {
            System.out.print(s.data[i] + " ");
        }
        
        System.out.println();
        
        while(s.empty() != true){
            if(s.empty() == true){
                break;
            } else{
                System.out.print(s.pop() + " ");
            }
        }
        
        System.out.println("\n" + s.search(10));
    }
}
