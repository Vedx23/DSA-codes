//SinglyLinkedList

//FileName = Example01.java

package com.dsa.codes;

class SinglyLinkedList{

    static class Node{

        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;}
    }

    Node head;

    public void addFirst(int data){

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;

    }

    public void addLast(int data){

        if(head == null){
            head = new Node(data);
            return;
        }

        Node trav = head;
        while(trav.next != null){
            trav = trav.next;
        }

        trav.next = new Node(data);

    }

    public void deleteFirst(){

        if(head == null){return;}

        head = head.next;

    }

    public void deleteLast(){

        if(head == null){return;}

        if(head.next == null) {head = null; return;}

        Node trav = head;

        while(trav.next.next != null){
            trav = trav.next;
        }

        trav.next = null;

    }

    public void printList(){

        if(head == null){return;}

        Node trav = head;

        while(trav.next != null){
            System.out.print(trav.data + "->");
            trav = trav.next;
        }
        System.out.println(trav.data); //prints the last node
    }

    public void reverseList(){

        Node newHead = null;

        while(head != null) {
            Node temp = head;
            head = head.next;
            temp.next = newHead;
            newHead = temp;
        }

        head = newHead;
    }

    private Node recursionReverse(Node trav){

        if(trav.next == null){
            head = trav;
            return trav;
        }

        Node last = recursionReverse(trav.next);
        last.next = trav;

        trav.next = null;
        return trav;
    }

    public void recursionReverse(){
        recursionReverse(this.head);
    }

    public void findMidpoint(){
        //visualize the alogrithm diagram
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);

    }

}

public class Example01{

    public static void main(String[] args){

        SinglyLinkedList sl = new SinglyLinkedList();

        sl.addFirst(10);
        sl.addFirst(20);
        sl.addFirst(30);
        sl.printList(); //30 20 10

        sl.addLast(50);
        sl.addLast(60);
        sl.printList();//30 20 10 50 60

        sl.deleteLast();
        sl.printList();//30 20 10 50

        sl.deleteFirst();
        sl.printList();//20 10 50
        sl.reverseList();
        sl.printList();

        sl.recursionReverse();
        sl.printList();

        sl.findMidpoint();

    }

}
