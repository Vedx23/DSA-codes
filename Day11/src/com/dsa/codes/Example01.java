package com.dsa.codes;
//Binary search tree

//note to self

/*
* the null checks inside recursive methods are the last FAR trav null checks
* the null checks in public caller functions for those recursive prints is on the root instead not on trav
* */

import java.util.Stack;

class BST{

    static class Node{
        private Node left;
        private Node right;
        private int data;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public BST(){
        this.root = null;
    }

    public void addNode(int data){

        if(root == null){
            root = new Node(data);
        }else{

            Node trav = root;

            while(true){
                if(data < trav.data){
                    if(trav.left == null){
                        trav.left = new Node(data);
                        break;
                    }else{
                        trav = trav.left;
                    }
                }else{
                    if(trav.right == null){
                        trav.right = new Node(data);
                        break;
                    }else{
                        trav = trav.right;
                    }
                }
            }

            System.out.println("Node added " + data);
        }
    }

    public void searchNode(int key){

        if(root == null){
            System.out.println("tree is empty"); return;
        }else{

            Node trav = root;

            while(trav != null){
                if(trav.data == key){
                    System.out.println("element found");
                    return;
                }else{
                    if(key < trav.data){
                        trav = trav.left;
                    }else{
                        trav = trav.right;
                    }
                }
            }
            System.out.println("element not found");
        }

    }

    private void preorder(Node trav){

        if(trav == null){
            return;
        }

        //V L R

        System.out.print(trav.data + " ");

        preorder(trav.left);
        preorder(trav.right);

    }

    private void inorder(Node trav){

        if(trav == null){
            return;
        }

        //L V R
        inorder(trav.left);

        System.out.print(trav.data + " ");

        inorder(trav.right);
    }

    private void postorder(Node trav){

        // L R V

        if(trav == null){
            return;
        }

        postorder(trav.left);
        postorder(trav.right);

        System.out.print(trav.data + " ");

    }

    public void preorder(){
        if(root != null){
            System.out.print("preorder rec => ");
            preorder(root);
            System.out.println();
        }
    }

    public void inorder(){
        if(root != null){
            System.out.print("inorder rec => ");
            inorder(root);
            System.out.println();
        }
    }

    public void postorder(){
        if(root != null){
            System.out.print("postorder rec => ");
            postorder(root);
            System.out.println();
        }
    }

    private void preOrderNoRec(Node trav){

        Stack<Node> stk = new Stack<Node>();

        while (trav != null || !stk.isEmpty()) {
            while (trav != null) {
                if (trav.right != null) {
                    stk.push(trav.right);
                }
                System.out.println(trav.data);
                trav = trav.left;
            }
        }
    }
}

public class Example01 {

    public static void main(String[] args) {

        BST tree = new BST();

        tree.addNode(50);
        tree.addNode(90);
        tree.addNode(100);
        tree.addNode(110);
        tree.addNode(127);
        tree.addNode(75);
        tree.addNode(40);
        tree.addNode(45);
        tree.addNode(20);
        tree.addNode(10);
        tree.addNode(25);

        tree.preorder();
        tree.inorder();
        tree.postorder();

    }
}
