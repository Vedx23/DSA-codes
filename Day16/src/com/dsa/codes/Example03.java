package com.dsa.codes;

import java.util.Scanner;

//graphs
//undirected weighted graph
//adjacency matrix implementation
class WGraph{
    private static final int infinity = Integer.MAX_VALUE;
    private int vCount, eCount;
    private int[][] matrix;

    public WGraph(int vCount){
        this.vCount = vCount;
        matrix = new int[vCount][vCount];

        //by default array is filled with false values in java, for c/c++ need to explicitly initialize it
        for(int i = 0; i < vCount; i++){
            for (int j = 0; j < vCount; j++){
                matrix[i][j] = infinity;
            }
        }
    }//end of constructor

    public void accept(Scanner sc){

        System.out.println("Enter the number of edges : ");
        this.eCount = sc.nextInt();

        System.out.println("Enter the edges in this format : [start] [destination] [weight]");
        for (int i = 0; i < eCount; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            matrix[src][dest] = weight;
            matrix[dest][src] = weight;
        }
    }

    public void printMatrix(){
        for (int i = 0; i < vCount; i++){
            System.out.print(i+1 + " | ");
            for (int j = 0; j < vCount; j++){
                System.out.printf(matrix[i][j] == infinity ? " X " : String.valueOf( " " + matrix[i][j]) + " ");
            }
            System.out.println();
        }
    }
}

public class Example03 {
    public static void main(String[] args) {
        WGraph g = new WGraph(7);
        try (Scanner sc = new Scanner(System.in)){
            g.accept(sc);
            g.printMatrix();
        }
    }
}
