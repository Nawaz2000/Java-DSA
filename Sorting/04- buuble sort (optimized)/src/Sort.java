import java.util.Arrays;
/*
 * Optimized Bubble sort algorithm
 * 
 * Time complexity: O(n^2)
 * Auxiliary space: O(1)
 */
public class Sort {

	public static int[] bubbleSort(int[] arr) {
		int n = arr.length-1;
		for (int i=0; i<n; i++) {
			boolean flag = false; // checks if any swaps happened
			for (int j=0; j<n-i; j++) {
				if (arr[j] > arr[j+1]) {
//					System.out.println("j = " + j);
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
					flag = true;
				}
			}
			
			// if any swaps didn't happen, it means the array is now sorted and we
			// break out of the loop
			if (flag == false)
				break;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,1,3,4,5,6};
		int[] res = bubbleSort(arr);
		System.out.println(Arrays.toString(res));

	}

}
