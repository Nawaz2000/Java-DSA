/*
 * implementation of recursive binary search
 * 
 * Time complexity: O(logn)
 * Auxiliary space: O(1)
 */
public class RecursiveBinarySearch {

	public static int binarySearch(int[] arr, int start, int end, int search) {
		int mid = (start+end)/2;
		
		if (search == arr[mid])
			return mid;
		if (start > end)
			return -1;
		
		if (search > arr[mid])
			return binarySearch(arr, mid+1, end, search);
		else
			return binarySearch(arr, start, mid-1, search);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,20,30,40,50,60};
		int start = 0;
		int end = arr.length-1;
		int search = 605;
		System.out.println(binarySearch(arr, start, end, search));

	}

}
