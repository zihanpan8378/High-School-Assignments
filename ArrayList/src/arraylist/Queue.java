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
public class Queue {

    int[] data;
    int front, rear, maxSize;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        data = new int[maxSize];
        front = -1;
        rear = -1;
    }
    
    /**
     * adds an item to the queue if there is room
     * pre: none
     * post: a new item has been added to the queue
     * @param num
     */
    public void enqueue(int num) {
        if(isEmpty()) {
            front = 0;
            rear = 0;
            data[rear] = num;
            System.out.println("queuing..." + data[rear]);
        } else {
            //rear = (rear+1)%maxSize;
            rear++;
            data[rear] = num;
            System.out.println("queuing..." + data[rear]);}
        
    }
    
    /**
     * Removes front item from the queue and return it
     * pre: Queue contains at least one item
     * past: the front item of the queue has been removed
     * @return 
     */
    public int dequeue() {
        if(front <= rear) {
            front++;
            //System.out.println("dequeue..." + data[front - 1]);
        }
        return data[front - 1];
    }

    /** 
     * pre: Queue may be empty 
     * post: front item is returned 
     * //pre: Queue contains at least one item
     *
     * @return the front item of the queue 
     */
    public int front() {
        if (isEmpty()) {
            return -1;
        } else {
            return data[front];
        }
    }

    /**
     * pre: Queue has at least one
     * post: number of items in the queue 0 <= size
     * @return number of items in this queue
     */
    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            return rear - front + 1;
        }
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

}

class testQueue {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(8);
        
        while(!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
    }
}
