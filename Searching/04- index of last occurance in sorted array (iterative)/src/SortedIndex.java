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
 * o/p: 3 (index of the leftmost element)
 * 
 * Time complexity: O(logn)
 * Auxiliary space: O(1)
 */
public class SortedIndex {
	
	public static int firstIndex(int[] arr, int search, int start, int end) {
		int res = -1;
		
		while(start < end) {
			int mid = (start+end)/2;
			if (search == arr[mid]) {
				res = mid;
				start = mid+1;
			}
			
			if (search > arr[mid])
				start = mid+1;
			else
				end = mid-1;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,10,10,10,20,20,40};
		int search = 10;
		int start = 0;
		int end = arr.length-1;
//		firstIndex(arr, search, start, end);
		System.out.println(firstIndex(arr, search, start, end));

	}

}
