package com.dsa.codes;
//merge sort

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;

public class Example02 {

    public static void mergeSort(int[] arr, int left, int right){

        if(left >= right){ return; }
        int mid = (left + right)/2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);

        int[] temp = new int[(right - left) + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while( i <= mid && j <= right){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            }else{
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        while (i <= mid){
            temp[k++] = arr[i++];
        }

        while (j <= right){
            temp[k++] = arr[j++];
        }

        for (k = 0; k < temp.length; k++){
            arr[left + k] = temp[k];
        }

    }

    public static void mergeSort(int[] arr){
        if (arr.length > 1){
            mergeSort(arr, 0, arr.length - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,7,4,2,3,1,6,8,0,5};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
