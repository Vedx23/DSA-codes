package com.dsa.codes;

import java.util.Arrays;
import java.util.Scanner;

public class Example02 {

    public static int linerSearch(int[] arr, int key){

        int i = 0;
        int size = arr.length;

        for(i = 0; i < size; i++){
            if (arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter the size of the array : ");
            int size = sc.nextInt();
            System.out.println("Please enter the elements : ");
            int arr[] = new int[size];

            for(int i = 0; i < arr.length; i++) {
                System.out.print("Enter element at : arr["+i+"]");
                arr[i] = sc.nextInt();
            }

            System.out.println(Arrays.toString(arr));

            System.out.println("Enter the key to be searched : ");
            int key = sc.nextInt();

            int res = linerSearch(arr, key);

            if (res == -1){
                System.out.println("Element not found");
            }else {
                System.out.println("key found at index "+ res);
            }
        }
    }
}
