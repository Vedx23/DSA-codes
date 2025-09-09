package com.dsa.codes;

import java.util.Scanner;
//Prims MST implementation
//weighted non directed graph impl

class Graph{

    private int vCount;
    private int eCount;
    private int[][] matrix;
    private static final int INF = 999;
    public Graph(int v){

        this.vCount = v;
        matrix = new int[vCount][vCount];

        for (int i = 0; i < vCount; i++){
            for(int j = 0; j < vCount; j++){
                matrix[i][j] = INF;
            }
        }

    }

    public void display(){
        for (int i = 0; i < vCount; i++){
            System.out.print(i + " | ");
            for (int j = 0; j < vCount; j++){
                String res = matrix[i][j] == INF ? "X" : String.valueOf(matrix[i][j]);
                System.out.printf("%3s ",res);
            }
            System.out.println();
        }
    }

    public void accept(Scanner sc){
        System.out.println("Enter the number of edges : ");
        this.eCount = sc.nextInt();
        System.out.println("Enter the weights and path in this format [start] [end] [wt] : ");


        for (int i = 1; i < eCount; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int wt = sc.nextInt();
            matrix[start][end] = wt;
            matrix[end][start] = wt;
        }
    }

    private int getMin(int[] key, boolean[] mst){
        int minKey = INF; //find the minimum key to find that vertex
        int minVert = -1; //find the minimum vertex
        for (int i = 0; i < vCount; i++){
            if (!mst[i] && key[i] < minKey){
                minKey = key[i];
                minVert = i;
            }
        }

        return minVert; // min vertex returned so that we can start marking its neighbours.
    }

    public void PrimsMST(int start){
        int mstVertexCount = 0;
        boolean[] mst = new boolean[vCount]; //array to store the vertices which are in MST
        for (int i = 0; i < vCount; i++){
            mst[i] = false;
        }

        int[] parent = new int[vCount];
        for (int i = 0; i < vCount; i++){
            parent[i] = -1; //none of them have any parents right now
        }

        int[] key = new int[vCount];
        for(int i = 0; i < vCount; i++){
            key[i] = INF; // all keys = infinity
        }
        key[start] = 0; //key of the start vertex = 0

        while (mstVertexCount < vCount){
            int u = getMin(key, mst);
            mst[u] = true;
            mstVertexCount++;

            //matrix[u][v] == INF (there is not path)
            //matrix[u][v] != INF (there is a path)
            for (int v = 0; v < vCount; v++){
                if(matrix[u][v]!=INF && !mst[v] && matrix[u][v] < key[v]){
                    parent[v] = u;
                    key[v] = matrix[u][v];
                }
            }
        }//while loop end here


        //print MST
        int totalWt = 0;
        System.out.println("PRIMS MST");
        for (int i = 0; i < vCount; i++){
            int u = parent[i];
            int weight = u != -1 ? matrix[u][i] : 0;
            System.out.println(u +" ---"+ weight +"---> "+ i);
            totalWt += weight;
        }

        System.out.println("Total weight of tree is : " + totalWt);
    }

}

public class Example01 {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            Graph g = new Graph(9);
            g.accept(sc);
            System.out.println();
            g.display();
            g.PrimsMST(0);
        }
    }
}
