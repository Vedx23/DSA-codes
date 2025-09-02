package com.dsa.codes;

//undirected non weighted graph
//adjacency list implementation

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class LGraph{

    private List<Integer>[] matrix;
    private int vCount, eCount;

    public LGraph(int vCount){

        this.vCount = vCount;
        matrix = new List[vCount];
        for (int i = 0; i < vCount; i++){
            matrix[i] = new ArrayList<>();
        }
    }

    public void accept(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Print number of edges : ");
        eCount = sc.nextInt();
        System.out.println("enter the edges in src - dest format");
        for (int i = 0; i < eCount; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            matrix[src].add(dest);
            matrix[dest].add(src);
        }
    }

    public void display(){
        for (int i = 0; i < vCount; i++){
            System.out.print(i + " : ");
            for (int j : matrix[i]){
                System.out.print(j + " -> ");
            }
            System.out.println();
        }
    }
}

public class Example02 {
    public static void main(String[] args) {
        LGraph lg = new LGraph(7);
        lg.accept();
        lg.display();
    }
}
