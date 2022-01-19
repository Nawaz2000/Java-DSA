/*
 * Binary search implmentation
 * 
 * Time complexity: O(logn)
 * Auxiliary space: O(1)
 */
public class BinarySearch {
	
	public static int binarySearch(int[] arr, int search) {
		int start = 0;
		int end = arr.length-1;
		
		while(start <= end) {
			int mid = (start+end)/2;
			if (search == arr[mid])
				return mid;
			if (search > arr[mid])
				start = mid+1;
			else
				end = mid-1;
		}
		
		return -1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,20,30,40,50,60};
		int search = 504;
		System.out.println(binarySearch(arr, search));

	}

}
