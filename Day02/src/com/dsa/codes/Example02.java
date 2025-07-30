package com.dsa.codes;

import java.util.Arrays;

public class Example02 {

    public static void selectionSort(int[] arr){
        long start = System.nanoTime();
        int size = arr.length;

        for (int i = 0; i < size - 1; i++){
            for(int j = i; j < size; j++){
                if(arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        long end = System.nanoTime();

        System.out.println("Time Taken - " + (end - start) + "ns");
    }

    public static void bubbleSort(int[] arr){

        long start = System.nanoTime();

        int size = arr.length;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        long end = System.nanoTime();

        System.out.println("Time taken - " + (end-start) + "ns");

    }

    public static void improvedBubbleSort(int[] arr){

        long start = System.nanoTime();

        int size = arr.length;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        long end = System.nanoTime();

        System.out.println("Time taken - " + (end-start) + "ns");

    }

    public static void main(String[] args) {
        int[] arr = {2,4,62,1,46,89,0,0,-1};
        System.out.println(Arrays.toString(arr));

        selectionSort(arr);

        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));

        improvedBubbleSort(arr);

        System.out.println(Arrays.toString(arr));

    }
}
