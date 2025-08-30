package com.dsa.codes;
//Binary search tree

//note to self

/*
* the null checks inside recursive methods are the last FAR trav null checks
* the null checks in public caller functions for those recursive prints is on the root instead not on trav
* */

import java.util.LinkedList;
import java.util.Queue;
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
            System.out.println("Node added " + data);
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


    private Node[] getNodeWithParent(int key){

        Node trav = root;
        Node parent = null;

        if(trav != null){
            while(trav != null) {
                if (trav.data == key) {
                    return new Node[]{trav, parent}; //parent is either null or not null
                } else {
                    parent = trav;
                    if (key < trav.data) {
                        trav = trav.left;
                    } else {
                        trav = trav.right;
                    }
                }
            }
        }
        return new Node[]{trav, parent}; //element not found i.e trav is null
    }

    //Stack is required
    //not BST specific

    public void depthFirstSearch(int key){
        Stack<Node> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty()){
            Node trav = stk.pop();
            if(key == trav.data){
                System.out.println("Key Found");
                return;
            }else{
                if(trav.right != null){
                    stk.push(trav.right);
                }

                if(trav.left != null) {
                    stk.push(trav.left);
                }
            }
        }
        System.out.println("Key not found");
    }
    //Queue is required
    //not BST specific
    public void breadthFirstSearch(int key){
        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()){
            Node trav = q.poll();
            if(trav.data == key){
                System.out.println("Key Found");
                return;
            }
            else{
                if(trav.left!=null){
                    q.offer(trav.left);
                }
                if(trav.right!=null){
                    q.offer(trav.right);
                }
            }
        }
        System.out.println("Key not found");
    }

    public void delete(int key){

        Node[] targets = getNodeWithParent(key);
        Node target = targets[0];
        Node parent = targets[1];

        if(target == null) {
            System.out.println(key + " not found");
            return;
        }

        if(target.left != null && target.right != null){
            //find inorder successor
            parent = target;
            Node s = target.right;

            while(s.left != null){
                parent = s;
                s = s.left;
            }
            //data replaced with inorder successor data
            target.data = s.data;
            target = s; //target updated with inorder successor to be deleted now
        }

        //node has only left child, right is null
        if(target.right == null){
            if(target == root){
                root = target.left;
            }else if(target == parent.left){
                parent.left = target.left;
            }else{
                parent.right = target.left;
            }
        }else{
            if(target == root){
                root = target.right;
            }else if(parent.left == target){
                parent.left = target.right;
            }else{
                parent.right = target.right;
            }
        }
        //all 3 cases handled.
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

        tree.delete(50);
        tree.delete(10);
        tree.delete(25);
        tree.delete(75);
        tree.delete(90);
        tree.inorder();

    }
}
