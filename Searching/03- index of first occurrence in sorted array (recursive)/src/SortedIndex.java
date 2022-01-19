/*
 * Given an array (which may contain duplicate values) and a search integer, we have
 * to find the leftmost occurrence of the element
 * 
 * Ex-
 * 
 * i/p:
 * arr = {1,10,10,10,20,20,40}
 * search = 10
 * 
 * o/p: 1 (index of the leftmost element)
 * 
 * Time complexity: O(logn)
 * Auxiliary space: O(1)
 */
public class SortedIndex {
	
	public static int firstIndex(int[] arr, int search, int start, int end, boolean found) {
		if (start > end) {
			if (found == true)
				return Integer.MAX_VALUE;
			else
				return -1;
		}
		int mid = (start+end)/2;
		if (search == arr[mid]) {
			return Math.min(mid, firstIndex(arr, search, start, mid - 1, true));
		}
		
		if (search > arr[mid])
			return firstIndex(arr, search, mid+1, end, found);
		else
			return firstIndex(arr, search, start, mid-1, found);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,10,10,10,20,20,40};
		int search = 20;
		int start = 0;
		int end = arr.length-1;
//		firstIndex(arr, search, start, end);
		System.out.println(firstIndex(arr, search, start, end, false));

	}

}
