import java.util.Arrays;
/*
 * Counting sort
 * 
 * Time complexity: O(n+k), all elements in the array are in the range 0 to k-1
 * Auxiliary space: O(n+k)
 */
public class CountingSort {

	public static void countingSort(int[] arr, int k) {
		int n = arr.length;
		int[] count = new int[k];
		int[] res = new int[n];
		
		for (int i=0; i<n; i++)
			count[arr[i]]++;
		
		System.out.println(Arrays.toString(count));
		
		for (int i=1; i<k; i++)
			count[i] += count[i-1];
		
		System.out.println(Arrays.toString(count));
		
		for (int i=n-1; i>=0; i--) {
			res[count[arr[i]]-1] = arr[i];
			count[arr[i]]--;
		}
		
		// copy the result array into original array
		arr = Arrays.copyOfRange(res, 0, n);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,6,5,2};
		int k = 7;
		countingSort(arr, k);

	}

}
