package Operations;

import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

class MakeApiCall{

    private final String urlText = "https://api.api-ninjas.com/v1/jokes";
    private URL url;

    public void makeCall() throws Exception{

        Properties credentials = new Properties();
        FileInputStream fs = new FileInputStream("./config.properties");
        credentials.load(fs);
        fs.close();

        String apiKey = credentials.getProperty("api.Key");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("X-Api-Key",apiKey);
        int responseCode = conn.getResponseCode();
        System.out.println("Got HTTP response from - "+urlText+" with HTTP status code - " + responseCode);
    }

}

public class ArrayCustomSort {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of your array -> ");
        int lengthOfArray = sc.nextInt();
        int[] arr = new int[lengthOfArray];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < lengthOfArray; i++) {
            System.out.print("Enter element for : arr[" + i + "] = ");
            arr[i] = sc.nextInt();
            System.out.printf("\n");
        }
        System.out.println("Your array is -> " + Arrays.toString(arr));
        for (int i = 0; i < 3; i++) {
            System.out.printf(". ");
            Thread.sleep(1000);
        }
        boolean flag = true;
        while (flag == true) {
            System.out.print("\nCheck if array is sorted?\n1. Ascending Order\n2. Descending order\n3. Exit\n");
            int choice = sc.nextInt();
            switch (choice) {
                default:
                    System.out.println("Thats an invalid choice!");
                    break;
                case 1:
                    for (int i = 0; i < lengthOfArray - 1; i++) {
                        if (arr[i] > arr[i+1]) {
                           continue;
                        }else{
                            System.out.println("Array is not sorted in asc order");
                        }
                    }
                    
                    break;
                case 2:
                    for (int i = 0; i < lengthOfArray - 1; i++) {
                        if (arr[i] < arr[i+1]) {
                            System.out.println("Array is not sorted in desc order");
                        }
                        break;
                    }
                    break;
                case 3:
                    flag = false;
                    break;
            }
        }
        System.out.println("Dramatically Exiting Program . . .");

        for(int i = 0,x = 500; i < 3; i++){
            Random rnd = new Random();
            Thread.sleep(i*x*rnd.nextInt(3));
        }

        System.out.println("Now fetching something from the internet");

        try{
            MakeApiCall call = new MakeApiCall();
            call.makeCall();
        } catch (Exception e) {
            e.getCause();
            e.getMessage();
        }

        System.out.println("something went wrong, closing program for real");
        sc.close();
    }
}
