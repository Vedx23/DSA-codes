package com.dsa.codes;
//Balancing tree
class AVLTree{
    static class Node{
        private int data;
        Node left;
        Node right;
        private int height;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 0;
        }
    }

    private Node root;
    public AVLTree(){
        root = null;
    }

    public void inorder(){
        System.out.println("Inorder : ");
        if(root != null){
            inorder(root);
        }
        System.out.println();
    }

    private void inorder(Node trav){
        if(trav == null){
            return;
        }

        inorder(trav.left);
        System.out.print(trav.data + " ");
        inorder(trav.right);
    }

    public void add(int data){
        if (root == null){
            root = new Node(data);
            return;
        }else{
            addNode(root, null ,data);
        }
    }

    private void addNode(Node trav, Node parent, int data){
        //add node
        if (data < trav.data){
            if (trav.left == null){
                trav.left = new Node(data);
            }else{
                addNode(trav.left, trav, data);
            }
        }else{
            if(trav.right == null){
                trav.right = new Node(data);
            }else{
                addNode(trav.right, trav, data);
            }
        }
        //balance node
        updateHeight(trav);
        int bf = getBalanceFactor(trav);
        if(bf > 1 && data < trav.left.data){
            System.out.println("LL case");
            rightRotate(trav, parent);
            return; //returned for the recursive call
        }
        if (bf < -1 && data > trav.right.data){
            System.out.println("RR case");
            leftRotate(trav, parent);
            return;
        }
        if (bf < -1 && data < trav.right.data){
            System.out.println("RL case");
            rightRotate(trav.right, trav);
            leftRotate(trav, parent);
            return;
        }
        if (bf > 1 && data > trav.left.data){
            System.out.println("LR case");
            leftRotate(trav.left, trav);
            rightRotate(trav, parent);
            return;
        }
    }

    public void delete(int key){
        //delete node

        //balance node
    }

    private void leftRotate(Node axis, Node parent){

        if(axis != null){

          if(axis.right == null){
              return;
          }

          Node newAxis = axis.right;
          axis.right = newAxis.left;
          newAxis.left = axis;

          if(axis == root){
              root = newAxis;
          }else if(parent.left == axis){
              parent.left = newAxis;
          }else {
              parent.right = newAxis;
          }
        }
    }

    private void rightRotate(Node axis,Node parent){

        if(axis != null){
            if(axis.left == null)
                return;

            Node newAxis = axis.left;
            axis.left = newAxis.right;
            newAxis.right = axis;

            if (axis == root){
                root = newAxis;
            } else if (parent.left == axis) {
                parent.left = newAxis;
            }else{
                parent.right = newAxis;
            }
        }
    }

    private int getHeight(Node trav){
        if(trav == null)
            return -1;
        return trav.height;
    }

    private int getBalanceFactor(Node trav){
        if(trav == null){
            return 0;
        }

        return getHeight(trav.left) - getHeight(trav.right);
    }

    private int getTreeHeight(){

        if(root == null){
            return -1;
        }

        return root.height;

    }

    private void updateHeight(Node trav){

        int lh = getHeight(trav.left);
        int rh = getHeight(trav.right);
        trav.height = Integer.max(lh,rh) + 1;
    }

}

public class Example01 {

    public static void main(String[] args) {
        AVLTree avt = new AVLTree();
        avt.add(1);
        avt.add(2);
        avt.add(3);	// RR
        avt.add(0);
        avt.add(-3);	// LL
        avt.add(6);
        avt.add(4);	// RL
        avt.add(-5);
        avt.add(-4);	// LR

        avt.inorder();
    }

}
