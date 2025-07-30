package com.dsa.codes;

import java.util.Arrays;

public class Example02 {

    public static int[] selectionSort(int[] arr){

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

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,62,1,46,89,0,0,-1};
        System.out.println(Arrays.toString(arr));
        int[] sorted = selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
