package com.dsa.codes;

import java.util.Arrays;

//ARRAY NEEDS TO BE SORTED !!! for Binary Search!!!
public class Example03 {

    public static void binarySearch(int[] arr,int key){
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length - 1;
        while(l<=r){
            int mid = (l+r)/2;
            if (arr[mid] == key){
                System.out.println("element found at idx : " + mid);
                return;
            }else if(key < arr[mid]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        System.out.println("Key not found");
    }
    public static void main(String[] args) {
        int[] arr = {11,2233,44,66,77,88,23,545,12,54};
        binarySearch(arr,44);
    }
}
