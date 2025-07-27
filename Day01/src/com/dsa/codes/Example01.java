package com.dsa.codes;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Example01 {
    //factorial
    public static void factorial(){
        try(Scanner sc = new Scanner(System.in);){
            System.out.println("Enter a number : ");
            int fact = sc.nextInt();
            int res = 1;
            while (fact != 0){
                res = res * fact;
                fact--;
            }

            System.out.println("fact is : "+res);
        }
    }

    public static void displayMatrix(){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void decimalToBinary(int n){
        Stack<Integer> stk = new Stack<>();

        while(n != 0){
            int r = n % 2;
            stk.push(r);
            n /= 2;
        }

        while(!stk.isEmpty()){
            System.out.print(stk.pop() + " ");
        }
    }

    public static void main(String[] args) {
        //factorial();
        //displayMatrix();
        decimalToBinary(9);
    }
}
