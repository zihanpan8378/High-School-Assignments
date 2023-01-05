/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedListDemo;

/**
 *
 * @author maanderson
 */
public class LinkedListO {

    Node head;

    public void add(Student s) {
        Node n = new Node(s);
        n.next = head;
        head = n;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Object removeFirst() {
        Node remove = head;
        head = head.next;
        return remove;
    }

    public Object get(int pos) {

        Node h = head;
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            for (int i = 0; i < pos; i++) {
                h = h.next;
            }
        }
        return h;
    }
}

class testLLO {

    public static void main(String[] args) {
        LinkedListO link = new LinkedListO();
        System.out.println("Printing before filling");
        System.out.println(link.head);

        System.out.println("Printing after filling");
        link.add(new Student("12345", "Zilvi", 89));
        link.head = new Node(new Student("43251", "Ryan", 75));
        link.add(new Student("44356", "Zihan", 100));
        link.add(new Student("44356", "Phillip", 100));
        link.add(new Student("44356", "Harry", 100));

        System.out.println("Before removing..");
//        while (link.head != null) {
//            System.out.println(link.head);
//            if (link.head.next == null) {
//                break;
//            }
//            link.head = link.head.next;
//
//        }

        link.removeFirst();

        System.out.println(link.get(2));
        System.out.println(link.head);
        System.out.println(link.head.next);
        System.out.println(link.head.next.next);
    }
}

class Node {

    Student data;
    Node next;

    public Node(Student s) {
        data = s;
    }

    public String toString() {
        return data.toString();
    }

}
