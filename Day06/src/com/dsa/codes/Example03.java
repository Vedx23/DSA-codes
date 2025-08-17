//filename = Example03.java
//Doubly linkedlist

package com.dsa.codes;

class DoublyLinkedList{

    static class Node{
            private int data;
            private Node prev;
            private Node next;

    public Node(int data){
                this.data = data;
                this.next = null;
                this.prev = null;
        }
    }

    Node head;

    public boolean isEmpty(){return head == null;}

    public void addFirst(int data){
        if(isEmpty()){
            head = new Node(data);
        }else{
            Node newNode = new Node(data);
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int data){

        if(isEmpty()){
            head = new Node(data);
        }else{
            Node trav = head;
            while(trav.next != null){
                trav = trav.next;}
            Node newNode = new Node(data);
            trav.next = newNode;
            newNode.prev = trav;
        }

    }
    public void deleteFirst(){
        if(!isEmpty()){
            head = head.next;
            head.prev = null;
        }
    }
    public void deleteLast(){
        if(!isEmpty()){
            Node trav = head;

            if(trav.next.next == null){
                trav.next = null;
            }else{

                while(trav.next.next != null){
                    trav = trav.next;
                }
                trav.next = null;
            }
        }
    }
    public void printList(){
        if(!isEmpty()){
            Node trav = head;

            while(trav.next != null){
                System.out.print(trav.data + "->");
                trav = trav.next;
            }
            System.out.print(trav.data);
            System.out.println();

        }
    }
}

public class Example03{
    public static void main(String[] args){
        //main
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(10);
        dll.addFirst(20);
        dll.addFirst(30);
        dll.printList();
        dll.addLast(80);
        dll.addLast(90);
        dll.printList();
        dll.deleteFirst();
        dll.printList();
        dll.deleteLast();
        dll.printList();
    }
}
