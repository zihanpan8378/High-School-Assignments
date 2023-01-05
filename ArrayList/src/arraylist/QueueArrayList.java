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
public class QueueArrayList<E> {

    ArrayList<E> data = new ArrayList();
    int front, rear;

    public QueueArrayList() {
        front = 0;
        rear = -1;
    }

    public void enqueue(E item) {

        data.add(item);
        rear++;
        System.out.println("enqueue... " + item);
    }

    public E dequeue() {
        if (!isEmpty()) {
            System.out.print("dequeue... ");
            front++;
            return data.get(front - 1);
        } else {
            System.out.print("finish.");
            return null;
        }
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public int Size() {
        if (isEmpty()) {
            return 0;
        } else {
            return rear - front + 1;
        }
    }

    public E front() {
        if (isEmpty()) {
            return null;
        } else {
            return data.get(front);
        }
    }

}

class testQueueArrayList {

    public static void main(String[] args) {
        QueueArrayList q = new QueueArrayList();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

    }
}
