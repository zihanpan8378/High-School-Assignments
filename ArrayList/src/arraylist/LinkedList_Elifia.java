/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FORMATIVE;


/**
 *
 * @author 44280
 */
public class LinkedList_Elifia {

    Node head;  // head of list

    /* Linked list Node*/
    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }

        @Override
        public String toString() {
            try {
                return "Data: " + data + "\nNext Data: " + next.data;
            } catch (java.lang.NullPointerException n) {
                return "Data: " + data + "\nNext Data: 0";
            }
        }

    }

    /* Inserts a new Node at front of the list. */
    public void addFirst(int new_data) {
        /* 1 & 2: Allocate the Node & Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    public Node getFirstNode() {
        return head;
    }

    /* Inserts a new node after the given prev_node. */
    public void insert(Node prev_node, int new_data) {
        /* 1. Check if the given Node is null */
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        /* 2 & 3: Allocate the Node & Put in the data*/
        Node new_node = new Node(new_data);

        /* 4. Make next of new Node as next of prev_node */
        new_node.next = prev_node.next;

        /* 5. make next of prev_node as new_node */
        prev_node.next = new_node;
    }

    /* Appends a new node at the end.  This method is 
       defined inside LinkedList_Elifia class shown above */
    public void addLast(int new_data) {
        /* 1. Allocate the Node &
           2. Put in the data
           3. Set next as null */
        Node new_node = new Node(new_data);
        /* 4. If the Linked List is empty, then make the new node as head */
        if (head == null) {
            head = new Node(new_data);
            return;
        }
        /* 4. This new node is going to be the last node, so make next of it as null */
        new_node.next = null;

        /* 5. Else traverse till the last node */
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        /* 6. Change the next of last node */
        last.next = new_node;
        return;
    }

    public Node getLastNode() {
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    public Node getMiddleNode() {
        int count = 0;
        Node n = head;
        while (n.next != null) {
            n = n.next;
            count++;
        }
        int mid = count / 2;
        count = 0;
        n = head;
        while (n.next != null) {
            if (count == mid) {
                return n;
            } else {
                n = n.next;
                count++;
            }
        }
        return n;
    }

    public int getMinimum() {
        Node n = head;
        Node min = n;
        while (n.next != null) {
            if (min.data > n.data) {
                min = n;
            } else {
                n = n.next;
            }
        }
        return min.data;
    }

    public int getMaximum() {
        Node n = head;
        Node max = n;
        while (n.next != null) {
            if (max.data < n.data) {
                max = n;
            } else {
                n = n.next;
            }
        }
        return max.data;
    }

    public int getAverage() {
        int total = 0;
        int count = 0;
        Node n = head;
        while (n.next != null) {
            total += n.data;
            n = n.next;
            count++;
        }
        return total / count;
    }

    public Node remove(int index) {
        Node n = head;
        Node prev = head;
        int count = 0;
        while (n.next != null) {
            if (count == index) {
                prev.next = n.next;
                return n;
            } else {
                count++;
                prev = n;
                n = n.next;
            }
        }
        return null;
    }

    /* This function prints contents of linked list starting from the given node */
    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    /* Driver program to test above functions. Ideally this function
       should be in a separate user class.  It is kept here to keep
       code compact */
    public static void main(String[] args) {
        /* Start with the empty list */
        LinkedList_Elifia llist = new LinkedList_Elifia();
        
        // add 6.  So linked list becomes 6-> NUllist
        llist.addLast(6);

        // add 7 at the beginning. So linked list becomes
        // 7->6->NUllist
        llist.addFirst(7);

        // add 1 at the beginning. So linked list becomes
        // 1->7->6->NUllist
        llist.addFirst(1);

        // add 4 at the end. So linked list becomes
        // 1->7->6->4->NUllist
        llist.addLast(4);

        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUllist
        llist.insert(llist.head.next, 8);

        System.out.println("Created Linked list is: ");
        llist.printList();

        System.out.println("\n\nGet First Node\n" + llist.getFirstNode());
        System.out.println("\nGet Last Node\n" + llist.getLastNode());
        System.out.println("\nGet Middle Node\n" + llist.getMiddleNode());
        System.out.println("\nGet Minimum: " + llist.getMinimum());
        System.out.println("Get Maximum: " + llist.getMaximum());
        System.out.println("Get Average: " + llist.getAverage());
        System.out.println("\nRemoving Index 2\n" + llist.remove(2));
    }
}
