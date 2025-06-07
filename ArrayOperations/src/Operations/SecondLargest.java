package Operations;

import java.util.Arrays;

public class SecondLargest {
public static void main(String[] args) {
    int[] arr = {2,0,0,2,5,9,-1};

    boolean flag = arr.length < 2 ? true : false;
    
    if (flag != true) {
        
        int large = Integer.MIN_VALUE;
        int sLarge = Integer.MIN_VALUE;
        int size = arr.length;
        for(int i = 0; i < size; i++){
            if (arr[i] > large) {
                sLarge = large;
                large = arr[i];
            }else if(arr[i] < large && arr[i] > sLarge){
                sLarge = arr[i];
            }
        }

        System.out.println("Array is -> "+Arrays.toString(arr));
        System.out.println("Largest element is + "+large);
        System.out.println("Second largest element is "+sLarge);

    }else{
        System.out.println("Array must have atleast 2 elements !");
    }
}
}