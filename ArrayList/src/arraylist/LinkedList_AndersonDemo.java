/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

/**
 *
 * @author maanderson
 */
class LinkedList_AndersonDemo {

    Node head;  // head of list

    /* Linked list Node*/
    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
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
       defined inside LinkedList class shown above */
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

    /* This function prints contents of linked list starting from the given node */
    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    public int getSize() {
        Node last = head;
        int size = 1;
        while (last.next != null) {
            last = last.next;
            size++;
        }
        return size;
    }

    public Node getFirstNode() {
        return head;
    }

    public Node getLastNode() {
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    public Node getMiddleNode() {
        Node middle = head;
        int count = 1;
        int middleIndex = getSize() / 2;
        while (middle.next != null && count != middleIndex + 1) {
            middle = middle.next;
            count++;
        }
        return middle;
    }

    public Node getMinimum() {
        Node temp = head;
        Node minimum = head;
        while (temp.next != null) {
            if (temp.data < minimum.data) {
                minimum = temp;
            }
            temp = temp.next;
        }
        return minimum;
    }

    public Node getMaximum() {
        Node temp = head;
        Node maximum = head;
        while (temp.next != null) {
            if (temp.data > maximum.data) {
                maximum = temp;
            }
            temp = temp.next;
        }
        return maximum;
    }

    public double getAverage() {
        Node temp = head;
        double total = 0;
        while (temp.next != null) {
            total += temp.data;
            temp = temp.next;
        }
        total += temp.data;
        return total / getSize();
    }

    public void removeByIndex(int num) {
        if (num < getSize()) {
            if (num == 0) {
                head = head.next;
            } else {
                Node temp = head.next;
                Node before = head;
                int count = 1;
                while (temp.next != null && count != num) {
                    before = before.next;
                    temp = temp.next;
                    count++;
                }
                if (temp.next != null) {
                    before.next = temp.next;
                } else {
                    before.next = null;
                }
            }
        } else {
            System.out.println("Out of range!");
        }
    }

    public int checkIndex(int num) {
        int index = 0;
        Node temp = head;
        while (temp.next != null) {
            if (temp.data == num) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public void removeByData(int num) {
        int index = checkIndex(num);
        while (index != -1) {
            removeByIndex(index);
            index = checkIndex(num);
        }
    }

    /* Driver program to test above functions. Ideally this function
       should be in a separate user class.  It is kept here to keep
       code compact */
    public static void main(String[] args) {
        /* Start with the empty list */
        LinkedList_AndersonDemo llist = new LinkedList_AndersonDemo();

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
        llist.addFirst(7);

        llist.addLast(9);

        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUllist
        llist.insert(llist.head.next, 8);

        System.out.println("\nCreated Linked list is: ");
        llist.printList();
        System.out.println("\nSize: " + llist.getSize()
                + "\nFirst: " + llist.getFirstNode().data
                + "\nMiddle: " + llist.getMiddleNode().data
                + "\nLast " + llist.getLastNode().data
                + "\nMinimum " + llist.getMinimum().data
                + "\nMaximum " + llist.getMaximum().data
                + "\nAverage " + llist.getAverage());

        llist.removeByData(7);
        llist.printList();
    }
}
