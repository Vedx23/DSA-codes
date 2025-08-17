//singly circular linked list
// filename - Example02.java

package com.dsa.codes;

class Scll {
    static class Node {
        private int data;
        private Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        if (!isEmpty()) {
            Node trav = head;

            do {
                System.out.print(trav.data + " ");
                trav = trav.next;
            } while (trav != head);

            System.out.println();
        }
    }


    public void addFirst(int data) {
        if (isEmpty()) {
            head = new Node(data);
            head.next = head;
        } else {
            Node trav = head;
            while (trav.next != head) {
                trav = trav.next;
            }
            Node newNode = new Node(data);
            trav.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            addFirst(data);
        } else {
            Node trav = head;
            while (trav.next != head) {
                trav = trav.next;
            }
            trav.next = newNode;
            newNode.next = head;
        }
    }

    public void deleteFirst() {
        if (!isEmpty()) {
            Node trav = head;
            while (trav.next != head) {
                trav = trav.next;
            }
            trav.next = head.next;
            head = head.next;
        }
    }

    public void deleteLast() {
        if (!isEmpty()) {//contains only 1 element
            if (head.next == head) {
                head = null;
            } else {
                Node trav = head;
                while (trav.next.next != head) {
                    trav = trav.next;
                }
                trav.next = head;
            }
        }
    }
}

public class Example02 {
    public static void main(String[] args) {
        Scll ll = new Scll();
        ll.addFirst(10);
        ll.addFirst(20);
        ll.addFirst(30);
        ll.printList();
        ll.addLast(50);
        ll.addLast(100);
        ll.printList();
        ll.deleteFirst();
        ll.printList();
        ll.deleteLast();
        ll.printList();
    }
}
