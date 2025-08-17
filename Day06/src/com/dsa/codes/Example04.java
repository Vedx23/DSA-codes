//filename = Example04.java
//doubly circular linked list

package com.dsa.codes;

class DoublyCircularLinkedList{
    static class Node{
        private int data;
        private Node next;
        private Node prev;

        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;

    public boolean isEmpty(){return head == null;}
    public void addFirst(int data){

        if(isEmpty()){
            Node newNode = new Node(data);
            head = newNode;
            head.next = head;
            head.prev = head;
        }else{
            Node newNode = new Node(data);
            newNode.next = head;
            newNode.prev = head.prev;
            head = newNode;
        }

    }
    public void addLast(int data){

        if(isEmpty()){
            addFirst(data);
        }else{
            Node newNode = new Node(data);
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev = newNode;

        }

    }
    public void deleteFirst(){
        if(!isEmpty()){

            if(head.next == head){
                head = null;
            }else{
                Node trav = head;

                head.prev = head.next;
                head.next.prev = head.prev;
                head = head.next;

            }

        }
    }
    public void deleteLast(){
        if(!isEmpty()){

            if(head.next == head){
                head = null;
            }else{

                head.next.prev = head.prev.prev;
                head.prev.prev.next = head;
            }
        }
    }

    public void printList(){
        Node trav = head;
        do{
            System.out.print(trav.data);
            trav = trav.next;
        }while( trav != head );
        System.out.println();
    }
}

public class Example04{

    public static void main(String[] args){
        DoublyCircularLinkedList dcll = new DoublyCircularLinkedList();
        dcll.addFirst(10);
        dcll.addFirst(20);
        dcll.addFirst(30);
        dcll.printList();
        dcll.addLast(50);
        dcll.addLast(60);
        dcll.printList();
        dcll.deleteFirst();
        dcll.printList();
        dcll.deleteLast();
        dcll.printList();
    }

}
