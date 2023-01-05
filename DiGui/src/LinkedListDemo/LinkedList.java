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
public class LinkedList {
    
    Node head;
    public void add(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }
       
    static class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data = data;
        }
        public String toString(){
            return "Content " + this.data;
        }      
    }
    public static void main(String[] args) {
        LinkedList link = new LinkedList();
        
        link.head = new Node(1);        
        Node second = new Node(3);
        link.head.next = second;
        link.add(7);
        
        System.out.println(link.head);
        System.out.println(link.head.next);
        System.out.println(link.head.next.next);
    }
}

