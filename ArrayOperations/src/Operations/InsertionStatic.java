package Operations;

import java.util.Arrays;

public class InsertionStatic {

    public static void main(String[] args) {
        
    int []arr = {10,20,30,0,0};
    int size = arr.length;
    int cap = 2;
    int key = 7;
    int pos = 1;

    if (size == cap) {
        System.out.println("Array is full");
        System.out.println("Terminating program");
        System.exit(0);
    }

    int i = 0;
    System.out.println("Initial value in i = "+i);

    for(i = cap; i>=pos; i-- ){
        arr[i+1] = arr[i];
    }

    arr[i+1] = key;// this condition is there in my code because I am using index and GFG is using the positions
    System.out.println(Arrays.toString(arr));
    }

}
