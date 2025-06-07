package Operations;

import java.util.Arrays;

public class LargestElement {

    public static void main(String[] args) {
        int[] arr = {11,3,6,12,4};

        int largest = arr[0];
        int resIdx = 0;
        for(int i = 0; i < arr.length ; i++){
            if (arr[i] > largest) {
                largest = arr[i];
                resIdx = i;
            }
        }
        System.out.println("Largest element in the array is = "+largest+" Its index is -> "+resIdx+" and pos is -> "+ (resIdx+1));
        System.out.println("Array is -> "+Arrays.toString(arr));
    }
}
