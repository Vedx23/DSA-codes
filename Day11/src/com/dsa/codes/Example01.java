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

    private void preOrderNoRec(Node trav) {

        Stack<Node> stk = new Stack<Node>();

        while(trav != null){
        while (trav != null) {
            System.out.print(trav.data + " ");
            if (trav.right != null) {
                stk.push(trav.right);
                }
                trav = trav.left;
            }
            if(!stk.isEmpty())
                trav = stk.pop();
        }
    }

    public void preOrderNoRec(){
        if(root != null){
            System.out.print("preorder nrc => ");
            preOrderNoRec(root);
            System.out.println();
        }
    }

    private void inOrderNoRec(Node trav){
        if (root != null) {
            Stack<Node> stk = new Stack<Node>();
            while(trav != null || !stk.isEmpty()){
            while(trav != null){
                stk.push(trav);
                trav = trav.left;
            }

            if(!stk.isEmpty()){
                trav = stk.pop();
                System.out.print(trav.data + " ");
                trav = trav.right;
            }
            }
        }
    }

    public void inOrderNoRec(){
        if(root != null){
            System.out.print("Inorder no rec => ");
            inOrderNoRec(root);
            System.out.println();
        }
    }

    public void postOrderNoRec(){
        if(root != null){
            System.out.print("postorder nrc => ");
            postOrderNoRec(root);
            System.out.println();
        }
    }

    //cant understand this intuitively - why ?
    private void postOrderNoRec(Node trav){

        Stack<Node> stk = new Stack<>();
        Node preVisited = null;
        //LRV
        while(trav != null || !stk.isEmpty()){
        if(trav!=null){
            stk.push(trav);
            trav = trav.left;
        }else{
            Node top = stk.peek();
            if(top.right != null && preVisited != top.right){
                trav = top.right;
            }else{
                System.out.print(top.data + " ");
                preVisited = stk.pop();
                }
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
        tree.preOrderNoRec();
        tree.inorder();
        tree.inOrderNoRec();
        tree.postorder();
        tree.postOrderNoRec();

    }
}
