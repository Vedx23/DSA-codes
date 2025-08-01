import java.util.Arrays;

public class Example01 {

    public static void insertionSort(int[] arr){
       int size = arr.length;

       for(int i = 1; i < size; i++){
           int key = arr[i];
           int j = i - 1;

           while(j >= 0 && arr[j] > key){
               arr[j+1] = arr[j];
               j--;
           }

           arr[j+1] = key;
       }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,8,5,389,237,0,0};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
