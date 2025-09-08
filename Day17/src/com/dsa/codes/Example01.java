package com.dsa.codes;

//Graph adj impl
//non directed
//non weighted graph
//DFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Graph{


    private int vCount;
    private int eCount;
    private boolean[][] matrix;

    public Graph(int vertices){
        this.vCount = vertices;

        matrix = new boolean[vCount][vCount];
    }

    public void accept(Scanner sc){
        System.out.println("Enter the number of edges : ");
        int eCount = sc.nextInt();

        System.out.println("Enter the edges in this format [start] [end]");
        for (int i = 0; i < eCount; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            matrix[start][end] = true;
            matrix[end][start] = true;
        }
    }

    public void print(){
        for (int i = 0; i < vCount; i++){
            System.out.print(i+1 + " ");
            for(int j = 0; j < vCount; j++){
                System.out.print((matrix[i][j] ? " T " : " F ") + " ");
            }
            System.out.println();
        }
    }

    public void DFS(int startVertex){

        System.out.print("DFS traversal starting from ["+startVertex+"] : ");

        Stack<Integer> stk = new Stack<>();
        boolean[] marked = new boolean[vCount];
        stk.push(startVertex);
        marked[startVertex] = true;

        while(!stk.isEmpty()){
            int v = stk.pop();
            System.out.print( v + " ");
            for (int i = 0; i < vCount; i++){
                if(matrix[v][i] && !marked[i])
                {stk.push(i); marked[i] = true;}
            }
        }
    }

    public void BFS(int startVertex){

        Queue<Integer> q = new LinkedList<>();
        boolean[] marked = new boolean[vCount];
        q.offer(startVertex);
        marked[startVertex] = true;
        System.out.print("BFS traversal starting from : [" + startVertex +"] : ");
        while (!q.isEmpty()){
            int v = q.poll();
            System.out.print(v + " ");
            for (int i = 0; i < vCount; i++){
                if (matrix[v][i] && !marked[i]){
                    q.offer(i);
                    marked[i] = true;
                }
            }
        }
    }
}

public class Example01 {

    public static void main(String[] args) {
        Graph g = new Graph(6);
        try(Scanner sc = new Scanner(System.in)){
            g.accept(sc);
            g.print();
            g.DFS(1);
            System.out.println();
            g.BFS(1);
        }
    }
}
