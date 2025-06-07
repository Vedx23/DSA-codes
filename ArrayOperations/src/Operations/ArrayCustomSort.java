package Operations;

import java.util.Scanner;

public class ArrayCustomSort {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the length of your array -> ");
        int lengthOfArray = sc.nextInt();

        int[] arr = new int[lengthOfArray];

        System.out.println("Enter the elements of the array");
        
        
        boolean flag = true;
        while (flag == true) {

            System.out.print("Check if array is sorted?\n1. Ascending Order\n2. Descending order\n.3. Exit program");
            int choice = sc.nextInt();
            
            switch (choice) {
                default:
                    System.out.println("Thats an invalid choice!");
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }

        }

    }

}
