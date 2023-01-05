/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 *
 * @author 44869
 */
public class StackInArrayList<E> {

    ArrayList<E> data;

    public StackInArrayList() {
        data = new ArrayList();
    }

    public void push(E item) {
        data.add(item);
    }

    public E pop() {
        if (!isEmpty()) {
            return data.remove(data.size() - 1);
        } else {
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty() {
        return data.size() == 0; //data.isEmpty();
    }
    
    public E top() {
        return data.get(data.size() - 1);
    }
    
    public void makeEmpty() {
        data.clear();
    }
    
}

class testStackInArrayList {
    public static void main(String[] args) {
        StackInArrayList s = new StackInArrayList();
        
        s.push("1");
        s.push("2");
        s.pop();
        s.pop();
        
    }
}
