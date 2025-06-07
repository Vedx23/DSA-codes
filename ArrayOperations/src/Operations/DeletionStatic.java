package Operations;

import java.util.Arrays;

public class DeletionStatic {

    public static void main(String[] args) {
        int size = 5;
        int cap = 4;
        int key = 62; //element to delete
        int []arr = {6,2,12,4,0};

        int i = 0;
        for(i = 0; i < size - 1; i++){
            if (arr[i] == key) {
                break;
            }
        }

        if (i == size - 1 && i != key) {
            System.exit(0);
            System.out.println("Could not find the element");
        }

        for(int j = i; j<size-1; j++){
            arr[j] = arr[j+1];
        }

        System.out.println(Arrays.toString(arr));

    }
}
