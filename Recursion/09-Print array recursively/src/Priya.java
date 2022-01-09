import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Priya {

	public static void printArrayRecursively(int arr[], int n)
    {
        // Print the array elements recursively
        if (n == 0)
            return;
            
        printArrayRecursively(arr, n-1);
        System.out.print(arr[n-1] + " ");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] arr = {1,2,3,4,5};
		printArrayRecursively(arr, n);

	}

}
