package com.dsa.codes;

import java.util.Scanner;

//graphs
//undirected non weighted graph
class Graph{
    private int vCount, eCount;
    private boolean[][] matrix;

    public Graph(int vCount){
        this.vCount = vCount;
        matrix = new boolean[vCount][vCount];

        //by default array is filled with false values in java, for c/c++ need to explicitly initialize it

        for(int i = 0; i < vCount; i++){
            for (int j = 0; j < vCount; j++){
                matrix[i][j] = false;
            }
        }
    }//end of constructor

    public void accept(Scanner sc){

        System.out.println("Enter the number of edges : ");
        this.eCount = sc.nextInt();

        System.out.println("Enter the edges in this format : [start] [destination] [vertex]");
        for (int i = 0; i < eCount; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            matrix[src][dest] = true;
            matrix[dest][src] = true;
        }
    }

    public void printMatrix(){
        for (int i = 0; i < vCount; i++){
            System.out.print(i + " ");
            for (int j = 0; j < vCount; j++){
                System.out.printf("%8s",matrix[i][j]);
            }
            System.out.println();
        }
    }
}

public class Example01 {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        try (Scanner sc = new Scanner(System.in)){
            g.accept(sc);
            g.printMatrix();
        }
    }
}
