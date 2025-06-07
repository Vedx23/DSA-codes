package Operations;

public class IsArrayIncreasingSorted {
public static void main(String[] args) {
    
    int[] arr = {10,20,30,40,50,60};
    int[] arr2 = {100,90,50};

    for(int i = 0; i < arr2.length - 1 ; i++){
        if (arr2[i] < arr2[i+1]) {
            continue;
        }else{
            System.out.println("Array is not sorted");
            System.exit(0);
        }
    }

    System.out.println("yout array is sorted \n terminating program");

}
}

/*
 * what could be the naive method here?
 * run a loop, take one element
 * compare ahead with another loop if any element smaller than first selected element found -> it will not be sorted
 * 
 */
